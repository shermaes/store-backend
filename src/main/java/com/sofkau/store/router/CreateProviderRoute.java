package com.sofkau.store.router;

import com.sofkau.store.collection.Provider;
import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.usecase.CreateProviderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateProviderRoute {
    @Bean
    @RouterOperation(path = "/api/create/provider", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = CreateProviderUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "createProvider", responses = {
                    @ApiResponse(responseCode = "201", description = "successful operation", content = @Content(schema = @Schema(implementation = Provider.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid provider details supplied")}
                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = Provider.class)))
            ))
    public RouterFunction<ServerResponse> createProvider(CreateProviderUseCase createProviderUseCase) {
        return route(POST("/api/create/provider").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderDTO.class)
                        .flatMap(providerDTO -> createProviderUseCase.apply(providerDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
