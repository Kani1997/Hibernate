package com.hibernate.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.springBoot.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
