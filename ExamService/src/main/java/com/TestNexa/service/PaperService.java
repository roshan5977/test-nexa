package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.Paper;

public interface PaperService {
	public List<Paper> getAllPapers();

	public Optional<Paper> getPapersById(Long id);

	public Paper createPapers(Paper paper);

	public Paper updatePapers(Paper paper);

	public void deletePapers(Long id);
}
