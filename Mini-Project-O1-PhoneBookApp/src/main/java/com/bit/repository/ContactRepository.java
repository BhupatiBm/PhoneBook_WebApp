package com.bit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity,Serializable> {

}
