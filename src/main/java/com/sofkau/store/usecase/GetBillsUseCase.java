package com.sofkau.store.usecase;

import com.sofkau.store.dto.BillsDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IBillsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetBillsUseCase {
    @Autowired
    private IBillsRepository iBillsRepository;
    @Autowired
    private StoreMapper storeMapper;

    public Flux<BillsDTO> apply(){return iBillsRepository.findAll().map(storeMapper::toBillsDTO);}

}
