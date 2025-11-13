package com.parabank.utils;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonDataReader {

    public static List<Map<String, String>> getTestData(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Map<String, String>>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read JSON test data file: " + filePath);
        }
    }

    public static Map<String, String> getDataByTestName(String filePath, String testName) {
        return getTestData(filePath).stream()
                .filter(data -> data.get("testName").equalsIgnoreCase(testName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Test data not found for: " + testName));
    }
}
