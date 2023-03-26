package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskQueueTestSuite {

    @Test
    public void testUpdate() {
        // Given
        Student robertLewandowski = new Student("RobertLewandowski");
        Student dumbStudent = new Student("DumbStudent");
        Mentor javaMentor = new Mentor("JavaMentor");
        Mentor sqlMentor = new Mentor("SqlMentor");
        robertLewandowski.registerObserver(javaMentor);
        robertLewandowski.registerObserver(sqlMentor);
        dumbStudent.registerObserver(javaMentor);
        // When
        robertLewandowski.addTask(new Task("http://www.koodilla.com/facade"));
        robertLewandowski.addTask(new Task("http://www.koodilla.com/aspect"));
        robertLewandowski.addTask(new Task("http://www.koodilla.com/observer"));
        dumbStudent.addTask(new Task("http://www.koodilla.com/adapter"));
        dumbStudent.addTask(new Task("http://www.koodilla.com/decor"));
        // Then
        System.out.println(javaMentor.getName() + " " + javaMentor.getTaskCheckCount());
        System.out.println(sqlMentor.getName() + " " + sqlMentor.getTaskCheckCount());
        assertEquals(5, javaMentor.getTaskCheckCount());
        assertEquals(3, sqlMentor.getTaskCheckCount());
    }
}