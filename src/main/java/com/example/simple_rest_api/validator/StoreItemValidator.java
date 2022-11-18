package com.example.simple_rest_api.validator;

import com.example.simple_rest_api.exception.InvalidStoreException;
import com.example.simple_rest_api.model.Store;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class StoreItemValidator implements StoreValidator {

  public static final String VALID_ITEM_PATTERN = "^[a-zA-Z_]*$";

  @Override
  public void validate(Store store) {
    if (!store.getItems().stream()
        .allMatch(item -> Pattern.compile(VALID_ITEM_PATTERN).matcher(item).matches())) {
      throw new InvalidStoreException();
    }
  }
}
