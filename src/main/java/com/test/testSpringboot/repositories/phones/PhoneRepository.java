package com.test.testSpringboot.repositories.phones;

import com.test.testSpringboot.models.entities.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, PhoneEntity> {}
