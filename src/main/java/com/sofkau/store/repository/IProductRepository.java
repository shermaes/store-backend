package com.sofkau.store.repository;

import com.sofkau.store.collection.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
}
