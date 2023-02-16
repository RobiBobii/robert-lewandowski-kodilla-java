package com.kodilla.kodillahibernate.tasklist.dao;

import com.kodilla.kodillahibernate.task.Task;
import com.kodilla.kodillahibernate.task.TaskFinancialDetails;
import com.kodilla.kodillahibernate.task.dao.TaskDao;
import com.kodilla.kodillahibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    @Autowired
    private TaskDao taskDao;

    private static final String LISTNAME = "To Do";
    private static final String DESCRIPTION_1 = "1st List with tasks to do";
    private static final String DESCRIPTION_2 = "2nd List with tasks to do";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList1 = new TaskList(LISTNAME, DESCRIPTION_1);
        TaskList taskList2 = new TaskList(LISTNAME, DESCRIPTION_2);

        //When
        taskListDao.save(taskList1);
        taskListDao.save(taskList2);

        //Then
        List<TaskList> readTaskList = taskListDao.findByListName(LISTNAME);

        Assertions.assertEquals(2, readTaskList.size());
        Assertions.assertEquals(LISTNAME, readTaskList.get(0).getListName());
        Assertions.assertEquals(LISTNAME, readTaskList.get(1).getListName());

        //CleanUp
        taskListDao.delete(taskList1);
        taskListDao.delete(taskList2);
    }
    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        //taskListDao.deleteById(id);
    }
}