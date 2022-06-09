package com.sofkau.store.mapper;

import com.sofkau.store.collection.Bills;
import com.sofkau.store.collection.Product;
import com.sofkau.store.collection.Provider;
import com.sofkau.store.collection.Receipt;
import com.sofkau.store.dto.BillsDTO;
import com.sofkau.store.dto.ProductDTO;
import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.dto.ReceiptDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
@RequiredArgsConstructor
public class StoreMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public BillsDTO toBillsDTO(Bills bills){return modelMapper.map(bills,BillsDTO.class);}
    public Bills toEntity(BillsDTO dto){return modelMapper.map(dto, Bills.class);}

    public ProductDTO toProductDTO(Product product){return modelMapper.map(product, ProductDTO.class);}
    public Product toEntity(ProductDTO dto){return modelMapper.map(dto, Product.class);}

    public ProviderDTO toProviderDTO(Provider provider){return modelMapper.map(provider, ProviderDTO.class);}
    public Provider toEntity(ProviderDTO dto){return modelMapper.map(dto, Provider.class);}

    public ReceiptDTO toReceiptDTO(Receipt receipt){return modelMapper.map(receipt, ReceiptDTO.class);}
    public Receipt toEntity(ReceiptDTO dto){return modelMapper.map(dto, Receipt.class);}

}
