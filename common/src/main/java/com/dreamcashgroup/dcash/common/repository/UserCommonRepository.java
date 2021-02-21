package com.dreamcashgroup.dcash.common.repository;

import com.dreamcashgroup.dcash.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCommonRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUsername(String username);
}
