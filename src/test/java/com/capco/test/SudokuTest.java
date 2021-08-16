package com.capco.test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SudokuTest {

    @org.junit.Test
    public void validSudoku() throws IOException{
        String path = "src/test/resources/validSudoku";
        String[][] fileContents = Sudoku.readContents(path);
        assert(Sudoku.checkSudoku(fileContents));
    }

    @org.junit.Test
    public void inValidSudoku() throws IOException{
        String path = "src/test/resources/invalidSudoku";
        String[][] fileContents = Sudoku.readContents(path);
        assert(!Sudoku.checkSudoku(fileContents));
    }
}