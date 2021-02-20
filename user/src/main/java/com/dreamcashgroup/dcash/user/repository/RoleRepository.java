package com.dreamcashgroup.dcash.user.repository;

import com.dreamcashgroup.dcash.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, String> {
}
