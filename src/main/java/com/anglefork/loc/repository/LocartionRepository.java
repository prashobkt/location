package com.anglefork.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anglefork.loc.entity.Location;

public interface LocartionRepository extends JpaRepository<Location, Integer> {

}
