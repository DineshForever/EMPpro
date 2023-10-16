package com.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.model.Manage;

public interface Repository extends JpaRepository<Manage, Integer> {

}