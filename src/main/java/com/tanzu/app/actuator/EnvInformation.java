package com.tanzu.app.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tanzu.app.repository.ConfigRepository;

@Component
public class EnvInformation implements InfoContributor {

  @Value("${tanzu.super-feature.enabled}")
  private boolean featureEnabled;

  private ConfigRepository configRepository;

  public EnvInformation(ConfigRepository configRepository) {
    this.configRepository = configRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public void contribute(Builder builder) {
    builder.withDetail("environment", configRepository.getReferenceById("ENV").getVal())
            .withDetail("featureEnabled", featureEnabled);
  }

}
