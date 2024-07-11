package com.archi.hexagonale.application.converter;

import com.archi.hexagonale.application.dto.ProduitDto;
import com.archi.hexagonale.domain.model.Produit;

public final class ProduitConverterDto {

    public static ProduitDto toDto (Produit pDomain){
         var pDto = new ProduitDto();
         pDto.setRef(pDomain.getReference());
         pDto.setDesignation(pDomain.getDesignation());
         pDto.setDesc(pDomain.getDescription());
         pDto.setPrix(pDomain.getPrix());
         return  pDto;
    }

    public static Produit toDomain (ProduitDto dto){
        var domain = Produit.builder()
                     .prix(dto.getPrix())
                .description(dto.getDesc())
                .designation(dto.getDesignation()).build();
      return  domain;
    }
}
