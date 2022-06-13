package com.sofkau.store.usecase;

import com.sofkau.store.collection.Product;
import com.sofkau.store.dto.ProductDTO;
import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.mapper.StoreMapper;
import com.sofkau.store.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


@SpringBootTest
class GetProductsUseCaseTest {

    private GetProductsUseCase getProductsUseCase;
    @Autowired
    private StoreMapper storeMapper;
    @Mock
    IProductRepository iproductRepository;

    @BeforeEach
    void setUp() {
        getProductsUseCase = new GetProductsUseCase(iproductRepository,storeMapper);
    }

    @Test
    public void getProductTest() {
        Product product = new Product("2", "ash",5,5,"scre2","Used for bla bla bla",8,9.87841646);
        Product product2 = new Product("3", "ash",5,5,"scre2","Used for bla bla bla",8,9.54164674);

        Mockito.when(iproductRepository.findAll()).thenReturn(Flux.just(product, product2));
        Flux<ProductDTO> publisher = getProductsUseCase.apply();

        StepVerifier
                .create(publisher).expectNextCount(2).verifyComplete();

        Mockito.verify(iproductRepository).findAll();
    }
}