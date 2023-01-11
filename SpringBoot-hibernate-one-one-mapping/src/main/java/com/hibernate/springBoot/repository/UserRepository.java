package com.hibernate.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.springBoot.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
