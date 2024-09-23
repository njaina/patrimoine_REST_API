package com.example.patrimoine.services;

import com.example.patrimoine.dto.PatrimoineDTO;
import com.example.patrimoine.entity.PatrimoineEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatrimoineService {

    private static final String DATA_FOLDER =
        "src/main/java/com/example/patrimoine/data";
    private static final String DATA_FILE = DATA_FOLDER + "/patrimoines.json";
    private Map<Integer, PatrimoineEntity> patrimoineMap = new HashMap<>();
    private ObjectMapper objectMapper;

    public PatrimoineService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule()); // Registering the JavaTimeModule
        File folder = new File(DATA_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        loadDataFromFile();
    }

    public PatrimoineEntity saveOrUpdate(int id, PatrimoineDTO patrimoineDTO) {
        PatrimoineEntity patrimoine = new PatrimoineEntity();
        patrimoine.setId(id);
        patrimoine.setPossesseur(patrimoineDTO.getPossesseur());
        patrimoine.setDerniereModification(LocalDateTime.now());
        patrimoineMap.put(id, patrimoine);
        writeDataToFile();
        return patrimoine;
    }

    public PatrimoineDTO findById(int id) {
        PatrimoineEntity patrimoine = patrimoineMap.get(id);
        if (patrimoine != null) {
            PatrimoineDTO dto = new PatrimoineDTO();
            dto.setPossesseur(patrimoine.getPossesseur());
            dto.setDerniereModification(patrimoine.getDerniereModification());
            return dto;
        }
        return null;
    }

    private void writeDataToFile() {
        try {
            objectMapper.writeValue(
                new File(DATA_FILE),
                patrimoineMap.values()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDataFromFile() {
        File file = new File(DATA_FILE);
        try {
            if (!file.exists()) {
                file.createNewFile();
                return;
            }

            List<PatrimoineEntity> list = objectMapper.readValue(
                file,
                new TypeReference<List<PatrimoineEntity>>() {}
            );
            for (PatrimoineEntity patrimoine : list) {
                patrimoineMap.put(patrimoine.getId(), patrimoine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
