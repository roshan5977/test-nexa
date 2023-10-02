package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.Options;

public interface OptionService {
	public List<Options> getAllOptions();

	public Optional<Options> getOptionsById(Long id);

	public Options createOptions(Options options);

	public Options updateOptions(Options options);

	public void deleteOptions(Long id);
}
