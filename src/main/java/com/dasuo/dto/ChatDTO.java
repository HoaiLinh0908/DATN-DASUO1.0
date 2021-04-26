package com.dasuo.dto;

import java.util.List;

public class ChatDTO {
private Integer chat_Id;
	
	private TaiKhoanDTO nguoiNhan;
	
	private TaiKhoanDTO nguoiGui;
	
	private List<TinNhanDTO> tinNhan;

	public ChatDTO() {
		super();
	}

	public Integer getChat_Id() {
		return chat_Id;
	}

	public void setChat_Id(Integer chat_Id) {
		this.chat_Id = chat_Id;
	}

	public TaiKhoanDTO getNguoiNhan() {
		return nguoiNhan;
	}

	public void setNguoiNhan(TaiKhoanDTO nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}

	public TaiKhoanDTO getNguoiGui() {
		return nguoiGui;
	}

	public void setNguoiGui(TaiKhoanDTO nguoiGui) {
		this.nguoiGui = nguoiGui;
	}

	public List<TinNhanDTO> getTinNhan() {
		return tinNhan;
	}

	public void setTinNhan(List<TinNhanDTO> tinNhan) {
		this.tinNhan = tinNhan;
	}

	
}
