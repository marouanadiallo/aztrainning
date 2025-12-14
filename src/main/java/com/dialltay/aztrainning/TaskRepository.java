package com.dialltay.aztrainning;

import java.util.Set;

public interface TaskRepository {
    Long save(Task task);
    Set<Task> findTop10Tasks();
}
