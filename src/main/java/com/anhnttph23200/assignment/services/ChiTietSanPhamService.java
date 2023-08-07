package com.anhnttph23200.assignment.services;

import com.anhnttph23200.assignment.entity.ChiTietSanPham;
import com.anhnttph23200.assignment.entity.DongSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {

    Page<ChiTietSanPham> page(Pageable pageable);

    ChiTietSanPham detail(UUID id);

    void add(ChiTietSanPham chiTietSanPham);

    void delete(UUID id);

    void update(ChiTietSanPham chiTietSanPham);

    List<ChiTietSanPham> getAll();
}
