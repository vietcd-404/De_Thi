package com.example.OnDe1.repository;

import com.example.OnDe1.dto.KhachHangCustom;
import com.example.OnDe1.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    @Query(value = "SELECT dbo.KhachHang.MaKhachHang, dbo.KhachHang.TenKhachHang, dbo.KhachHang.SoDienThoai, dbo.KhachHang.GioiTinh, dbo.HangKhachHang.MaHang, dbo.HangKhachHang.TenHang\n" +
            "FROM dbo.KhachHang INNER JOIN\n" +
            "dbo.HangKhachHang ON dbo.KhachHang.HangKhachHang = dbo.HangKhachHang.MaHang", nativeQuery = true)
    List<KhachHangCustom> getAllKhachHang();
}
