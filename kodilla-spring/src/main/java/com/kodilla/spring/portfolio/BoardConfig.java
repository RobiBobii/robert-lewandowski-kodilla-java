package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {


    @Bean
    public Board getBoard(TaskList taskToDoList, TaskList taskInProgress, TaskList taskDoneList) {
        return new Board(taskToDoList, taskInProgress, taskDoneList);
    }

    @Bean
    public TaskList taskToDoList() {
        return new TaskList();
    }

    @Bean
    public TaskList taskInProgress() {
        return new TaskList();
    }

    @Bean
    public TaskList taskDoneList() {
        return new TaskList();
    }
}