package com.example.OnDe1.service;

import com.example.OnDe1.dto.KhachHangCustom;
import com.example.OnDe1.dto.KhachHangRequest;
import com.example.OnDe1.entity.HangKhachHang;
import com.example.OnDe1.entity.KhachHang;
import com.example.OnDe1.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;


    public List<KhachHangCustom> getList() {
        return khachHangRepository.getAllKhachHang();
    }

    public Page<KhachHang> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return khachHangRepository.findAll(pageable);
    }

    public KhachHang add(KhachHangRequest request) {
        KhachHang khs = request.map(new KhachHang());
        return khachHangRepository.save(khs);
    }

    public KhachHang update(KhachHangRequest khachHang,Long id){
        Optional<KhachHang> optional = this.khachHangRepository.findById(id);
        return optional.map(o->{
            o.setTen(khachHang.getTen());
            o.setSdt(khachHang.getSdt());
            o.setGioiTinh(khachHang.getGioiTinh());
            o.setHangKhachHang(HangKhachHang.builder().id(Integer.valueOf(khachHang.getMaHang())).build());
            return khachHangRepository.save(o);
        }).orElse(null);
    }



    public KhachHang delete(Long id) {
        Optional<KhachHang> optional = this.khachHangRepository.findById(id);
        return optional.map(o -> {
            khachHangRepository.delete(o);
            return o;
        }).orElse(null);
    }

    public KhachHang getOne(Long ma) {
        Optional<KhachHang> optional = khachHangRepository.findById(ma);
        return optional.isPresent() ? optional.get() : null;
    }
}
