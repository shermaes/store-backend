package com.sofkau.store.usecase;

import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.dto.ReceiptDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CreateReceiptsUseCaseTest {

    @MockBean
    private CreateReceiptsUseCase createReceiptsUseCase;

    @Test
    void createReceiptsUseCaseTest(){
        ReceiptDTO dto = new ReceiptDTO();
        dto.setDate("02/07/99");
        dto.setId("AE789");
        dto.setProvider("Screwgees");
        dto.setId_product("AWE87");
        dto.setQuantity(5);
        StepVerifier.create(Mono.just(Mockito.when(createReceiptsUseCase.apply(dto))
                .thenReturn(Mono.just(dto)))).expectNextCount(1).verifyComplete();

    }
}