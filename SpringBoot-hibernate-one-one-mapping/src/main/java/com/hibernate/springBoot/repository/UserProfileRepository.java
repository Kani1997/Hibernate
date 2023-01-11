package com.hibernate.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.springBoot.entity.UserProfile;

public interface UserProfileRepository  extends JpaRepository<UserProfile,Long>{

}
