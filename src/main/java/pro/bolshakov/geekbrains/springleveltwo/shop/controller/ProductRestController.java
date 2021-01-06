package pro.bolshakov.geekbrains.springleveltwo.shop.controller;

import org.springframework.web.bind.annotation.*;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.ProductDto;
import pro.bolshakov.geekbrains.springleveltwo.shop.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final ProductService productService;


    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDto dto){
        productService.addProduct(dto);
    }

}
