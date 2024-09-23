package com.example.patrimoine.services;

import com.example.patrimoine.dto.PatrimoineDTO;
import com.example.patrimoine.entity.PatrimoineEntity;
import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PatrimoineService {

    private static final String DATA_FOLDER =
        "src/main/java/com/example/patrimoine/data";
    private static final String DATA_FILE = DATA_FOLDER + "patrimoines.txt";
    private Map<Integer, PatrimoineEntity> patrimoineMap = new HashMap<>();

    public PatrimoineService() {
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
        writeDataToFile(patrimoine);
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

    private void writeDataToFile(PatrimoineEntity patrimoine) {
        try (
            BufferedWriter writer = new BufferedWriter(
                new FileWriter(DATA_FILE, true)
            )
        ) {
            writer.write(
                patrimoine.getId() +
                "," +
                patrimoine.getPossesseur() +
                "," +
                patrimoine.getDerniereModification()
            );
            writer.newLine();
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

            try (
                BufferedReader reader = new BufferedReader(new FileReader(file))
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    PatrimoineEntity patrimoine = new PatrimoineEntity();
                    patrimoine.setId(Integer.parseInt(parts[0]));
                    patrimoine.setPossesseur(parts[1]);
                    patrimoine.setDerniereModification(
                        LocalDateTime.parse(parts[2])
                    );
                    patrimoineMap.put(patrimoine.getId(), patrimoine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
