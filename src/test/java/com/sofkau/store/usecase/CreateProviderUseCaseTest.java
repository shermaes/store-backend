package com.sofkau.store.usecase;

import com.sofkau.store.dto.ProviderDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class CreateProviderUseCaseTest {
@MockBean
    private CreateProviderUseCase createProviderUseCase;

    @Test
    void createProviderUseCaseTest(){
        ProviderDTO dto = new ProviderDTO();
        dto.setName("ScrewGees");
        dto.setPassport("ARTEDSW34");
        dto.setId("2");
        dto.setPhone("453628");
        StepVerifier.create(Mono.just(Mockito.when(createProviderUseCase.apply(dto))
                .thenReturn(Mono.just(dto)))).expectNextCount(1).verifyComplete();
    }

}