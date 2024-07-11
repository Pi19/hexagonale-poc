package com.archi.hexagonale.infrastructure.dbrelational.repository;

import com.archi.hexagonale.infrastructure.dbrelational.model.DbProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DbProduitRepository extends JpaRepository<DbProduitEntity
        , UUID> {
}
