package com.anhnttph23200.assignment.services.impl;

import com.anhnttph23200.assignment.entity.ChiTietSanPham;
import com.anhnttph23200.assignment.repositories.ChiTietSanPhamRepository;
import com.anhnttph23200.assignment.services.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public Page<ChiTietSanPham> page(Pageable pageable) {
        return this.chiTietSanPhamRepository.findAll(pageable);
    }

    @Override
    public ChiTietSanPham detail(UUID id) {
        return this.chiTietSanPhamRepository.findId1(id);
    }

    @Override
    public void add(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public void delete(UUID id) {
        this.chiTietSanPhamRepository.deleteById(id);
    }

    @Override
    public void update(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public List<ChiTietSanPham> getAll() {
        return this.chiTietSanPhamRepository.findAll();
    }
}
