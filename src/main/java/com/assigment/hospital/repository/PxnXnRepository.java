package com.assigment.hospital.repository;

import java.util.List;

import com.assigment.hospital.entity.PxnXnEntity;
import com.assigment.hospital.entity.PxnXnEntityPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PxnXnRepository extends JpaRepository<PxnXnEntity, PxnXnEntityPK> {
    List<PxnXnEntity> findByMapxn(long mapxn);
}
