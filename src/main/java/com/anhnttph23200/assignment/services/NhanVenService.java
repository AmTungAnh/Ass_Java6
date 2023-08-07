package com.anhnttph23200.assignment.services;

import com.anhnttph23200.assignment.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface NhanVenService {

    Page<NhanVien> getAll(Pageable pageable);

    void add(NhanVien nhanVien);

    void update(NhanVien nhanVien);

    void delete(UUID id);

    NhanVien detail(UUID id);

}
