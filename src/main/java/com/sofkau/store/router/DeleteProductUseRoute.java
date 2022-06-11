package com.sofkau.store.router;

import com.sofkau.store.usecase.DeleteProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProductUseRoute {
    @Bean
    @RouterOperation(path = "/api/delete/product/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.DELETE, beanClass = DeleteProductUseCase.class, beanMethod = "apply"
            , operation = @Operation(operationId = "deleteProduct", responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "Boolean")),
            @ApiResponse(responseCode = "404", description = "Employee not found")}, parameters = {
            @Parameter(in = ParameterIn.PATH, name = "id")}
    ))
    public RouterFunction<ServerResponse> deleteProduct(DeleteProductUseCase deleteProductUseCase) {
        return route(DELETE("/api/delete/product/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteProductUseCase.apply(request.pathVariable("id"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build())
        );
    }
}
