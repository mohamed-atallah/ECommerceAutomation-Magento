package com.magento.DataProvider;

import com.magento.Utils.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginDataProvider {


    @DataProvider(name = "validLoginData")
    public Object[][] getValidLoginData() {
        return new Object[][]{
                {"testuser", "testpassword"}
        };
    }

    @DataProvider(name = "getLoginDataWithoutEmail")
    public Object[][] getLoginDataWithoutEmail() {
        return new Object[][]{
                {"", "testpassword1"},
                {"", "testpassword2"},
                {"", "0"}
        };
    }
    String loginDataFilePath="TestData/TestData.xlsx";
    @DataProvider(name = "invalidLoginData")
    public Object[][] getIvalidLoginData() {
        ExcelUtils excelUtils = new ExcelUtils();
        List<String[]> data = excelUtils.getDataFromExcel(loginDataFilePath, "UsersData");
        // Debugging: Print number of rows read
        System.out.println("Number of rows fetched from Excel: " + data.size());
        System.out.println(data);
        List<String[]> validData = new ArrayList<>();

        // Skip the first row by starting from index 1
        for (int i = 1; i < data.size(); i++) {  // Start from 1 instead of 0 to skip the header
            String[] row = data.get(i);

            // Debugging: Print row data
            System.out.println("Row data: " + Arrays.toString(row));

            // Ensure the row has at least 2 columns
            if (row.length >= 2) {
                validData.add(row);  // Add only valid rows with 2 columns
            } else {
                System.out.println("Skipping row with insufficient data: " + Arrays.toString(row));
            }
        }

        // Convert validData to Object[][]
        Object[][] dataArray = new Object[validData.size()][2];
        for (int i = 0; i < validData.size(); i++) {
            dataArray[i][0] = validData.get(i)[0];  // Email
            dataArray[i][1] = validData.get(i)[1];  // Password
        }

        return dataArray;  // Return only valid data, skipping the header
    }

}
