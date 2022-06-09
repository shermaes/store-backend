package com.sofkau.store.usecase;

import com.sofkau.store.dto.ProductDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetProductsUseCase {
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private StoreMapper storeMapper;

    public Flux<ProductDTO> apply(){return iProductRepository.findAll().map(storeMapper::toProductDTO);}
}
