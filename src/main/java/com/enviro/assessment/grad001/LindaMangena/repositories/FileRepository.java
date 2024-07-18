package com.enviro.assessment.grad001.LindaMangena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enviro.assessment.grad001.LindaMangena.models.FileData;

public interface FileRepository extends JpaRepository<FileData, Long> {
}
