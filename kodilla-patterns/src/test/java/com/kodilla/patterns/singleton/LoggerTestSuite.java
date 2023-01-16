package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class LoggerTestSuite {

    @BeforeClass
    public static void createLogin(){
        Logger.getInstance().log("10.10.2019");
    }

    @Test
    public  void getLastLogin(){
        //Given
        //When
        String login =  Logger.getInstance().getLastLog();
        System.out.println("Last login: "+login);
        //Then
        Assert.assertEquals("10.10.2019",login);
    }
}