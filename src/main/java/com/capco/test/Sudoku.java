package com.capco.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Sudoku {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("File path can not be empty");
            System.exit(0);
        }
        String filePath = args[0];
        String[][] inputBoard = readContents(filePath);
        if (checkSudoku(inputBoard)) System.out.println(0 + "(VALID)");
        else System.out.println(1 + "(INVALID)");
    }

    static Boolean checkSudoku(String[][] inputBoard) {
        int length = inputBoard.length;
        for (int i = 0; i < length; i++) {
            HashSet<String> rows = new HashSet<String>();
            HashSet<String> columns = new HashSet<String>();
            HashSet<String> cube = new HashSet<String>();
            int row = 3 * (i / 3);
            int column = 3 * (i % 3);
            for (int j = 0; j < length; j++) {
                if (!inputBoard[i][j].equals("") && !rows.add(inputBoard[i][j]))
                    return false;
                if (!inputBoard[j][i].equals("") && !columns.add(inputBoard[j][i]))
                    return false;
                if (!inputBoard[row + j / 3][column + j % 3].equals("") && !cube.add(inputBoard[row + j / 3][column + j % 3]))
                    return false;
            }
        }
        return true;
    }

    static String[][] readContents(String fileName) throws IOException {
        String[][] result = new String[9][9];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(",", -1);
                result[count++] = splitLine;
                //count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return result;
    }


}
