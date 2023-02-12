package com.kodilla.kodillahibernate.tasklist.dao;

import com.kodilla.kodillahibernate.task.Task;
import com.kodilla.kodillahibernate.task.dao.TaskDao;
import com.kodilla.kodillahibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    @Autowired
    private TaskDao taskDao;
    private static final String LISTNAME = "The name of list";
    private static final String DESCRIPTION = "Test description";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
        taskListDao.save(taskList);
        String taskListName = taskList.getListName();
        //When
        List<TaskList> listOfTasks = taskListDao.findByListName(taskListName);
        String nameOfList = "The name of list";
        int id = listOfTasks.get(0).getId();
        //Then
        Assert.assertEquals(nameOfList, listOfTasks.get(0).getListName());
        Assert.assertEquals(1, listOfTasks.size());
        //CleanUp
        taskListDao.deleteById(id);
    }
}