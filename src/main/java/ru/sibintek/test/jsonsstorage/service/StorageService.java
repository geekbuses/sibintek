package ru.sibintek.test.jsonsstorage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sibintek.test.jsonsstorage.domain.Storage;
import ru.sibintek.test.jsonsstorage.repo.JsonRepository;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service("json")
public class StorageService implements DataService {
    private final JsonRepository jsonRepository;

    @Autowired
    public StorageService(JsonRepository jsonRepository) {
        this.jsonRepository = jsonRepository;
    }

    @Override
    public void save(Map<String, String> data) {
        if (!validate(data)) {
            throw new RuntimeException("Валидация провалилась");
        }
        jsonRepository.save(data);
    }

    @Override
    public List<Storage> getAll(){
        return jsonRepository.findAll();
    }
//
//    @Override
//    public List<Storage> getById(String value) {
//        return jsonRepository.findAll()
//                .stream()
//                .filter(filterByValue(value))
//                .collect(Collectors.toList());
//    }
//
//    private Predicate<Storage> filterByValue(String value) {
//        return storage -> storage.getStorage().containsValue(value);
//    }

    @Override
    public boolean validate(Map<String, String> data) {
        return data.containsKey("id");
    }

}
