package com.anhnttph23200.assignment.services.impl;

import com.anhnttph23200.assignment.entity.NhaSanXuat;
import com.anhnttph23200.assignment.repositories.NhaSanXuatRepository;
import com.anhnttph23200.assignment.services.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Override
    public Page<NhaSanXuat> page(Pageable pageable) {
        return this.nhaSanXuatRepository.findAll(pageable);
    }

    @Override
    public NhaSanXuat detail(UUID id) {
        return this.nhaSanXuatRepository.findId(id);
    }

    @Override
    public void add(NhaSanXuat nsx) {
        this.nhaSanXuatRepository.save(nsx);
    }

    @Override
    public void delete(UUID id) {
        NhaSanXuat nsx = detail(id);
        this.nhaSanXuatRepository.delete(nsx);
    }

    @Override
    public void update(NhaSanXuat nsx) {
        this.nhaSanXuatRepository.save(nsx);
    }

    @Override
    public List<NhaSanXuat> getAll() {
        return this.nhaSanXuatRepository.findAll();
    }
}
