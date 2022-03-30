package com.tanzu.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({ "local", "test" })
class TanzuAppApplicationTests {

  @Test
  void contextLoads() {
  }

}
