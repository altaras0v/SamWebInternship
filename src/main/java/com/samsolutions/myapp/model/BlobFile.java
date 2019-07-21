package com.samsolutions.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity for blob files
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blob_file")
public class BlobFile implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "file")
	private byte[] file;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "file_id")
	private LessonFile lessonFile;

	/**
	 * Constructor for creating Blob file
	 * @param file - bytes of this file
	 * @param lessonFile - entity with name and description  of this file
	 */
	public BlobFile(byte[] file, LessonFile lessonFile) {
		this.file = file;
		this.lessonFile = lessonFile;
	}

}
