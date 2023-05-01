package com.ite.fisioterapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ite.fisioterapia.entities.Familia;


@Repository
public interface FamiliaRepository extends JpaRepository <Familia,Integer> {

}
