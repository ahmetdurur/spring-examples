package com.haydikodlayalim.apiversioning.api;


import com.haydikodlayalim.apiversioning.dto.ProductV1;
import com.haydikodlayalim.apiversioning.dto.ProductV2;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Customizer;
import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductApi {

    // Sample 1 URI Versioning
    // http://localhost:8080/api/v1/product
    @GetMapping(value = "/v1/product")
    public ResponseEntity<ProductV1> pathVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("GTX 1660 SUPER")));
    }

    // http://localhost:8080/api/v2/product
    @GetMapping(value = "/v2/product")
    public ResponseEntity<ProductV2> pathVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("RTX 2070 SUPER" , BigDecimal.valueOf(17000))));
    }

    // Sample 2 PARAM Versioning
    // http://localhost:8080/api/param/product?apiVersion=1
    @GetMapping(value = "/param/product" , params = "apiVersion=1")
    public ResponseEntity<ProductV1> paramVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("GTX 1660 SUPER")));
    }

    // http://localhost:8080/api/param/product?apiVersion=2
    @GetMapping(value = "/param/product", params = "apiVersion=2")
    public ResponseEntity<ProductV2> paramVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("RTX 2070 SUPER" , BigDecimal.valueOf(21000))));
    }

    /* Sample 3 HEADER Versioning
     X-API-VERSION herhangi bir öntanımlı parametre ismi değil
    Custom HttpHeaders tanımı yaparken kullanılan isimlendirme şekli
    bir nevi best practice X-API-VERSION yerine ahmet-version diye
    isimlendirmekte mümkün  */


    // http://localhost:8080/api/header/product
    @GetMapping(value = "/header/product" , headers = "X-API-VERSION=1")
    public ResponseEntity<ProductV1> headerVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("GTX 1660 SUPER")));
    }

    // http://localhost:8080/api/header/product
    @GetMapping(value = "/header/product", headers = "X-API-VERSION=2")
    public ResponseEntity<ProductV2> headerVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("RTX 2070 SUPER" , BigDecimal.valueOf(23500))));
    }



}
