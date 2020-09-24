package ru.sibintek.test.jsonsstorage.domain;

import org.springframework.jdbc.core.RowMapper;
import ru.sibintek.test.jsonsstorage.util.JsonUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class Storage {
    private Map<String, String> storage;

    public Map<String, String> getStorage() {
        return storage;
    }

    public void setStorage(Map<String, String> storage) {
        this.storage = storage;
    }


    public static class StorageMapper implements RowMapper<Storage> {
        @Override
        public Storage mapRow(ResultSet resultSet, int i) throws SQLException {
            Storage storage = new Storage();
            storage.setStorage(JsonUtils.jsonAsStrMap(resultSet.getString("data")));
            return storage;
        }
    }
}
