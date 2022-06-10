package com.sofkau.store.usecase;

import com.sofkau.store.dto.ProductDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateProductUseCase {
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private StoreMapper storeMapper;

    public Mono<ProductDTO> apply(ProductDTO dto){
        return iProductRepository
                .save(storeMapper.toEntity(dto))
                .map(storeMapper::toProductDTO);}
}
