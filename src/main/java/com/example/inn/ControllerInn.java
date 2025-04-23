package com.example.inn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ControllerInn {
    private final InnService innService;

    @Autowired
    public ControllerInn(InnService innService) {
        this.innService = innService;
    }

    @PostMapping("/validate")
    public String validateInn(@RequestBody String inn) {
        return innService.validateInn(inn);
    }

    @PostMapping("/validate-file")
    public List<String> validateInnFromFile(@RequestParam("file") MultipartFile file) {
        List<String> results = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String validationResult = innService.validateInn(line.trim());
                results.add("ИНН: " + line + " - " + validationResult);
            }
        } catch (IOException e) {
            results.add("Ошибка при чтении файла: " + e.getMessage());
        }
        return results;
    }
}
