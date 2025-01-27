package com.example.hospitalservice.repository;

import com.example.hospitalservice.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {}
