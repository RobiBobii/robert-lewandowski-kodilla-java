package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.doneList.addTask("1");
        board.inProgressList.addTask("2");
        board.toDoList.addTask("3");
        //Then
        board.doneList.showTasks();
        board.inProgressList.showTasks();
        board.toDoList.showTasks();
    }
}