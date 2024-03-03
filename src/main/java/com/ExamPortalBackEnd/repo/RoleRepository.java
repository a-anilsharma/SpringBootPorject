package com.ExamPortalBackEnd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamPortalBackEnd.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
