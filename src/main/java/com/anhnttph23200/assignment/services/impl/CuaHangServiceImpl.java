package com.anhnttph23200.assignment.services.impl;

import com.anhnttph23200.assignment.entity.CuaHang;
import com.anhnttph23200.assignment.repositories.CuaHangRepository;
import com.anhnttph23200.assignment.services.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public Page<CuaHang> page(Pageable pageable) {
        return this.cuaHangRepository.findAll(pageable);
    }

    @Override
    public List<CuaHang> getAll() {
        return this.cuaHangRepository.findAll();
    }

    @Override
    public CuaHang detail(UUID id) {
        return this.cuaHangRepository.findId(id);
    }

    @Override
    public void add(CuaHang cuaHang) {
        this.cuaHangRepository.save(cuaHang);
    }

    @Override
    public void update(CuaHang cuaHang) {
        this.cuaHangRepository.save(cuaHang);
    }

    @Override
    public void delete(UUID id) {
        CuaHang cuaHang = detail(id);
        this.cuaHangRepository.delete(cuaHang);
    }
}
