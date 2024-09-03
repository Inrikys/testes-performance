package com.cleanarchitecture.exemplo.adapters.out.repository;

import com.cleanarchitecture.exemplo.adapters.out.repository.entity.ZupperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZupperRepository extends JpaRepository<ZupperEntity, Long> {

    boolean existsByEmail(String email);

}
