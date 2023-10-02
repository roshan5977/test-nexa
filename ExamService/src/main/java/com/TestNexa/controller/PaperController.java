package com.TestNexa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TestNexa.entity.Paper;
import com.TestNexa.exception.PaperNotFoundException;
import com.TestNexa.service.PaperService;

@RestController
@RequestMapping("/papers")
public class PaperController {

	@Autowired
	private PaperService paperService;

	@PostMapping("/save")
	public ResponseEntity<Paper> savePaper(@RequestBody Paper paper) {
		return ResponseEntity.ok(paperService.createPapers(paper));
	}

	@PutMapping("/update")
	public ResponseEntity<Paper> updatePaper(@RequestBody Paper paper) {
		return ResponseEntity.ok(paperService.updatePapers(paper));
	}

	@DeleteMapping("/delete/{id}")
	public String deletePaper(@PathVariable Long id) {
		paperService.deletePapers(id);
		return id + " Deleted Successfully";
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Paper>> getAllPapers() {
		return ResponseEntity.ok(paperService.getAllPapers());
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Paper> getPaperById(@PathVariable Long id) {
		Optional<Paper> paperById = paperService.getPapersById(id);
		if (!paperById.isPresent()) {
			throw new PaperNotFoundException("Paper not found");
		}
		return ResponseEntity.ok(paperById.get());
	}
}
