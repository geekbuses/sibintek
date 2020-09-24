package ru.sibintek.test.jsonsstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sibintek.test.jsonsstorage.domain.Storage;
import ru.sibintek.test.jsonsstorage.service.SearchService;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public List<Storage> search(@RequestParam(name = "key", required = false, defaultValue = "id") String key) {
        return searchService.searchByKey(key);
    }

    @GetMapping("by_id")
    public List<Storage> searchById(@RequestParam(name = "value") String value) {
        return searchService.getById(value);
    }
}
