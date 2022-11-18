package com.example.simple_rest_api.service;

import com.example.simple_rest_api.model.Store;
import com.example.simple_rest_api.model.TransformedStore;

public interface StoreService {

  TransformedStore transform(Store store);
}
