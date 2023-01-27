package com.tutorial.apirest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//usando la libreria de limbok, uso las anaotaciones que nos permitiran hacer: 
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con todo los atributos (Inicializa un objeto)
@Data //metodo get y set
@Builder
public class Product {//clase que define el modelo para un producto
    //atributos de la clase
    private int id;
    private String name;
    private int price;
}
