package com.anhnttph23200.assignment.repositories;

import com.anhnttph23200.assignment.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {

    @Query("select c from ChucVu c where c.id = ?1")
    ChucVu findId(UUID id);
}
