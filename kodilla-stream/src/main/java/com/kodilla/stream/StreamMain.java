package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args){

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println("Beautifing texts:");
        poemBeautifier.beutify("TEXT to be LOWERCASED",(a) -> a.toLowerCase());
        poemBeautifier.beutify("First part of the text",(a) -> a+" - and the other part of the text");
        poemBeautifier.beutify("Cutting the sentence to a part",(a) -> (a.substring(8,20).toUpperCase()));
        poemBeautifier.beutify("Some text",(a) -> a.replace("Some","Replaced"));


    }
}