package com.example.simple_rest_api.controller;

import com.example.simple_rest_api.model.Store;
import com.example.simple_rest_api.model.TransformedStore;
import com.example.simple_rest_api.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

  private final StoreService service;

  @PostMapping("/transformation")
  public ResponseEntity<TransformedStore> transform(@RequestBody Store store) {
    return ResponseEntity.ok().body(service.transform(store));
    }
}