package com.kodilla.testing.forum.statistics;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsTestSuite {
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;


    @Before
    public void beforeTest(){
        statisticsMock = mock(Statistics.class);
        List<String>listMock = new ArrayList<>();
        for(int i=0; i<10; i++){
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(40);
        forumStatistics = new ForumStatistics();
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroPosts(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(0, forumStatistics.getPostsQty());
        Assertions.assertEquals(0, forumStatistics.getPostsAvgPerUser(), 0.01);
        Assertions.assertEquals(0, forumStatistics.getCommentsAvgPerPost(), 0.01);

    }

    @Test
    public void testCalculateAdvStatisticsWithThousandPosts(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(1000, forumStatistics.getPostsQty());
        Assertions.assertEquals(100, forumStatistics.getPostsAvgPerUser(), 0.01);
        Assertions.assertEquals(0.04, forumStatistics.getCommentsAvgPerPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroComments(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(0, forumStatistics.getCommentsQty());
        Assertions.assertEquals(0, forumStatistics.getCommentsAvgPerUser(), 0.01);
        Assertions.assertEquals(0, forumStatistics.getCommentsAvgPerPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(2);
        when(statisticsMock.postsCount()).thenReturn(10);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(10, forumStatistics.getPostsQty());
        Assertions.assertEquals(2, forumStatistics.getCommentsQty());
        Assertions.assertEquals(1, forumStatistics.getPostsAvgPerUser(), 0.01);
        Assertions.assertEquals(0.2, forumStatistics.getCommentsAvgPerUser(), 0.01);
        Assertions.assertEquals(0.2, forumStatistics.getCommentsAvgPerPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts(){
        //Given

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(20, forumStatistics.getPostsQty());
        Assertions.assertEquals(40, forumStatistics.getCommentsQty());
        Assertions.assertEquals(2, forumStatistics.getPostsAvgPerUser(), 0.01);
        Assertions.assertEquals(4, forumStatistics.getCommentsAvgPerUser(), 0.01);
        Assertions.assertEquals(2, forumStatistics.getCommentsAvgPerPost(), 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroUsers(){
        //Given
        List<String>listMock = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(0, forumStatistics.getUsersQty());
        Assertions.assertEquals(0, forumStatistics.getPostsAvgPerUser(), 0.01);
        Assertions.assertEquals(0, forumStatistics.getCommentsAvgPerUser(), 0.01);

    }

    @Test
    public void testCalculateAdvStatisticsWithHundredUsers(){
        //Given
        List<String> listMock = new ArrayList<>();
        for(int i=0; i<100; i++){
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(100, forumStatistics.getUsersQty());
        Assertions.assertEquals(0.2, forumStatistics.getPostsAvgPerUser(), 0.01);
        Assertions.assertEquals(0.4, forumStatistics.getCommentsAvgPerUser(), 0.01);
    }
}