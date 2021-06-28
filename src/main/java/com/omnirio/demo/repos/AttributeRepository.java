package com.omnirio.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnirio.demo.entity.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {

}
