package com.taskapi.task07.service;

import com.taskapi.task07.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final Map<Long, Task> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Task create(Task task) {
        long id = sequence.incrementAndGet();
        task.setId(id);
        store.put(id, task);
        return task;
    }
    public Optional<Task> update(Long id, Task updated) {
        return Optional.ofNullable(store.computeIfPresent(id, (k, existing) -> {
            existing.setTitle(updated.getTitle());
            existing.setDescription(updated.getDescription());
            return existing;
        }));
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}
