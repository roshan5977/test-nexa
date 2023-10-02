package com.TestNexa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestNexa.entity.Paper;
import com.TestNexa.exception.PaperNotFoundException;
import com.TestNexa.repository.PaperRepository;
import com.TestNexa.service.PaperService;

@Service
public class PaperServiceImplementation implements PaperService {

    @Autowired
    private PaperRepository paperRepository;

    @Override
    public List<Paper> getAllPapers() {
        return paperRepository.findAll();
    }

    @Override
    public Optional<Paper> getPapersById(Long id) {
        return paperRepository.findById(id);
    }

    @Override
    public Paper createPapers(Paper paper) {
        return paperRepository.save(paper);
    }

    @Override
    public Paper updatePapers(Paper paper) {
        if (paper == null || paper.getPaper_id() == null) {
            throw new IllegalArgumentException("Paper or ID cannot be null");
        }

        Optional<Paper> existingPaper = paperRepository.findById(paper.getPaper_id());

        if (!existingPaper.isPresent()) {
            throw new PaperNotFoundException("Paper not found with ID: " + paper.getPaper_id());
        }

        return paperRepository.save(paper);
    }

    @Override
    public void deletePapers(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid paper ID");
        }

        Optional<Paper> existingPaper = paperRepository.findById(id);

        if (!existingPaper.isPresent()) {
            throw new PaperNotFoundException("Paper not found with ID: " + id);
        }

        try {
            paperRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete paper with ID: " + id, e);
        }
    }
}
