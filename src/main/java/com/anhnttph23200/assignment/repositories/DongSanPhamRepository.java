package com.anhnttph23200.assignment.repositories;

import com.anhnttph23200.assignment.entity.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DongSanPhamRepository extends JpaRepository<DongSanPham, UUID> {

    @Query("select c from DongSanPham c where c.id = ?1")
    DongSanPham findId(UUID id);
}
