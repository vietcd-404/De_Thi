package com.example.OnDe1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "khachhang")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makhachhang")
    private Long id;

    @Column(name = "tenkhachhang")
    private String ten;

    @Column(name = "sodienthoai")
    private String sdt;

    @Column(name = "gioitinh")
    private Boolean gioiTinh;


    @ManyToOne
    @JoinColumn(name = "HangKhachHang")
    private HangKhachHang hangKhachHang;
}
