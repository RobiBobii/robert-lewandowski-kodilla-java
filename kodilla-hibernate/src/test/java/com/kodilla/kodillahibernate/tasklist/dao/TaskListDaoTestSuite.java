package com.kodilla.kodillahibernate.tasklist.dao;

import com.kodilla.kodillahibernate.task.dao.TaskDao;
import com.kodilla.kodillahibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

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
}