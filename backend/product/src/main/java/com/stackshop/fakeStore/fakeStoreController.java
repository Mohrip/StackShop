package com.stackshop.fakeStore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class fakeStoreController {

    @Autowired
    private fakeStoreService fakeStoreService;

    // @GetMapping("/fakeStore")
    // public List<fakeStoreDTO> getFakeStore() {
    //    return fakeStoreService.getFakeStore();
    // }
    @GetMapping("/fakestore")
    public List< Object> getFakeStore() {
        return fakeStoreService.getFakeStore();
    }
    
}
