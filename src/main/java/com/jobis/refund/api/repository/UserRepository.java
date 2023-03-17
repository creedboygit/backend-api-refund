package com.jobis.refund.api.repository;

import com.jobis.refund.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long userIdx);

    Optional<User> findByUserId(String userId);

    Optional<User> findByRegNo(String regNo);
}
