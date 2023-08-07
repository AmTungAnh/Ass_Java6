package com.anhnttph23200.assignment.services.impl;

import com.anhnttph23200.assignment.entity.NhanVien;
import com.anhnttph23200.assignment.repositories.NhanVienRepository;
import com.anhnttph23200.assignment.services.NhanVenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NhanVenServiceImpl implements NhanVenService {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> getAll(Pageable pageable) {
        return this.nhanVienRepository.findAll(pageable);
    }

    @Override
    public void add(NhanVien nhanVien) {
        this.nhanVienRepository.save(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        this.nhanVienRepository.save(nhanVien);
    }

    @Override
    public void delete(UUID id) {
        NhanVien nhanVien = detail(id);
        this.nhanVienRepository.delete(nhanVien);
    }

    @Override
    public NhanVien detail(UUID id) {
        return this.nhanVienRepository.findId(id);
    }
}
