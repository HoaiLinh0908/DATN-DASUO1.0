package com.dasuo.dto;

import java.util.Date;

public class TinNhanDTO {
private Integer tinNhan_Id;
	
	private String noiDung;
	
	private Date thoiGian;
	
	private ChatDTO chat;

	public TinNhanDTO() {
		super();
	}

	public Integer getTinNhan_Id() {
		return tinNhan_Id;
	}

	public void setTinNhan_Id(Integer tinNhan_Id) {
		this.tinNhan_Id = tinNhan_Id;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public ChatDTO getChat() {
		return chat;
	}

	public void setChat(ChatDTO chat) {
		this.chat = chat;
	}
	

}
