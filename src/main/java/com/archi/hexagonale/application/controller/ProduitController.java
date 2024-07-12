package com.archi.hexagonale.application.controller;

import com.archi.hexagonale.application.converter.ProduitConverterDto;
import com.archi.hexagonale.application.dto.ProduitDto;
import com.archi.hexagonale.application.exception.BadRequestException;
import com.archi.hexagonale.domain.port.api.ProduitUseCase;
import com.archi.hexagonale.other.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/produits")
@AllArgsConstructor
public class ProduitController {

    private final  ProduitUseCase produitUseCase ;

    @GetMapping
    @Operation(summary = "Return one product .")
    public ResponseEntity<ProduitDto> getProduit(@PathVariable String reference) {
        if(!Utils.isStringUUID(reference)){
             throw new BadRequestException("Invalid UUID string: " + reference);
        }
        var pDomain = produitUseCase.readProduitByRef(UUID.fromString(reference));
        return  ResponseEntity.ok(ProduitConverterDto.toDto(pDomain));
    }

    @PostMapping
    @Operation(summary = "Create one  product .")
    public ResponseEntity<Void> createProduit(@RequestBody ProduitDto produitDto) {
         var result  = produitUseCase.createProduit(ProduitConverterDto.toDomain(produitDto));
         return ResponseEntity
                .created(URI.create(String.format("%s/%s",
                       "/api/produits",
                        result.toString())))
                .build();
    }
}
