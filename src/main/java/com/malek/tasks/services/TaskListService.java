package com.malek.tasks.services;

import java.util.List;


import com.malek.tasks.domain.entities.TaskList;

public interface TaskListService {
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
}
