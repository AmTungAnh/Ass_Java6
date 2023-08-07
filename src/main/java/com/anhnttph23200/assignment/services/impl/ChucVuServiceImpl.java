package com.anhnttph23200.assignment.services.impl;

import com.anhnttph23200.assignment.entity.ChucVu;
import com.anhnttph23200.assignment.repositories.ChucVuRepository;
import com.anhnttph23200.assignment.services.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public Page<ChucVu> getAll(Pageable pageable) {
        return this.chucVuRepository.findAll(pageable);
    }

    @Override
    public void add(ChucVu chucVu) {
        this.chucVuRepository.save(chucVu);
    }

    @Override
    public void update(ChucVu chucVu) {
        this.chucVuRepository.save(chucVu);
    }

    @Override
    public void delete(UUID id) {
        ChucVu cv = detail(id);
        this.chucVuRepository.delete(cv);
    }

    @Override
    public ChucVu detail(UUID id) {
        return this.chucVuRepository.findId(id);
    }

    @Override
    public List<ChucVu> getAll() {
        return this.chucVuRepository.findAll();
    }
}
