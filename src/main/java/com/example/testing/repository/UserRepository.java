package com.example.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testing.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
