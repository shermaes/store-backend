package com.sofkau.store.usecase;

import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetProviderUseCase {
    @Autowired
    private IProviderRepository iProviderRepository;
    @Autowired
    private StoreMapper storeMapper;

    public Flux<ProviderDTO> apply(){return iProviderRepository.findAll().map(storeMapper::toProviderDTO);}
}
