package com.example.OnDe1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hangkhachhang")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HangKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mahang")
    private int id;

    @Column(name = "tenhang")
    private String ten;

}
