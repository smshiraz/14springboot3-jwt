package com.syed.springboot3jwt.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.syed.springboot3jwt.entity.UserInfoEntity;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {
    Optional<UserInfoEntity> findByName(String username);

}