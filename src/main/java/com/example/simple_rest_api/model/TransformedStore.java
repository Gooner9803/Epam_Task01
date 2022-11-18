package com.example.simple_rest_api.model;

import java.sql.Timestamp;
import java.util.List;
import lombok.Data;

@Data
public class TransformedStore extends Store {
  private Timestamp timestamp;

  public TransformedStore(String name, List<String> items, Timestamp timestamp) {
        super(name, items);
        this.timestamp = timestamp;
    }
}