package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Bucket;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.User;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.BucketDto;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);

    BucketDto getBucketByUser(String name);
    void commitBucketToOrder(String username);
}
