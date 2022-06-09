package com.sofkau.store.repository;

import com.sofkau.store.collection.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IReceiptRepository extends ReactiveMongoRepository<Receipt, String> {
}
