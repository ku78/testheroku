package pro.bolshakov.geekbrains.springleveltwo.shop.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.ProductDto;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void checkGetProductById() {
        ResponseEntity<ProductDto> entity = restTemplate.getForEntity("/products/" + 1, ProductDto.class);
        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
}