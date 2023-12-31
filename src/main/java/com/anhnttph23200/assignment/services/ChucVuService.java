package com.anhnttph23200.assignment.services;

import com.anhnttph23200.assignment.entity.ChucVu;
import com.anhnttph23200.assignment.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    Page<ChucVu> getAll(Pageable pageable);

    void add(ChucVu chucVu);

    void update(ChucVu chucVu);

    void delete(UUID id);

    ChucVu detail(UUID id);

    List<ChucVu> getAll();
}
