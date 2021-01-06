package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import pro.bolshakov.geekbrains.springleveltwo.shop.dao.ProductRepository;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Bucket;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Product;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.User;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.ProductDto;
import pro.bolshakov.geekbrains.springleveltwo.shop.mapper.ProductMapper;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper = ProductMapper.MAPPER;

    private final ProductRepository productRepository;
    private final UserService userService;
    private final BucketService bucketService;
    private final SimpMessagingTemplate template;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, BucketService bucketService, SimpMessagingTemplate template) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.bucketService = bucketService;
        this.template = template;
    }

    @Override
    public List<ProductDto> getAll() {
        return mapper.fromProductList(productRepository.findAll());
    }

    @Override
    @Transactional
    public void addToUserBucket(Long productId, String username) {
        User user = userService.findByName(username);
        if(user == null){
            throw new RuntimeException("User not found. " + username);
        }

        Bucket bucket = user.getBucket();
        if(bucket == null){
            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(productId));
            user.setBucket(newBucket);
            userService.save(user);
        }
        else {
            bucketService.addProducts(bucket, Collections.singletonList(productId));
        }
    }

    @Override
    public void addProduct(ProductDto dto) {
        Product product = ProductMapper.MAPPER.toProduct(dto);
        Product savedProduct = productRepository.save(product);

        template.convertAndSend("/topic/products",
                ProductMapper.MAPPER.fromProduct(savedProduct));
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id).orElse(new Product());
        return ProductMapper.MAPPER.fromProduct(product);
    }
}
