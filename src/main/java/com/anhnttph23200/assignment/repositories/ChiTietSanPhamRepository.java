package com.anhnttph23200.assignment.repositories;

import com.anhnttph23200.assignment.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, UUID> {

    @Query("select c from ChiTietSanPham c where c.id = ?1")
    ChiTietSanPham findId1(UUID id);
}
