package com.TestNexa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TestNexa.entity.Options;
import com.TestNexa.exception.OptionNotFoundException;
import com.TestNexa.service.OptionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/options")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/save")
    public ResponseEntity<Options> saveOption(@RequestBody Options option) {
        return ResponseEntity.ok(optionService.createOptions(option));
    }

    @PutMapping("/update")
    public ResponseEntity<Options> updateOption(@RequestBody Options option) {
        return ResponseEntity.ok(optionService.updateOptions(option));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOption(@PathVariable Long id) {
        optionService.deleteOptions(id);
        return id + " Deleted Successfully";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Options>> getAllOptions() {
        return ResponseEntity.ok(optionService.getAllOptions());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Options> getOptionById(@PathVariable Long id) {
        Optional<Options> optionById = optionService.getOptionsById(id);
        if (!optionById.isPresent()) {
            throw new OptionNotFoundException("Option not found");
        }
        return ResponseEntity.ok(optionById.get());
    }
}
