package com.anhnttph23200.assignment.services;

import com.anhnttph23200.assignment.entity.NhaSanXuat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhaSanXuatService {

    Page<NhaSanXuat> page(Pageable pageable);

    NhaSanXuat detail(UUID id);

    void add(NhaSanXuat nsx);

    void delete(UUID id);

    void update(NhaSanXuat nsx);

    List<NhaSanXuat> getAll();
}
