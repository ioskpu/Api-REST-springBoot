package com.sabassoft.apirest.apirest.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sabassoft.apirest.apirest.Entities.Productos;
import com.sabassoft.apirest.apirest.Repositories.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/productos")
public class ProductsControllers {

    @Autowired
    private ProductRepository productRepository;

    //trae todos los productos
    @GetMapping
    public List<Productos> getAllProducts() {
        return productRepository.findAll();
    }

    //trae un producto por id
    @GetMapping("/{id}")
    public Productos getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));
    }

    //crear un producto
    @PostMapping
    public Productos createProduct(@RequestBody Productos product) {
        return productRepository.save(product);
    }

    //actualizar un producto
    @PutMapping("/{id}")
    public Productos updateProduct(@PathVariable Long id, @RequestBody Productos productDetails) {
        Productos product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));
        product.setNombre(productDetails.getNombre());
        product.setDescripcion(productDetails.getDescripcion());
        product.setPrecio(productDetails.getPrecio());
        product.setStock(productDetails.getStock());
        return productRepository.save(product);
    }

    //eliminar un producto
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Productos product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));
        productRepository.delete(product);

        return "El producto con el id " + id + " ha sido eliminado correctamente";
    }
}