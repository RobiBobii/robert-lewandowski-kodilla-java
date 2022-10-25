package com.kodilla.stream;

import java.time.LocalDate;
import java.util.Map;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import java.util.List;
import java.util.stream.Collectors;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.person.People;

public class StreamMain {
    public static void main(String[] args){

        /*
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println("Beautifing texts:");
        poemBeautifier.beutify("TEXT to be LOWERCASED",(a) -> a.toLowerCase());
        poemBeautifier.beutify("First part of the text",(a) -> a+" - and the other part of the text");
        poemBeautifier.beutify("Cutting the sentence to a part",(a) -> (a.substring(8,20).toUpperCase()));
        poemBeautifier.beutify("Some text",(a) -> a.replace("Some","Replaced"));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20)


        People.getList().stream()
                .map(String::toUpperCase)                             // [1]
                .filter(s -> s.length() > 11)                         // [2]
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")   // [3]
                .filter(s -> s.substring(0, 1).equals("M"))           // [4]
                .forEach(System.out::println);                        // [5]

        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));                    // [2]

        System.out.println(theResultStringOfBooks);

         */

        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultForumUsers = forum.getUserList().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> (LocalDate.now().getYear() - user.getBirthDate().getYear()) > 20)
//                .filter(user -> (Period.between(user.getBirthDate(),LocalDate.now()).getYears()) > 20)
                .filter(user -> user.getPostsCount() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));
        System.out.println("# elements: "+ theResultForumUsers.size());

        theResultForumUsers.entrySet().stream()
                .map(entry -> "Id #"+ entry.getKey() + ": "+ entry.getValue())
                .forEach(System.out::println);

    }
}