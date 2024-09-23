package com.example.patrimoine.controller;

import com.example.patrimoine.entity.PatrimoineEntity;
import com.example.patrimoine.services.PatrimoineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patrimoines")
public class PatrimoineController {

    private final PatrimoineService patrimoineService = new PatrimoineService();

    @PutMapping("/{id}")
    public ResponseEntity<PatrimoineEntity> createOrUpdatePatrimoine(
        @PathVariable int id,
        @RequestBody PatrimoineEntity patrimoine
    ) {
        PatrimoineEntity savedPatrimoine = patrimoineService.saveOrUpdate(
            id,
            patrimoine
        );
        return new ResponseEntity<>(savedPatrimoine, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatrimoineEntity> getPatrimoineById(
        @PathVariable int id
    ) {
        PatrimoineEntity patrimoine = patrimoineService.findById(id);
        if (patrimoine != null) {
            return new ResponseEntity<>(patrimoine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
