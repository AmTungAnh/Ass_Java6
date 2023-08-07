package com.anhnttph23200.assignment.repositories;

import com.anhnttph23200.assignment.entity.NhaSanXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhaSanXuatRepository extends JpaRepository<NhaSanXuat, UUID> {

    @Query("select c from NhaSanXuat c where c.id =? 1")
    NhaSanXuat findId(UUID id);
}
