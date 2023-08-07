package com.anhnttph23200.assignment.services;

import com.anhnttph23200.assignment.entity.DongSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {

    Page<DongSanPham> page(Pageable pageable);

    DongSanPham detail(UUID id);

    void add(DongSanPham dongSanPham);

    void delete(UUID id);

    void update(DongSanPham dongSanPham);

    List<DongSanPham> getAll();
}
