package com.tanzu.app.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tanzu.app.domain.Hello;
import com.tanzu.app.repository.HelloRepository;

@Controller
public class GuiController {

	private static final Logger LOG = LoggerFactory.getLogger(GuiController.class);

	private HelloRepository helloRepository;

	private final AtomicInteger counter = new AtomicInteger();

	public GuiController(HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}

	@GetMapping("/")
	public String greeting(Model model) {
		LOG.debug("Hello updated");
		List<Hello> hellos = helloRepository.findAllEagered();
		model.addAttribute("hello", hellos.get(counter.getAndIncrement() % hellos.size()));
		return "hello";
	}

}
