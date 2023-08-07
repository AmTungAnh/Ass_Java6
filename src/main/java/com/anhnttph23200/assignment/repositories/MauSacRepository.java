package com.anhnttph23200.assignment.repositories;

import com.anhnttph23200.assignment.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {

    @Query("SELECT c FROM MauSac c WHERE c.id = ?1")
    MauSac findId(UUID id);
}
