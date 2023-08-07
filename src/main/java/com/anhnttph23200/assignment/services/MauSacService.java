package com.anhnttph23200.assignment.services;

import com.anhnttph23200.assignment.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    Page<MauSac> getAll(Pageable pageable);

    void add(MauSac mauSac);

    void update(MauSac mauSac);

    void delete(UUID id);

    MauSac detail(UUID id);

    List<MauSac> getAll();
}
