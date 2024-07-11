package com.archi.hexagonale.domain.service;

import com.archi.hexagonale.domain.exception.RessourceNotFoundException;
import com.archi.hexagonale.domain.model.Produit;
import com.archi.hexagonale.domain.port.api.ProduitUseCase;
import com.archi.hexagonale.domain.port.spi.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProduitService implements ProduitUseCase {

    private final ProduitRepository pDomainRepository;

    /**
     *  Ajouter les logiques métiers ici
     *
     */

    @Override
    public UUID createProduit(Produit produit) {
        produit.checkValidate();
        return pDomainRepository.saveProduit(produit);
    }

    @Override
    public Produit readProduitByRef(UUID reference) {
        return pDomainRepository.readProduitByRef(reference).orElseThrow(() ->
                 new RessourceNotFoundException(String.format("Reference produit [%s] is  not found", reference)));
    }
}
