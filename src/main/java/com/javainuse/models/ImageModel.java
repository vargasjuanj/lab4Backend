package com.javainuse.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class ImageModel implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ImageModel() {
		super();
	}

	public ImageModel(Long id,String name, String type, byte[] picByte) {
		this.id=id;
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String name;

	private String type;

	@Column(length = 1000)
	private byte[] picByte;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}