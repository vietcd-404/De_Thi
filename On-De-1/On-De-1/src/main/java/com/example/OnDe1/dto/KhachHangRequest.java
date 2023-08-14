package com.example.OnDe1.dto;


import com.example.OnDe1.entity.HangKhachHang;
import com.example.OnDe1.entity.KhachHang;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KhachHangRequest {

    @NotBlank(message = "ma hang khong dc de trong")
    private String maHang;


    private String sdt;

    private Boolean gioiTinh;

    private String ten;

    public KhachHang map(KhachHang kh){
        kh.setSdt(this.getSdt());
        kh.setTen(this.getTen());
        kh.setGioiTinh(Boolean.valueOf(this.getGioiTinh()));
        kh.setHangKhachHang(HangKhachHang.builder().id(Integer.valueOf(maHang)).build());
        return kh;
    }
    public KhachHang update(KhachHang kh,Long id){
        kh.setSdt(this.getSdt());
        kh.setTen(this.getTen());
        kh.setGioiTinh(Boolean.valueOf(this.getGioiTinh()));
        kh.setHangKhachHang(HangKhachHang.builder().id(Integer.valueOf(maHang)).build());
        return kh;
    }

}
