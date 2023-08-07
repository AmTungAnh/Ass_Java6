package com.anhnttph23200.assignment.repositories;

import com.anhnttph23200.assignment.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {

    @Query("SELECT c FROM SanPham c WHERE c.id = ?1")
    SanPham findId(UUID id);
}
