package ru.sibintek.test.jsonsstorage.repo;

public interface Query {
    String INSERT_INTO = "INSERT INTO storage (data) VALUES (:data)";
    String SELECT_ALL = "SELECT * FROM storage";
}
