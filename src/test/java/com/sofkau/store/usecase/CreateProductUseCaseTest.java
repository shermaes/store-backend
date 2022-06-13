package com.sofkau.store.usecase;

import com.sofkau.store.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CreateProductUseCaseTest {
    @MockBean
    private CreateProductUseCase createProductUseCase;
    @Test
    public void setCreateProductUseCaseTest() {
        ProductDTO dto = new ProductDTO();
        dto.setName_product("screw");
        dto.setDescription("Used for chairs");
        dto.setId("2");
        dto.setMaximum(8);
        dto.setMinimum(10);
        dto.setPrice(1.3);
        dto.setUnits_available(0);
        dto.setProvider("Screwgees");

        StepVerifier.create(Mono.just(Mockito.when(createProductUseCase.apply(dto))
                .thenReturn(Mono.just(dto)))).expectNextCount(1).verifyComplete();
    }
}