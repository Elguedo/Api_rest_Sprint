package com.tutorial.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//usando la libreria de limbok, uso las anaotaciones que nos permitiran hacer: 
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con todo los atributos (Inicializa un objeto)
@Data //metodo get y set
@Builder
public class ProductDTO { //Dto (Data transfer objet) tranferir todos todo los atributos de un producto en un solo objeto
    private String name;
    private int price;
}
