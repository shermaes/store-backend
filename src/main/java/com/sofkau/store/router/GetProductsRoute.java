package com.sofkau.store.router;

import com.sofkau.store.collection.Product;
import com.sofkau.store.collection.Provider;
import com.sofkau.store.dto.ProductDTO;
import com.sofkau.store.usecase.GetProductsUseCase;
import com.sofkau.store.usecase.GetProviderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetProductsRoute {
    @Bean
    @RouterOperation(path = "/api/get/products",
            produces = {
            MediaType.APPLICATION_JSON_VALUE},
            beanClass = GetProductsUseCase.class, method = RequestMethod.GET, beanMethod = "apply",
            operation = @Operation(operationId = "getProducts", responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation",
                            content = @Content(schema = @Schema(implementation = Product.class)))}
            ))
    public RouterFunction<ServerResponse> allProducts(GetProductsUseCase get) {
        return route(GET("/api/get/products"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(get.apply(), ProductDTO.class))
        );
    }
}
