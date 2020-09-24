package ru.sibintek.test.jsonsstorage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Swagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sibintek.test.jsonsstorage.config.SwaggerConfig;
import ru.sibintek.test.jsonsstorage.domain.Storage;
import ru.sibintek.test.jsonsstorage.service.SearchService;

import java.util.List;

@Api(tags = SwaggerConfig.TagNames.SEARCH)
@RestController
@RequestMapping("search")
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    @ApiOperation("Метод поиска по ключу")
    public List<Storage> search(@ApiParam("Параметр в виде ключа") @RequestParam(name = "key", required = false, defaultValue = "id") String key) {
        return searchService.searchByKey(key);
    }

    @GetMapping("by_id")
    @ApiOperation("Метод поиска по значению id")
    public List<Storage> searchById(@ApiParam("Значения id") @RequestParam(name = "value") String value) {
        return searchService.getById(value);
    }
}
