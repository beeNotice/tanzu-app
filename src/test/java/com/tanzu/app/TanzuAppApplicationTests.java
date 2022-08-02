package com.tanzu.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tanzu.app.domain.Hello;
import com.tanzu.app.repository.HelloRepository;

@SpringBootTest
@ActiveProfiles({ "local", "test" })
class TanzuAppApplicationTests {

  private static final Logger LOG = LoggerFactory.getLogger(TanzuAppApplicationTests.class);

  @Autowired
  private HelloRepository helloRepository;

  @Test
  void testHelloes() {
    List<Hello> helloes = helloRepository.findAll();
    assertThat(helloes).hasSize(3);
    helloes.stream().forEach(h -> LOG.debug("{} / {}", h.getA().getName(), h.getB().getName()));
  }

}
