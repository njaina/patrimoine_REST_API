package com.example.patrimoine.services;

import com.example.patrimoine.entity.PatrimoineEntity;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PatrimoineService {

    private Map<Integer, PatrimoineEntity> patrimoineMap = new HashMap<>();

    public PatrimoineEntity saveOrUpdate(int id, PatrimoineEntity patrimoine) {
        patrimoine.setDerniereModification(LocalDateTime.now());
        patrimoine.setId(id); // Définir l'ID pour l'entité
        patrimoineMap.put(id, patrimoine);
        return patrimoine;
    }

    public PatrimoineEntity findById(int id) {
        return patrimoineMap.get(id);
    }
}
