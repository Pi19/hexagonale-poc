package com.archi.hexagonale.domain.model;


import com.archi.hexagonale.application.exception.BadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProduitTest {

    @Test
    void testProduitWhenDesignationIsBlank() {
          var produit = Produit.builder().prix(20.0).description("this is from Inde").build();
        Exception ex = assertThrows(BadRequestException.class,
                () -> produit.checkValidate());
        assertEquals("Designation est obligatoire.", ex.getMessage());
    }

    @Test
    void testProduitWhenPriceInvalid() {
        var produit = Produit.builder().prix(0.0).designation("Rice").description("this is from Inde").build();
        Exception ex = assertThrows(BadRequestException.class,
                () -> produit.checkValidate());
        assertEquals("Le prix devrait  être supérieur  à zero.", ex.getMessage());
    }

    @Test
    void testProduitOK() {
        var produit = Produit.builder().prix(10.0).designation("Rice").description("this is from Inde").build();
        produit.checkValidate();
        assertEquals(10.0,produit.getPrix());
    }
}
