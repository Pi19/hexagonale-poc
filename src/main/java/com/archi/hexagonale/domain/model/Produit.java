package com.archi.hexagonale.domain.model;


import com.archi.hexagonale.application.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;


@Getter
@Builder
@AllArgsConstructor
public class Produit {

     private  UUID reference ;
     private final String description;
     private final String designation;
     private final Double prix ;

     /**
      *  Ajouter les  règles de validation
      *  pour un produit
      */
     public void  checkValidate(){
         if (StringUtils.isBlank(designation)){
               throw  new BadRequestException("Designation est obligatoire.");
         }
         if(prix <= 0 ){
              throw  new BadRequestException("Le prix devrait  être supérieur  à zero.");
         }
     }
}
