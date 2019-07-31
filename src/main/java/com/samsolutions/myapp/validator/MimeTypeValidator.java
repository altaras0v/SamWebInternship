package com.samsolutions.myapp.validator;

import com.samsolutions.myapp.config.ApplicationProperties;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class for file validation
 * Check content-type of uploading file
 * And check magic bytes of uploading file
 * Almost all files have unique magic bytes (first bytes in file)
 */
public class MimeTypeValidator {

	private static ApplicationProperties properties = new ApplicationProperties();
	/**
	 * List with file extensions
	 */
	private static final List<String> TYPES_OF_FILE = Arrays.asList(properties.getProperty("TYPES_OF_FILE")
			.split(","));
	/**
	 * List with MIME types
	 */
	private static final List<String> CONTENT_TYPE_OF_FILE = Arrays.asList(properties.getProperty("CONTENT_TYPE_OF_FILE")
			.split(","));
	/**
	 * Map with extensions and MIME types.
	 */
	private static final Map<String, String> TYPES_MAP = createMapFromLists(TYPES_OF_FILE, CONTENT_TYPE_OF_FILE);

	/**
	 * Array with magic bytes
	 */
	private static int[] fBytes = new int[11];

	/**
	 * Create Map from file extensions and MIME types of files
	 * @param keys - file extensions
	 * @param values - MIME types
	 * @return map with file extensions like key and MIME types like value. Used for comparing MIME types.
	 */
	public static Map<String, String> createMapFromLists(List<String> keys, List<String> values) {
		return IntStream.range(0, keys.size())
				.boxed()
				.collect(Collectors.toMap(keys::get, values::get));
	}

	/**
	 * Check content-type (MIME type of file)
	 * Method get content-type of file and compares with content-type that must have this file
	 *
	 * @param file          - file that will be upload
	 * @param fileExtension - file extension.The corresponding type is in TYPES_MAP
	 * @return true that MIME types are the same.
	 */
	public static boolean checkContentType(UploadedFile file, String fileExtension) {
		return TYPES_MAP.get(fileExtension)
				.equals(file.getFile()
						.getContentType());
	}

	/**
	 * Check first bytes (magic bytes) of file
	 * Method compare magic bytes of file with bytes that file must have
	 * @param data - array of bytes (uploading file bytes)
	 * @param fileExtension - extension of
	 * @return true that magic bytes are the same
	 */
	public static boolean checkTypeByBytes(byte[] data, String fileExtension) {

		String contentType = TYPES_MAP.get(fileExtension);
		byte[] header = new byte[11];

		//Copy first bytes of file (magic bytes) to separate array
		System.arraycopy(data, 0, header, 0, Math.min(data.length, header.length));

		// Interpret 8 bits as a number which takes values from 0 to 255 inclusive.
		// 0xff is the int constant
		fBytes = IntStream.range(0, 11)
				.map(i -> header[i] & 0xff)
				.toArray();

		switch (contentType) {
			case ("application/msword"):
			case ("application/vnd.ms-excel"):
			case ("application/vnd.ms-powerpoint"):
				return isMicrosoftOfficeFormat();
			case ("application/pdf"):
				return isPdf();
			case ("audio/mpeg"):
				return isMp3();
			case ("image/png"):
				return isPng();
			case ("image/jpeg"):
				return isJpg();
			case ("application/x-zip-compressed"):
				return isZip();
			case ("video/mp4"):
				return isMp4();
			case ("application/vnd.openxmlformats-officedocument.wordprocessingml.document"):
			case ("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"):
			case ("application/vnd.openxmlformats-officedocument.presentationml.presentation"):
				return isMicrosoftOfficeXMLFormat();
			case("video/avi"):
				return isAvi();
			case ("application/octet-stream"):
				return isDjvu() || isRar();		// getContentType() method define rar and djvu like octet-stream
			case ("text/plain"):
				return true;					// true cause txt format does not have magic bytes
		}
		return false;
	}

	/**
	 * Check that file format is Microsoft Office
	 * (doc,ppt,xls)
	 * @return true that file is Microsoft Office format
	 */
	private static boolean isMicrosoftOfficeFormat() {
		return fBytes[0] == 0xD0 && fBytes[1] == 0xCF && fBytes[2] == 0x11 && fBytes[3] == 0xE0 && fBytes[4] == 0xA1 &&
				fBytes[5] == 0xB1 && fBytes[6] == 0x1A && fBytes[7] == 0xE1;
	}

	/**
	 * Check that file format is PDF
	 * @return true that file is PDF format
	 */
	private static boolean isPdf() {
		return fBytes[0] == 0x25 && fBytes[1] == 0x50 && fBytes[2] == 0x44 && fBytes[3] == 0x46 && fBytes[4] == 0x2d &&
				fBytes[5] == 0x31 && fBytes[6] == 0x2e;
	}

	/**
	 * Check that file format is MP3
	 * @return true that file is MP# format
	 */
	private static boolean isMp3() {
		return (fBytes[0] == 0x49 && fBytes[1] == 0x44 && fBytes[2] == 0x33) ||
				(fBytes[0] == 0xff && fBytes[1] == 0xfb && fBytes[2] == 0x30);
	}

	/**
	 * Check that file format is PNG
	 * @return true that file is PNG format
	 */
	private static boolean isPng() {
		return fBytes[0] == 137 && fBytes[1] == 80 && fBytes[2] == 78 && fBytes[3] == 71 && fBytes[4] == 13 &&
				fBytes[5] == 10 && fBytes[6] == 26 && fBytes[7] == 10;
	}

	/**
	 * Check that file format is JPG
	 * @return true that file is JPG format
	 */
	private static boolean isJpg() {
		return (fBytes[0] == 0xFF && fBytes[1] == 0xD8 && fBytes[2] == 0xFF) ||
				((fBytes[3] == 0xE1) && (fBytes[6] == 'E' && fBytes[7] == 'x' && fBytes[8] == 'i' &&
						fBytes[9] == 'f' && fBytes[10] == 0));
	}

	/**
	 * Check that file format is ZIP
	 * @return true that file is ZIP format
	 */
	private static boolean isZip() {
		return fBytes[0] == 'P' && fBytes[1] == 'K';
	}
	/**
	 * Check that file format is MP4
	 * @return true that file is MP4 format
	 */
	private static boolean isMp4() {
		return fBytes[0] == 0x00 && fBytes[1] == 0x00 && fBytes[2] == 0x00 && fBytes[3] == 0x18 && fBytes[4] == 0x66 &&
				fBytes[5] == 0x74 && fBytes[6] == 0x79 && fBytes[7] == 0x70;
	}

	/**
	 * Check that file format is Microsoft Office XML format
	 * (docx,pptx,xlsx)
	 * @return true that file is Microsoft Office XML format
	 */
	private static boolean isMicrosoftOfficeXMLFormat() {
		return fBytes[0] == 0x50 && fBytes[1] == 0x4B && fBytes[2] == 0x03 && fBytes[3] == 0x04 && fBytes[4] == 0x14 &&
				fBytes[5] == 0x00 && fBytes[6] == 0x06 && fBytes[7] == 0x00;
	}

	/**
	 * Check that file format is RAR
	 * @return true that file is RAR format
	 */
	private static boolean isRar() {
		return fBytes[0] == 0x52 && fBytes[1] == 0x61 && fBytes[2] == 0x72 && fBytes[3] == 0x21 && fBytes[4] == 0x1A &&
				fBytes[5] == 0x07;
	}

	/**
	 * Check that file format is DJVU
	 * @return true that file is DJVU format
	 */
	private static boolean isDjvu() {
		return fBytes[0] == 0x41 && fBytes[1] == 0x54 && fBytes[2] == 0x26 && fBytes[3] == 0x54 && fBytes[4] == 0x46
				&& fBytes[5] == 0x4F && fBytes[6] == 0x52 && fBytes[7] == 0x4D;
	}

	private static boolean isAvi() {
		return fBytes[0] == 0x52 && fBytes[1] == 0x49 && fBytes[2] == 0x46 && fBytes[3] == 0x46 &&
				fBytes[8] == 0x41 && fBytes[9] == 0x56 && fBytes[10] == 0x49;
	}

}
