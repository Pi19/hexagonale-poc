package com.archi.hexagonale.domain.service;


import com.archi.hexagonale.application.exception.BadRequestException;
import com.archi.hexagonale.domain.AbstractUnitTest;
import com.archi.hexagonale.domain.exception.RessourceNotFoundException;
import com.archi.hexagonale.domain.model.Produit;
import com.archi.hexagonale.domain.port.spi.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProduitServiceTest  extends AbstractUnitTest {

    @Mock
    private ProduitRepository pRepository;

    @InjectMocks
    private ProduitService produitService;

    @Test
    void testProduit_create_Ok(){
        var produit = mockProduit();
        var givenUuid = UUID.randomUUID();
        when(pRepository.saveProduit(any())).thenReturn(givenUuid);
        var uuidSaved = assertDoesNotThrow(() -> produitService.createProduit(produit));
        assertEquals(givenUuid, uuidSaved);
        verify(pRepository, times(1)).saveProduit(any(Produit.class));
    }

    @Test
    void testProduit_create_whenDesignationIsBlank(){
        var produit = mockProduitDesignationBlank();
        assertThrows(BadRequestException.class,() ->produitService.createProduit(produit)) ;
        verify(pRepository, never()).saveProduit(any(Produit.class));
    }

    @Test
    void testProduit_create_whenPriceInvalid(){
        var produit = mockProduitPrixInvalid();
        assertThrows(BadRequestException.class,() -> produitService.createProduit(produit)) ;
        verify(pRepository, never()).saveProduit(any(Produit.class));
    }

    @Test
    void testRead_produit_ok(){
         var produit = mockFullProduit();
         var refProduit = produit.getReference();
         when(pRepository.readProduitByRef(any())).thenReturn(Optional.of(produit));

         var actualProduit = assertDoesNotThrow(() ->produitService.readProduitByRef(refProduit));
         verify(pRepository, times(1)).readProduitByRef(any());
        assertEquals(produit.getReference() , actualProduit.getReference());
         assertEquals(produit.getPrix() , actualProduit.getPrix());
         assertEquals(produit.getDescription(), actualProduit.getDescription());
    }

    @Test
    void testRead_produit_not_found(){
        when(pRepository.readProduitByRef(any())).thenReturn(Optional.empty());
        var reference = UUID.randomUUID();
        var ex =  assertThrows(RessourceNotFoundException.class, () ->produitService.readProduitByRef(reference));
        var expectedMessage =  String.format("Reference produit [%s] is  not found", reference);
        assertEquals(expectedMessage , ex.getMessage());
    }

}
