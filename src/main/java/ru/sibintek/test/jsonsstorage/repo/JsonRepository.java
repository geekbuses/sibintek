package ru.sibintek.test.jsonsstorage.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.sibintek.test.jsonsstorage.domain.Storage;
import ru.sibintek.test.jsonsstorage.util.JsonUtils;

import java.util.List;
import java.util.Map;

@Repository("json_repo")
public class JsonRepository {
    private final static String INSERT_INTO = Query.INSERT_INTO;
    private final static String SELECT_ALL = Query.SELECT_ALL;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public JsonRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Map<String,String> data){
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("data", JsonUtils.toJson(data));
        jdbcTemplate.update(INSERT_INTO, source);
    }

    public List<Storage> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new Storage.StorageMapper());
    }
}
