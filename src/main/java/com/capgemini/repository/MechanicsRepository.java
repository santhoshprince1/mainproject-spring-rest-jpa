package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entites.Mechanics;
@Repository
public interface MechanicsRepository extends JpaRepository<Mechanics, Integer> {
  Mechanics findByName(String name);
  Mechanics findByMobile(String mobile);
}
