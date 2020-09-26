package com.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.PhoneNumber;

public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, Long> {

}
