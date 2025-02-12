package com.carenet.storage.exam.repository;


import com.carenet.storage.exam.entity.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeJpaRepository extends JpaRepository<CodeEntity, Long> {
}
