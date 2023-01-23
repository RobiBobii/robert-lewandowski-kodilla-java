package com.kodilla.sudoku;

import java.util.List;

public class SudokuPrinter {

    public void print(SudokuBoard sudokuBoard){
        System.out.println("Sudoku");
        List<SudokuRow> sudokuBoards = sudokuBoard.getSudokuRowList();
        for (SudokuRow sudokuRow : sudokuBoards) {
            for (int j = 0; j < sudokuRow.getSudokuRowElements().size(); j++) {
                System.out.print(sudokuRow.getSudokuRowElements().get(j) + "\t");
            }
            System.out.println();
        }
    }
}