package com.example.patrimoine;

import static org.junit.jupiter.api.Assertions.*;

import com.example.patrimoine.dto.PatrimoineDTO;
import com.example.patrimoine.entity.PatrimoineEntity;
import com.example.patrimoine.services.PatrimoineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PatrimoineServiceTest {

    private PatrimoineService patrimoineService;

    @BeforeEach
    public void setUp() {
        patrimoineService = new PatrimoineService();
    }

    @Test
    public void testSaveOrUpdate() {
        PatrimoineDTO dto = new PatrimoineDTO();
        dto.setPossesseur("John Doe");
        PatrimoineEntity savedEntity = patrimoineService.saveOrUpdate(1, dto);

        assertEquals("John Doe", savedEntity.getPossesseur());
        assertNotNull(savedEntity.getDerniereModification());
    }

    @Test
    public void testFindById() {
        PatrimoineDTO dto = new PatrimoineDTO();
        dto.setPossesseur("Jane Doe");
        patrimoineService.saveOrUpdate(2, dto);

        PatrimoineDTO found = patrimoineService.findById(2);
        assertNotNull(found);
        assertEquals("Jane Doe", found.getPossesseur());
    }

    @Test
    public void testFindByIdNotFound() {
        PatrimoineDTO found = patrimoineService.findById(999);
        assertNull(found);
    }
}
