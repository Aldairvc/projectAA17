package com.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.models.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
