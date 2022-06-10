package com.sofkau.store.usecase;


import com.sofkau.store.dto.ReceiptDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateReceiptsUseCase {
    @Autowired
    private IReceiptRepository iReceiptRepository;
    @Autowired
    private StoreMapper storeMapper;

    public Mono<ReceiptDTO> apply(ReceiptDTO dto){
        return iReceiptRepository
                .save(storeMapper.toEntity(dto))
                .map(storeMapper::toReceiptDTO);
    }
}
