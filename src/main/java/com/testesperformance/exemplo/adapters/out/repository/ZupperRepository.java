package com.testesperformance.exemplo.adapters.out.repository;

import com.testesperformance.exemplo.adapters.out.repository.entity.ZupperEntity;
import com.testesperformance.exemplo.config.mock.NotMockExternalServicesCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZupperRepository extends JpaRepository<ZupperEntity, Long> {

    boolean existsByEmail(String email);

}
