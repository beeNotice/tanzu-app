package com.tanzu.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeController {

  // 900003883
  @GetMapping("/prime/{num}")
  public String prime(@PathVariable long num) {

    for (long i = 2; i <= num / 2; ++i) {
      // condition for non prime number
      if (num % i == 0) {
        return String.format("%s is not a prime number", num);
      }
    }

    return String.format("%s is a prime number", num);
  }

}
