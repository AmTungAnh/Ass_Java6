package com.anhnttph23200.assignment.services.impl;

import com.anhnttph23200.assignment.entity.SanPham;
import com.anhnttph23200.assignment.repositories.SanPhamRepository;
import com.anhnttph23200.assignment.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public Page<SanPham> page(Pageable pageable) {
        return this.sanPhamRepository.findAll(pageable);
    }

    @Override
    public SanPham detail(UUID id) {
        return this.sanPhamRepository.findId(id);
    }

    @Override
    public void add(SanPham sp) {
        this.sanPhamRepository.save(sp);
    }

    @Override
    public void delete(UUID id) {
        SanPham sp = detail(id);
        this.sanPhamRepository.save(sp);
    }

    @Override
    public void update(SanPham sp) {
        this.sanPhamRepository.save(sp);
    }

    @Override
    public List<SanPham> getAll() {
        return this.sanPhamRepository.findAll();
    }
}
