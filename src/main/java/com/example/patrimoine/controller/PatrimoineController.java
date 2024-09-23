package com.example.patrimoine.controller;

import com.example.patrimoine.dto.PatrimoineDTO;
import com.example.patrimoine.services.PatrimoineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patrimoines")
public class PatrimoineController {

    private final PatrimoineService patrimoineService = new PatrimoineService();

    @PutMapping("/{id}")
    public ResponseEntity<PatrimoineDTO> createOrUpdatePatrimoine(
        @PathVariable int id,
        @RequestBody PatrimoineDTO patrimoineDTO
    ) {
        patrimoineService.saveOrUpdate(id, patrimoineDTO);
        return new ResponseEntity<>(
            patrimoineService.findById(id),
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatrimoineDTO> getPatrimoineById(
        @PathVariable int id
    ) {
        PatrimoineDTO patrimoineDTO = patrimoineService.findById(id);
        if (patrimoineDTO != null) {
            return new ResponseEntity<>(patrimoineDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
