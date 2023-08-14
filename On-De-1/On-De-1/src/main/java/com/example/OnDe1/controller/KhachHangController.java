package com.example.OnDe1.controller;

import com.example.OnDe1.dto.KhachHangCustom;
import com.example.OnDe1.dto.KhachHangRequest;
import com.example.OnDe1.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/khachHang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;


    @GetMapping
    public ResponseEntity<?> view() {
        return ResponseEntity.ok(khachHangService.getList());
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseEntity.ok(khachHangService.getAll(page).getContent());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid KhachHangRequest request, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.ok(khachHangService.add(request));
        }
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@RequestBody @Valid KhachHangRequest request, @PathVariable Long ma, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        } else {
            khachHangService.update(request, ma);
            return ResponseEntity.ok("Sua thanh cong");
        }
    }

    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> Delete(@PathVariable Long ma) {
        return ResponseEntity.ok(khachHangService.delete(ma));
    }


    @GetMapping("/tim")
    public List<KhachHangCustom> timKiem() {
        return khachHangService.getList().stream()
                .filter(tim-> tim.getGioiTinh() == false)
                .collect(Collectors.toList());
    }

    @GetMapping("/detail/{ma}")
    public ResponseEntity<?> getOne(@PathVariable Long ma){
        return ResponseEntity.ok(khachHangService.getOne(ma));
    }
}
