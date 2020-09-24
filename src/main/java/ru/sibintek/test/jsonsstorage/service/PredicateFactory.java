package ru.sibintek.test.jsonsstorage.service;

import ru.sibintek.test.jsonsstorage.domain.Storage;

import java.util.function.Predicate;

public class PredicateFactory {

    public static Predicate<Storage> filterByValueId(String value) {
        return storage -> storage.getStorage().get("id").equalsIgnoreCase(value);
    }
    public static Predicate<Storage> filterByValue(String value) {
        return storage ->
                storage.getStorage().containsValue(value);
    }

    public static Predicate<Storage> filterByKey(String key) {
        return storage -> storage.getStorage().containsKey(key);
    }
}
