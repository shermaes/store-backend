package com.sofkau.store.usecase;

import com.sofkau.store.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProductUseCase {
    @Autowired
    private IProductRepository iProductRepository;

    public Mono<Void> apply(String id){
        return iProductRepository.findById(id)
                .flatMap(c -> iProductRepository.deleteById(c.getId()));
    }
}
