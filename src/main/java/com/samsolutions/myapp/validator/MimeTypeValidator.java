package com.samsolutions.myapp.validator;

import com.samsolutions.myapp.config.ApplicationProperties;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MimeTypeValidator {

	private static ApplicationProperties properties = new ApplicationProperties();

	private static final List<String> TYPES_OF_FILE = Arrays.asList(properties.getProperty("TYPES_OF_FILE")
			.split(","));

	private static final List<String> CONTENT_TYPE_OF_FILE = Arrays.asList(properties.getProperty("CONTENT_TYPE_OF_FILE")
			.split(","));

	public static Map<String, String> createMapFromLists(List<String> keys, List<String> values) {
		return IntStream.range(0, keys.size())
				.boxed()
				.collect(Collectors.toMap(keys::get, values::get));
	}

	private static final Map<String, String> TYPES_MAP = createMapFromLists(TYPES_OF_FILE, CONTENT_TYPE_OF_FILE);


	public static boolean checkContentType(UploadedFile file, String fileExtension) {
		return TYPES_MAP.get(fileExtension)
						.equals(file.getFile()
						.getContentType());
	}

	public static boolean checkTypeByBytes(byte[] data, String fileExtension) {

		String type = TYPES_MAP.get(fileExtension);
		byte[] header = new byte[11];
		System.arraycopy(data, 0, header, 0, Math.min(data.length, header.length));
		int c1 = header[0] & 0xff;
		int c2 = header[1] & 0xff;
		int c3 = header[2] & 0xff;
		int c4 = header[3] & 0xff;
		int c5 = header[4] & 0xff;
		int c6 = header[5] & 0xff;
		int c7 = header[6] & 0xff;
		int c8 = header[7] & 0xff;
		int c9 = header[8] & 0xff;
		int c10 = header[9] & 0xff;
		int c11 = header[10] & 0xff;

		switch (type) {
			case ("application/msword"):
				return c1 == 0xD0 && c2 == 0xCF && c3 == 0x11 && c4 == 0xE0 && c5 == 0xA1 && c6 == 0xB1 && c7 == 0x1A && c8 == 0xE1;
			case ("application/pdf"):
				return c1 == 0x25 && c2 == 0x50 && c3 == 0x44 && c4 == 0x46 && c5 == 0x2d && c6 == 0x31 && c7 == 0x2e;
			case ("audio/mpeg"):
				return (c1 == 0x49 && c2 == 0x44 && c3 == 0x33) || (c1 == 0xff && c2 == 0xfb && c3 == 0x30);
			case ("image/png"):
				return c1 == 137 && c2 == 80 && c3 == 78 && c4 == 71 && c5 == 13 && c6 == 10 && c7 == 26 && c8 == 10;
			case ("image/jpeg"):
				return (c1 == 0xFF && c2 == 0xD8 && c3 == 0xFF) || ((c4 == 0xE1) && (c7 == 'E' && c8 == 'x' && c9 == 'i' && c10 == 'f' && c11 == 0));
			case ("application/x-zip-compressed"):
				return c1 == 'P' && c2 == 'K';
			case ("video/mp4"):
				return c1 == 0x00 && c2 == 0x00 && c3 == 0x00 && c4 == 0x18 && c5 == 0x66 && c6 == 0x74 && c7 == 0x79 && c8 == 0x70;
			case ("application/vnd.openxmlformats-officedocument.wordprocessingml.document"):
				return c1 == 0x50 && c2 == 0x4B && c3 == 0x03 && c4 == 0x04 && c5 == 0x14 && c6 == 0x00 && c7 == 0x06 && c8 == 0x00;
			case ("application/vnd.ms-excel"):
				return c1 == 0xD0 && c2 == 0xCF && c3 == 0x11 && c4 == 0xE0 && c5 == 0xA1 && c6 == 0xB1 && c7 == 0x1A && c8 == 0xE1;
			case ("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"):
				return c1 == 0x50 && c2 == 0x4B && c3 == 0x03 && c4 == 0x04 && c5 == 0x14 && c6 == 0x00 && c7 == 0x06 && c8 == 0x00;
			case ("application/vnd.ms-powerpoint"):
				return c1 == 0xD0 && c2 == 0xCF && c3 == 0x11 && c4 == 0xE0 && c5 == 0xA1 && c6 == 0xB1 && c7 == 0x1A && c8 == 0xE1;
			case ("application/vnd.openxmlformats-officedocument.presentationml.presentation"):
				return c1 == 0x50 && c2 == 0x4B && c3 == 0x03 && c4 == 0x04 && c5 == 0x14 && c6 == 0x00 && c7 == 0x06 && c8 == 0x00;
			case ("application/octet-stream"):
				return (c1 == 0x41 && c2 == 0x54 && c3 == 0x26 && c4 == 0x54 && c5 == 0x46 && c6 == 0x4F && c7 == 0x52 && c8 == 0x4D) || (c1 == 0x52 && c2 == 0x61 && c3 == 0x72 && c4 == 0x21 && c5 == 0x1A && c6 == 0x07);
			case ("text/plain"):
				return c1 == 0x1A && c2 == 0x00 && c3 == 0x00 && c4 == 0x03 && c5 == 0x00 && c6 == 0x00 && c7 == 0x14 && c8 == 0x00;
		}
		return false;
	}

}
