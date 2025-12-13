package com.dialltay.aztrainning;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService {

    @Override
    public List<Task> getAllTasks() {
        return List.of(
                new Task(1L, "Task 1", "Description for Task 1"),
                new Task(2L, "Task 2", "Description for Task 2"),
                new Task(3L, "Task 3", "Description for Task 3")
        );
    }

    @Override
    public void addTask(Task task) {

    }
}
