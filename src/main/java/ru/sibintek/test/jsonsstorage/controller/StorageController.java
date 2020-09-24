package ru.sibintek.test.jsonsstorage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sibintek.test.jsonsstorage.config.SwaggerConfig;
import ru.sibintek.test.jsonsstorage.domain.Storage;
import ru.sibintek.test.jsonsstorage.service.DataService;

import java.util.List;
import java.util.Map;

@Api(tags = SwaggerConfig.TagNames.STORAGE)
@RestController
@RequestMapping("storage")
public class StorageController {

    private final DataService dataService;

    @Autowired
    public StorageController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping
    @ApiOperation("Сохранения данных в хранилище")
    public void save(@ApiParam("Данные для сохранения") @RequestBody Map<String, String> data) {
        dataService.save(data);
    }

    @GetMapping
    @ApiOperation("Список всех данных  из хранилиша")
    public List<Storage> getAll(){
        return dataService.getAll();
    }

}
