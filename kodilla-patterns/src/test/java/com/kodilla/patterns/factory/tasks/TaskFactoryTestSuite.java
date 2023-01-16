package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDrivingTask(){
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Task drivingTask = factory.makeTask(TaskFactory.DRIVINGTASK);
        Assert.assertNotNull(drivingTask);
        drivingTask.executeTask();
        //then
        Assert.assertEquals(true, drivingTask.isTaskExecuted().booleanValue());
        Assert.assertEquals("Drive Abroad", drivingTask.getTaskName());
    }

    @Test
    public void testFactoryShoppingTask(){
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPINGTASK);
        Assert.assertNotNull(shoppingTask);
        shoppingTask.executeTask();
        //then
        Assert.assertEquals(true, shoppingTask.isTaskExecuted().booleanValue());
        Assert.assertEquals("Preparing Italian Food", shoppingTask.getTaskName());
    }

    @Test
    public void testFactoryPaintingTask(){
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Task paintingTask = factory.makeTask(TaskFactory.PAINTINGTASK);
        Assert.assertNotNull(paintingTask);
        paintingTask.executeTask();
        //then
        Assert.assertEquals(true, paintingTask.isTaskExecuted().booleanValue());
        Assert.assertEquals("Picasso Style Painting", paintingTask.getTaskName());
    }
}