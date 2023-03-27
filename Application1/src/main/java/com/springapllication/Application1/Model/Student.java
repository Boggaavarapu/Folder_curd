package com.springapllication.Application1.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
@Entity
@Table(name="Student")
public class Student {
	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String Person;
	private Long Fid;
	private String FName;
	@Column(name="Ftype")
	private String Ftype;
	@Lob
	@Column(name="data")
	private byte[] data;
	public Student() {
		super();
	}
	
	public Student(String person, Long folderName, String fName, String ftype, byte[] data) {
		super();
		this.Person = person;
		this.Fid = folderName;
		this.FName = fName;
		this.Ftype = ftype;
		this.data = data;
	}

	public Long getId() {
		return id;
	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getPerson() {
		return Person;
	}
	public void setPerson(String person) {
		Person = person;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getFtype() {
		return Ftype;
	}
	public void setFtype(String ftype) {
		Ftype = ftype;
	}
	public byte[] getFile() {
		return data;
	}
	public void setFile(byte[] file) {
		this.data = file;
	}
	public Long getFolderNamee() {
		return Fid;
	}
	public void setFolderNamee(Long folderNamee) {
		Fid = folderNamee;
	}
	
}
