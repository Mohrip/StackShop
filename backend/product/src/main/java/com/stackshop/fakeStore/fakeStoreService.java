package com.stackshop.fakeStore;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;



import java.util.List;
import java.util.ArrayList;

@Service
public class fakeStoreService {

    public List< Object> getFakeStore() {
        String url = "https://fakestoreapi.com/products";
        String url2 = "https://dummyjson.com/products";
        RestTemplate restTemplate = new RestTemplate();


        String responseJson = restTemplate.getForObject(url, String.class);
        String responseJson2 = restTemplate.getForObject(url2, String.class);
        
        


        ObjectMapper objectMapper = new ObjectMapper();
        List<fakeStoreDTO> products = new ArrayList<>();
        List<DummyProductDTO> dummyProducts = new ArrayList<>();

        try {
            products = objectMapper.readValue(responseJson, new TypeReference<List<fakeStoreDTO>>() {});
        } catch (JsonProcessingException e) {
            System.err.println("Error processing JSON: " + e.getMessage());
        }

        try {
            dummyProducts = objectMapper.readValue(
                objectMapper.readTree(responseJson2).get("products").toString(),
                new TypeReference<List<DummyProductDTO>>() {}
            );
        } catch (JsonProcessingException e) {
            System.err.println("Error processing JSON2: " + e.getMessage());
        }


     List<Object> combinedProducts = new ArrayList<>();
     combinedProducts.addAll(products);
     combinedProducts.addAll(dummyProducts);

     return combinedProducts;
 }
   
}
