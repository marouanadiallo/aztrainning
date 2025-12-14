package com.dialltay.aztrainning;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Set;

@Repository
public class TaskRepositoryImp implements TaskRepository {

    private final JdbcClient jdbcClient;
    public TaskRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Long save(Task task) {
        String sql = "INSERT INTO tasks (title, description, status, business_key) VALUES (?, ?, ?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(sql)
                .param(task.getTitle())
                .param(task.getDescription())
                .param(task.getStatus().name())
                .param(task.getBusinessKey().toString())
                .update(keyHolder, "id");
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public Set<Task> findTop10Tasks() {
        String sql = "SELECT id, title, description, status, business_key FROM tasks ORDER BY id DESC LIMIT 10";
        return Set.copyOf(
                jdbcClient.sql(sql)
                        .query((rs, rowNum) -> new Task(
                                rs.getLong("id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                TaskStatus.valueOf(rs.getString("status")),
                                java.util.UUID.fromString(rs.getString("business_key"))
                        ))
                        .list()
        );
    }
}
