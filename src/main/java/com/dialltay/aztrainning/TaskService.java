package com.dialltay.aztrainning;

import java.util.Set;

public interface TaskService {
    Set<Task> getTop10Tasks();
    Long addTask(Task task);
}
