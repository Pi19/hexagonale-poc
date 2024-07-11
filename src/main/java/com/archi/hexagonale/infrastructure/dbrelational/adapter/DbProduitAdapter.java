package com.archi.hexagonale.infrastructure.dbrelational.adapter;

import com.archi.hexagonale.domain.model.Produit;
import com.archi.hexagonale.domain.port.spi.ProduitRepository;
import com.archi.hexagonale.infrastructure.dbrelational.converter.DbProduitEntityConverter;
import com.archi.hexagonale.infrastructure.dbrelational.repository.DbProduitRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DbProduitAdapter implements ProduitRepository {

    private final DbProduitRepository pRepository;

    @Override
    public UUID saveProduit(Produit produit) {
       var pEntity = pRepository.save(DbProduitEntityConverter.toProduitEntity(produit));
        return pEntity.getReference();
    }

    @Override
    public Optional<Produit> readProduitByRef(UUID pReference) {
        return pRepository.findById(pReference).map(DbProduitEntityConverter::toDomainProduit);
    }
}
