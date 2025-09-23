package com.taskapi.task07.controller;

import com.taskapi.task07.model.Task;
import com.taskapi.task07.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

    @WebMvcTest(TaskController.class)
    class TaskControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockitoBean
        private TaskService taskService;

        @Test
        void testGetAllTasks() throws Exception {
            Task task1 = new Task(1L, "Task One", "Desc One");
            Task task2 = new Task(2L, "Task Two", "Desc Two");

            given(taskService.findAll()).willReturn(Arrays.asList(task1, task2));

            mockMvc.perform(get("/tasks"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].title").value("Task One"))
                    .andExpect(jsonPath("$[1].title").value("Task Two"));
        }

        @Test
        void testGetTaskById() throws Exception {
            Task task = new Task(1L, "Test Task", "Some description");

            given(taskService.findById(1L)).willReturn(Optional.of(task));

            mockMvc.perform(get("/tasks/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.title").value("Test Task"));
        }

        @Test
        void testCreateTask() throws Exception {
            Task newTask = new Task(1L, "New Task", "Description");

            given(taskService.create(Mockito.any(Task.class))).willReturn(newTask);

            mockMvc.perform(post("/tasks")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"title\":\"New Task\",\"description\":\"Description\"}"))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.title").value("New Task"));
        }

        @Test
        void testUpdateTask() throws Exception {
            Task updatedTask = new Task(1L, "Updated Task", "Updated Desc");

            given(taskService.update(Mockito.eq(1L), Mockito.any(Task.class)))
                    .willReturn(Optional.of(updatedTask));

            mockMvc.perform(put("/tasks/1")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"title\":\"Updated Task\",\"description\":\"Updated Desc\"}"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.title").value("Updated Task"))
                    .andExpect(jsonPath("$.description").value("Updated Desc"));
        }

        @Test
        void testDeleteTask() throws Exception {
            given(taskService.delete(1L)).willReturn(true);

            mockMvc.perform(delete("/tasks/1"))
                    .andExpect(status().isNoContent());
        }
    }

