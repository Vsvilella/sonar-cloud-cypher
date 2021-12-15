package com.cypher.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cypher.br.model.Client;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {


}
