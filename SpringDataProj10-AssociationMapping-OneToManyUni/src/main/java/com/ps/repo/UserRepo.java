package com.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
