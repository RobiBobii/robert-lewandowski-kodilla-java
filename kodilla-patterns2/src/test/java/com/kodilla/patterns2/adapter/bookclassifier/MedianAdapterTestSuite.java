package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> bookSet = new HashSet<>();
        Book petSematary = new Book("Stephen King", "Pet Sematary", 1983, "978-0-385-18244-7");
        Book twoTowers = new Book("J R R Tolkien", "Two Towers", 1954, "0-618-00223-5");
        Book hp = new Book("J K Rowling", "Philosophers stone", 2004, "1551927284");
        bookSet.add(petSematary);
        bookSet.add(twoTowers);
        bookSet.add(hp);
        MedianAdapter medianAdapter = new MedianAdapter();
        // When
        int medianYear = medianAdapter.publicationYearMedian(bookSet);
        // Then
        System.out.println(medianYear);
        assertEquals(medianYear, 1983);
    }
}