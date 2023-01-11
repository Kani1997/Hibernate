package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.Tag;
@Repository
public interface tagRepository extends JpaRepository<Tag,Long> {

}
