package com.archi.hexagonale.domain;


import com.archi.hexagonale.domain.model.Produit;

import java.util.UUID;

public abstract class AbstractUnitTest {

     public static Produit mockProduit(){
          var produit = Produit.builder()
                  .designation("Rice")
                  .prix(10.0)
                  .description("from Inde").build();
          return produit;
     }

     public static Produit mockProduitDesignationBlank(){
          var produit = Produit.builder()
                  .prix(10.0)
                  .description("from Inde").build();
          return produit;
     }

     public static Produit mockProduitPrixInvalid(){
          var produit = Produit.builder()
                  .prix(0.0)
                  .designation("Rice")
                  .description("from Inde").build();
          return produit;
     }
}
