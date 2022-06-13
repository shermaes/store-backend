package com.sofkau.store.usecase;

import com.sofkau.store.collection.Provider;
import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


@SpringBootTest
class GetProviderUseCaseTest {

    private GetProviderUseCase getProviderUseCase;
    @Autowired
    private StoreMapper storeMapper;
    @Mock
    IProviderRepository providerRepository;

    @BeforeEach
    void setUp() {
        getProviderUseCase = new GetProviderUseCase(providerRepository,storeMapper);
    }

    @Test
    public void getProviderTest() {

        Provider provider = new Provider("12","Sherilyn", "AER789W","0123487");
        Provider provider2 = new Provider("13","Marcos", "AER785W","875451");
        Provider provider3 = new Provider("14","Josep", "AER963W","978465");
        Mockito.when(providerRepository.findAll()).thenReturn(Flux.just(provider, provider2, provider3));
        Flux<ProviderDTO> publisher = getProviderUseCase.apply();

        StepVerifier
                .create(publisher).expectNextCount(3)
//                .expectNext(provider2)
//                .expectNext(provider3)
                .verifyComplete();

        Mockito.verify(providerRepository).findAll();
    }

}