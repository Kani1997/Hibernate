package com.hibernate.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.springBoot.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}