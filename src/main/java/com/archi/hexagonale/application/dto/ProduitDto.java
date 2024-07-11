package com.archi.hexagonale.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDto {
     private  UUID ref;
     private  String desc;
     private  String designation;
     private  Double prix;
}
