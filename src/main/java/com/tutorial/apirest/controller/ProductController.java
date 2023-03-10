package com.tutorial.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tutorial.apirest.dto.ProductDTO;
import com.tutorial.apirest.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController//anotacion capa controlador
@CrossOrigin
@RequestMapping("/product")//definicion de la ruta para el consumo de la api_rest (localhost:8080//product)
public class ProductController {
// arry_list, para almacenar los productos
    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "product1", 100),
            new Product(20, "product2", 200),
            new Product(23, "product3", 300),
            new Product(4, "product4", 400)
    ));
//medotodo o endpoins que nos permitiran hacer las peticiones HTPP

//metodo que nos trae toda las lista de producto que este el array_list
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(products);
    }
//metodo que nos trae un producto por si id que este array_list
    @GetMapping("{id}")
    public ResponseEntity<Product> getOne(@PathVariable("id") int id) {
        Product product = findById(id);
        return ResponseEntity.ok(product);
    }
//metodo para crear un producto
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        int index = products.isEmpty()? 1 : getLastIndex() + 1;
        Product product = Product.builder().id(index).name(dto.getName()).price(dto.getPrice()).build();
        products.add(product);
        return ResponseEntity.ok(product);
    }
//metodo para editar un producto
    @PutMapping("{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int id, @RequestBody ProductDTO dto) {
        Product product = findById(id);
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return ResponseEntity.ok(product);
    }
//metodo para eliminar un producto
    @DeleteMapping("{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") int id) {
        Product product = findById(id);
        products.remove(product);
        return ResponseEntity.ok(product);
    }
//metodo para encontrar el indixe del producto
    private int getLastIndex() {
        return products.stream().max(Comparator.comparing(Product::getId)).get().getId();
    }
//medoro para encontrar el id del producto
    private Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }
}
