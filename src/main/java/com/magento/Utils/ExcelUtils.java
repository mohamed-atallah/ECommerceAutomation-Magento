package com.magento.Utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

    public List<String[]> getDataFromExcel(String filePath, String sheetName) {
        List<String[]> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                int cellCount = row.getPhysicalNumberOfCells();
                String[] data = new String[cellCount];

                for (int i = 0; i < cellCount; i++) {
                    Cell cell = row.getCell(i);
                    data[i] = cell.toString();  // Convert the cell value to a string
                }

                dataList.add(data);  // Add the row data to the list
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;  // Return the list of row data
    }
}

