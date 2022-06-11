package com.sofkau.store.usecase;

import com.sofkau.store.dto.BillsDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IBillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateBillUseCase {
    @Autowired
    private IBillsRepository iBillsRepository;
    @Autowired
    private StoreMapper storeMapper;

    public Mono<BillsDTO> apply(BillsDTO dto){
        return iBillsRepository
                .save(storeMapper.toEntity(dto))
                .map(storeMapper::toBillsDTO);
    }
}
