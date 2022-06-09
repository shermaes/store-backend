package com.sofkau.store.repository;

import com.sofkau.store.collection.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProviderRepository extends ReactiveMongoRepository<Provider, String> {
}
