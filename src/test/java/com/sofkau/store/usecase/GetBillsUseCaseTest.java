package com.sofkau.store.usecase;

import com.sofkau.store.collection.Bills;
import com.sofkau.store.collection.Product;
import com.sofkau.store.dto.BillsDTO;
import com.sofkau.store.dto.ProductDTO;
import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IBillsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GetBillsUseCaseTest {
    private GetBillsUseCase getBillsUseCase;
    @Autowired
    private StoreMapper storeMapper;
    @Mock
    IBillsRepository iBillsRepository;

    @BeforeEach
    void setUp() {
        getBillsUseCase = new GetBillsUseCase(iBillsRepository, storeMapper);
    }

    @Test
    public void getBillsTest() {

        Bills bill = new Bills("4", "08/07/90", "Ash", 5, "Marcos", "screw", 1.2);
        Bills bill2 = new Bills("5", "08/07/90", "Ash", 5, "Marcos", "screw", 1.2);

        Mockito.when(iBillsRepository.findAll()).thenReturn(Flux.just(bill, bill2));
        Flux<BillsDTO> publisher = getBillsUseCase.apply();

        StepVerifier
                .create(publisher).expectNextCount(2).verifyComplete();

        Mockito.verify(iBillsRepository).findAll();
    }
}