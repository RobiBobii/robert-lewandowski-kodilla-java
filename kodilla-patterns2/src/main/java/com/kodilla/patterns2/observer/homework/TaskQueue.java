package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue implements TaskObservable {
    private final List<TaskObserver> observers;
    private final List<Task> tasks;
    private final String name;

    public List<Task> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers();
    }

    public TaskQueue(String name) {
        this.observers = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void registerObserver(TaskObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(TaskObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }
}