package com.example.simple_rest_api.service;

import com.example.simple_rest_api.model.Store;
import com.example.simple_rest_api.model.TransformedStore;
import com.example.simple_rest_api.validator.StoreValidator;
import java.sql.Timestamp;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

  public static final String UNDERSCORE_CHARACTER = "_";

  private final List<StoreValidator> storeValidators;

  @Override
  public TransformedStore transform(Store store) {
    storeValidators.forEach(validator -> validator.validate(store));
    return new TransformedStore(
        store.getName(),
        findAndConvertSnakeCasesToCamelCase(eliminateDuplicates(store.getItems())).stream()
            .distinct()
            .toList(),
        new Timestamp(System.currentTimeMillis()));
  }

  private List<String> eliminateDuplicates(List<String> items) {
    return items.stream().distinct().toList();
  }

  private List<String> findAndConvertSnakeCasesToCamelCase(List<String> items) {
    return items.stream()
        .map(
            item -> {
              if (item.contains(UNDERSCORE_CHARACTER)) {
                item = convertSnakeCaseToCamelCase(item);
              }
              return item;
            })
        .toList();
  }

  private String convertSnakeCaseToCamelCase(String item) {
    StringBuilder builder = new StringBuilder(item);
    builder.replace(0, 1, builder.substring(0, 1).toLowerCase());

    for (int i = 1; i < builder.length(); i++) {
      if (builder.charAt(i) == UNDERSCORE_CHARACTER.charAt(0)) {
        builder.replace(i, i + 2, builder.substring(i + 1, i + 2).toUpperCase());
      }
    }
    return builder.toString();
  }
}