package com.springapllication.Application1.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="folder")
public class Folder {
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;
	public String folderName;

	public Folder() {
		super();

	}
	
public Folder(String folderName) {
		super();
		this.folderName = folderName;
		//this.folder=bs;
	}

//	public Folder( String folderName) {
//		super();
//		this.folderName = folderName;
//	}
	public Long getId() {
		return id;
	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

//	public byte[] getFolder() {
//		return folder;
//	}
//
//	public void setFolder(byte[] folder) {
//		this.folder = folder;
//	}
	
}
