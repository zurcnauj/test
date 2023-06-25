package com.test.testSpringboot.repositories.phones;

import com.test.testSpringboot.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findById(long userId);
}
