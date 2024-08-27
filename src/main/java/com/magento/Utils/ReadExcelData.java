package com.magento.Utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.List;

public class ReadExcelData {
    //Excel file -- > Workbook --> Sheets --> Rows --> Cells

    // This method reads data from an Excel file and prints it out
    public static void main(String[] args) throws Exception {

        FileInputStream file = new FileInputStream("TestData/TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        // Assuming we have only one sheet in the Excel file
        //XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFSheet sheet = workbook.getSheet("UsersData");

        int allrows = sheet.getLastRowNum();
        int cells = sheet.getRow(1).getLastCellNum();
        System.out.println("number of rows: " + allrows);
        System.out.println("number of cells: " + cells);

        for (int r = 0; r <= allrows; r++) {
            XSSFRow row = sheet.getRow(r);

            for (int c = 0; c < cells; c++) {
                XSSFCell cell = row.getCell(c);
                //System.out.print(cell.toString()+"\t");
            }
            System.out.println();
        }
        workbook.close();


        String[][] dssssss = new String[3][2];
        dssssss[0][0]="element at 0 0";
        dssssss[0][1]="element at 0 1";

        dssssss[1][0]="element at 1 0";
        dssssss[1][1]="element at 1 1";

        dssssss[2][0]="element at 2 0";
        dssssss[2][1]="element at 2 1";

        for(int i=0; i<3;i++){
            for(int j =0; j<2;j++){

                System.out.println(dssssss[i][j]);
            }
            System.out.println();
        }

    }


}


