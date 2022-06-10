package com.sofkau.store.usecase;

import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UpdateProviderUseCase {

    @Autowired
    private IProviderRepository iProviderRepository;
    @Autowired
    private StoreMapper storeMapper;
    public Mono<ProviderDTO> apply(ProviderDTO dto){return iProviderRepository.save(storeMapper.toEntity(dto)).map(storeMapper::toProviderDTO);}
    //This is a Mono because I'm just updating one
}
