package com.anhnttph23200.assignment.services.impl;

import com.anhnttph23200.assignment.entity.MauSac;
import com.anhnttph23200.assignment.repositories.MauSacRepository;
import com.anhnttph23200.assignment.services.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    MauSacRepository mauSacRepository;

    @Override
    public Page<MauSac> getAll(Pageable pageable) {
        return this.mauSacRepository.findAll(pageable);
    }

    @Override
    public void add(MauSac mauSac) {
        this.mauSacRepository.save(mauSac);
    }

    @Override
    public void update(MauSac mauSac) {
        this.mauSacRepository.save(mauSac);
    }

    @Override
    public void delete(UUID id) {
        MauSac mauSac = detail(id);
        this.mauSacRepository.delete(mauSac);
    }

    @Override
    public MauSac detail(UUID id) {
        return this.mauSacRepository.findId(id);
    }

    @Override
    public List<MauSac> getAll() {
        return this.mauSacRepository.findAll();
    }
}
