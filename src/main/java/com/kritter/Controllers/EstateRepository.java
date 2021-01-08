package com.kritter.Controllers;

import org.springframework.data.jpa.repository.JpaRepository;

// Extend JpaRepository and mention the type of the domain entity class and type of the primary key
// If we use JPA we need not have to write any specific DAO code. JPA provides findAll() methods
public interface EstateRepository extends JpaRepository<Estate,Long> {

}
