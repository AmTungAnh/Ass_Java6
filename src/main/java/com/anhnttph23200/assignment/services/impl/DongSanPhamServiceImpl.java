package com.anhnttph23200.assignment.services.impl;

import com.anhnttph23200.assignment.entity.DongSanPham;
import com.anhnttph23200.assignment.repositories.DongSanPhamRepository;
import com.anhnttph23200.assignment.services.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {

    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @Override
    public Page<DongSanPham> page(Pageable pageable) {
        return this.dongSanPhamRepository.findAll(pageable);
    }

    @Override
    public DongSanPham detail(UUID id) {
        return this.dongSanPhamRepository.findId(id);
    }

    @Override
    public void add(DongSanPham dongSanPham) {
        this.dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public void delete(UUID id) {
        DongSanPham dongSanPham = detail(id);
        this.dongSanPhamRepository.delete(dongSanPham);
    }

    @Override
    public void update(DongSanPham dongSanPham) {
        this.dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public List<DongSanPham> getAll() {
        return this.dongSanPhamRepository.findAll();
    }
}
