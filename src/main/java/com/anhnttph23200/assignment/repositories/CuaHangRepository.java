package com.anhnttph23200.assignment.repositories;

import com.anhnttph23200.assignment.entity.CuaHang;
import com.anhnttph23200.assignment.entity.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {

    @Query("select c from CuaHang c where c.id = ?1")
    CuaHang findId(UUID id);
}
