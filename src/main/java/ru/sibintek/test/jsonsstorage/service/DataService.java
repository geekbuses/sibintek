package ru.sibintek.test.jsonsstorage.service;

import ru.sibintek.test.jsonsstorage.domain.Storage;

import java.util.List;
import java.util.Map;

public interface DataService {
    void save(Map<String, String> data);

    boolean validate(Map<String, String> data);

    List<Storage> getAll();

//    List<Storage> getById(String value);
}
