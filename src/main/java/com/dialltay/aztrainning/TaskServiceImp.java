package com.dialltay.aztrainning;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;
    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Set<Task> getTop10Tasks() {
       return this.taskRepository.findTop10Tasks();
    }

    @Override
    public Long addTask(Task task) {
        return this.taskRepository.save(task);
    }
}
