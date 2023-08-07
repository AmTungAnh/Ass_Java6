package com.anhnttph23200.assignment.services;

import com.anhnttph23200.assignment.entity.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    Page<CuaHang> page(Pageable pageable);

    List<CuaHang> getAll();

    CuaHang detail(UUID id);

    void add(CuaHang cuaHang);

    void update(CuaHang cuaHang);

    void delete(UUID id);
}
