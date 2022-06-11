package com.sofkau.store.usecase;

import com.sofkau.store.dto.ReceiptDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetReceiptsUseCase {
    @Autowired
    private IReceiptRepository iReceiptRepository;
    @Autowired
    private StoreMapper storeMapper;

    public Flux<ReceiptDTO> apply(){return iReceiptRepository.findAll().map(storeMapper::toReceiptDTO);}
}
