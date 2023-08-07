package com.anhnttph23200.assignment.repositories;

import com.anhnttph23200.assignment.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    @Query("select c from NhanVien c where c.id = ?1")
    NhanVien findId(UUID id);
}
