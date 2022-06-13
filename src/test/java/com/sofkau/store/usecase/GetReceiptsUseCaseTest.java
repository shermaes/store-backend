package com.sofkau.store.usecase;

import com.sofkau.store.collection.Provider;
import com.sofkau.store.collection.Receipt;
import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.dto.ReceiptDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IReceiptRepository;
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
class GetReceiptsUseCaseTest {

    private GetReceiptsUseCase getReceiptsUseCase;

    @Mock
    IReceiptRepository iReceiptRepository;
    @Autowired
    private StoreMapper storeMapper;

    @BeforeEach
    void setUp() {
        getReceiptsUseCase = new GetReceiptsUseCase(iReceiptRepository, storeMapper);
    }

    @Test
    public void getReceiptsTest() {
        Receipt receipt = new Receipt("1","Angel","AER45","01/07/99",5);
        Receipt receipt2 = new Receipt("2","Angel","AER45","01/07/99",5);
        Receipt receipt3 = new Receipt("3","Angel","AER45","01/07/99",5);
        Mockito.when(iReceiptRepository.findAll()).thenReturn(Flux.just(receipt, receipt2, receipt3));

        Flux<ReceiptDTO> publisher = getReceiptsUseCase.apply();

        StepVerifier
                .create(publisher).expectNextCount(3)
//                .expectNext(provider2)
//                .expectNext(provider3)
                .verifyComplete();

        Mockito.verify(iReceiptRepository).findAll();
    }


}