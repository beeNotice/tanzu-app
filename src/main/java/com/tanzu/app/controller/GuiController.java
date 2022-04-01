package com.tanzu.app.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tanzu.app.domain.Hello;
import com.tanzu.app.repository.ConfigRepository;
import com.tanzu.app.repository.HelloRepository;

@Controller
public class GuiController {

  private static final Logger LOG = LoggerFactory.getLogger(GuiController.class);

  @Value("${tanzu.super-feature.enabled}")
  private boolean featureEnabled;

  private HelloRepository helloRepository;

  private ConfigRepository configRepository;

  private final AtomicInteger counter = new AtomicInteger();

  public GuiController(HelloRepository helloRepository, ConfigRepository configRepository) {
    this.helloRepository = helloRepository;
    this.configRepository = configRepository;
  }

  @GetMapping("/")
  @Transactional(readOnly = true)
  public String greeting(Model model) {
    LOG.info("Hello, with super enabled -> {}", featureEnabled);
    List<Hello> hellos = helloRepository.findAllEagered();
    model.addAttribute("hello", hellos.get(counter.getAndIncrement() % hellos.size()));
    model.addAttribute("color", configRepository.getById("COLOR").getVal());
    return "hello";
  }

}
