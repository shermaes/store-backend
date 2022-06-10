package com.sofkau.store.usecase;

import com.sofkau.store.repository.IProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProviderUseCase {
    @Autowired
    private IProviderRepository iProviderRepository;

    public Mono<Void> apply(String id){
        return iProviderRepository.findById(id)
                .flatMap(c -> iProviderRepository.deleteById(c.getId()));
    }
}
