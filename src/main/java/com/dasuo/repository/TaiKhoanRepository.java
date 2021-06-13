package com.dasuo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer>{

	@Query(value="SELECT taikhoan.*,count(lop.lop_id) FROM dasuo.taikhoan,dasuo.lop where tai_khoan_id = nguoiday_id and loai_id = 2 group by tai_khoan_id order by count(lop.lop_id) DESC limit 4",nativeQuery=true)
	public List<Object[]> taiKhoanUuTu();
	@Query(value="SELECT * FROM dasuo.taikhoan_mon where tai_khoan_id = ?",nativeQuery=true)
	public List<Object[]> taiKhoan_Mon(Integer id);
	@Query(value="SELECT tai_khoan_id,bang_cap,cmnd,email,gioi_tinh,hinh_dai_dien,ho_ten,hoc_phi,mo_ta,mat_khau,sdt,so_du,loai_id,nghe_nghiep_id,tinh_thanh_id FROM dasuo.taikhoan WHERE taikhoan.ho_ten LIKE %?1% ",nativeQuery=true)
	public List<Object[]> timKiemGS(String name);
	
	public TaiKhoan findByEmail(String email);
	public TaiKhoan findByCode(String code);
	
	@Query(value="SELECT count(1) FROM dasuo.taikhoan ;"
			,nativeQuery=true)
	int countTaiKhoan();
	
}
