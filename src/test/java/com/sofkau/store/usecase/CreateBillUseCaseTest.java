package com.sofkau.store.usecase;

import com.sofkau.store.dto.BillsDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CreateBillUseCaseTest {
    @MockBean
    private CreateBillUseCase createBillUseCase;
    @Test
    void createBillUseCase(){
        BillsDTO dto = new BillsDTO();
        dto.setClerk("Marcos");
        dto.setId("78e");
        dto.setDate("02/07/99");
        dto.setClient_name("Ash");
        dto.setQuantity(5);
        dto.setProductsSold("srew #4");
        dto.setTotal_paid(1.2);
        StepVerifier.create(Mono.just(Mockito.when(createBillUseCase.apply(dto))
                .thenReturn(Mono.just(dto)))).expectNextCount(1).verifyComplete();

    }
}