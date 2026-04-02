package com.works.controller;

import com.works.dto.ProductSaveRequestDto;
import com.works.entity.Product;
import com.works.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductRestController {

    final ProductService productService;

    @PostMapping("save")
    public Product save(@Valid @RequestBody ProductSaveRequestDto productSaveRequestDto){
        return productService.save(productSaveRequestDto);
    }

    @PostMapping("saveAll")
    public List<Product> saveAll(@Valid @RequestBody List<ProductSaveRequestDto> productSaveRequestDtos){
        return productService.saveAll(productSaveRequestDtos);
    }

}
