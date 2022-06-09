package com.sofkau.store.repository;

import com.sofkau.store.collection.Bills;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IBillsRepository extends ReactiveMongoRepository<Bills, String> {
}
