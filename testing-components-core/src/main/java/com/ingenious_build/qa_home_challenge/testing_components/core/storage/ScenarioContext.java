package com.ingenious_build.qa_home_challenge.testing_components.core.storage;

import com.ingenious_build.qa_home_challenge.testing_components.core.enums.StorageKey;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScenarioContext<T extends StorageKey> {

    Map<T, Object> store;

    @Autowired
    public ScenarioContext() {
        this.store = new HashMap<>();
    }

    public void addValue(T key, Object value) {
        store.put(key, value);
    }

    public <U> U getValue(T key, Class<U> clazz) {
        return clazz.cast(store.get(key));
    }

    public <U> List<U> getListValue(T key, Class<U> clazz) {
        return (List<U>) store.get(key);
    }

    public boolean containsKey(T key) {
        return store.containsKey(key);
    }

}
