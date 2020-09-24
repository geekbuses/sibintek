package ru.sibintek.test.jsonsstorage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sibintek.test.jsonsstorage.domain.Storage;
import ru.sibintek.test.jsonsstorage.repo.JsonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service("search")
public class SearchService {
    private final JsonRepository jsonRepository;

    @Autowired
    public SearchService(JsonRepository jsonRepository) {
        this.jsonRepository = jsonRepository;
    }

    public List<Storage> searchByKey(String key) {
        return jsonRepository.findAll()
                .stream()
                .filter(PredicateFactory.filterByKey(key))
                .collect(Collectors.toList());
    }

    public List<Storage> getById(String value) {
        return jsonRepository.findAll()
                .stream()
                .filter(PredicateFactory.filterByValueId(value))
                .collect(Collectors.toList());
    }

}
