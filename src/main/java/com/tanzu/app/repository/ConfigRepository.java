package com.tanzu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanzu.app.domain.Config;

public interface ConfigRepository extends JpaRepository<Config, String> {

}
