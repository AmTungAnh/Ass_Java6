package com.anhnttph23200.assignment.services;

import com.anhnttph23200.assignment.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    Page<SanPham> page(Pageable pageable);

    SanPham detail(UUID id);

    void add(SanPham sp);

    void delete(UUID id);

    void update(SanPham sp);

    List<SanPham> getAll();

}
