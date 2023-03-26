package com.kodilla.patterns2.observer.homework;

public class Mentor implements TaskObserver {
    private final String name;
    private int taskCheckCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(TaskQueue taskQueue) {
        System.out.println(name + ": New tasks in queue for student " + taskQueue.getName() + "\n" +
                " (total: " + taskQueue.getTasks().size() + " tasks)");
        taskCheckCount++;
    }

    public String getName() {
        return name;
    }

    public int getTaskCheckCount() {
        return taskCheckCount;
    }
}