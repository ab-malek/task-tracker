package com.malek.tasks.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malek.tasks.domain.entities.TaskList;

public interface TaskListRepository extends JpaRepository<TaskList, UUID> {
}
