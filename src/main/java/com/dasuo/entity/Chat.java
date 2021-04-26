package com.dasuo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chat")
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer chat_Id;
	@ManyToOne
	@JoinColumn(name = "nguoinhan_id")
	private TaiKhoan nguoiNhan;
	@ManyToOne
	@JoinColumn(name = "nguoigui_id")
	private TaiKhoan nguoiGui;
	@OneToMany(mappedBy = "chat")
	private List<TinNhan> tinNhan;

	public Chat() {
		super();
	}

	public Integer getChat_Id() {
		return chat_Id;
	}

	public void setChat_Id(Integer chat_Id) {
		this.chat_Id = chat_Id;
	}

	
	public TaiKhoan getNguoiNhan() {
		return nguoiNhan;
	}

	public void setNguoiNhan(TaiKhoan nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}

	public TaiKhoan getNguoiGui() {
		return nguoiGui;
	}

	public void setNguoiGui(TaiKhoan nguoiGui) {
		this.nguoiGui = nguoiGui;
	}

	public List<TinNhan> getTinNhan() {
		return tinNhan;
	}

	public void setTinNhan(List<TinNhan> tinNhan) {
		this.tinNhan = tinNhan;
	}
	
	
	

}
