package ru.sibintek.test.jsonsstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sibintek.test.jsonsstorage.domain.Storage;
import ru.sibintek.test.jsonsstorage.service.DataService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("storage")
public class StorageController {

    private final DataService dataService;

    @Autowired
    public StorageController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping
    public void save(@RequestBody Map<String, String> data) {
        dataService.save(data);
    }

    @GetMapping
    public List<Storage> getAll(){
        return dataService.getAll();
    }

}
