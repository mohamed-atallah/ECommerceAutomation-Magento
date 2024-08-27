package com.magento.TestCases;

import com.magento.Utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterTest extends BaseTest {
    String registrationDataPath="TestData/TestData.xlsx";
    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        ExcelUtils excelUtils = new ExcelUtils();
        List<String[]> data = excelUtils.getDataFromExcel(registrationDataPath, "RegistrationData");

        List<String[]> validData = new ArrayList<>();

        // Skip the first row (header)
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);

            // Ensure the row has at least 5 columns (First Name, Last Name, Email, Password, Confirm Password)
            if (row.length >= 5) {
                validData.add(row);  // Add valid rows to the list
            } else {
                System.out.println("Skipping row with insufficient data: " + Arrays.toString(row));
            }
        }

        // Convert validData to Object[][]
        Object[][] dataArray = new Object[validData.size()][5];
        for (int i = 0; i < validData.size(); i++) {
            dataArray[i] = validData.get(i);
        }

        return dataArray;  // Return only valid data
    }

    // Positive Test Case: Successful registration with valid data
    @Test(priority = 50, dataProvider = "registrationData")
    public void testSuccessfulRegistration(String firstName, String lastName, String email, String password, String confirmPassword) {
        registerPage = header.getRegisterPage();
        // Use dynamic data from the Excel sheet for registration
        registerPage.register(firstName, lastName, email, password, confirmPassword);
        // Assuming you have a method to validate success message
        String successMessage = registerPage.getSuccessMessage();
        // Validate the success message
        Assert.assertEquals(successMessage, "Thank you for registering with Main Website Store.");
    }

    // Negative Test Case: Registration with all fields empty
    @Test
    public void testAllFieldsEmpty() {
        registerPage = header.getRegisterPage();
        registerPage.register("", "", "", "", "");
        String firstNameError = registerPage.getFirstNameError();
        String lastNameError = registerPage.getLastNameError();
        String emailError = registerPage.getEmailError();
        String passwordError = registerPage.getPasswordError();
        String confirmPasswordError = registerPage.getConfirmPasswordError();
        Assert.assertEquals(firstNameError, "This is a required field.");
        Assert.assertEquals(lastNameError, "This is a required field.");
        Assert.assertEquals(emailError, "This is a required field.");
        Assert.assertEquals(passwordError, "This is a required field.");
        Assert.assertEquals(confirmPasswordError, "This is a required field.");
    }

    // Negative Test Case: Registration with mismatched password and confirm password
    @Test
    public void testMismatchedPasswords() {
        registerPage = header.getRegisterPage();
        registerPage.register("Mohamed", "Ahmed", "Mohamed.Ahmed@example.com", "SecurePassword123", "WrongPassword");
        String confirmPasswordError = registerPage.getConfirmPasswordError();
        Assert.assertEquals(confirmPasswordError, "Please enter the same value again.");
    }

    // Negative Test Case: Registration with a weak password
    @Test
    public void testWeakPassword() {
        registerPage = header.getRegisterPage();
        registerPage.register("John", "Doe", "john.doe@example.com", "123", "123");
        String passwordError = registerPage.getPasswordError();
        Assert.assertEquals(passwordError, "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.");
    }

    // Negative Test Case: Registration with an invalid email
    @Test
    public void testInvalidEmail() {
        registerPage = header.getRegisterPage();
        registerPage.register("John", "Doe", "invalidemail", "SecurePassword123", "SecurePassword123");
        String emailError = registerPage.getEmailError();
        Assert.assertEquals(emailError, "Please enter a valid email address (Ex: johndoe@domain.com).");
    }
     // Negative Test Case: Registration with a duplicate email
    @Test
    public void testWithExistingAccount() {
        String existingEmail = "existing.email@example.com";
        // Register with an existing email
        registerPage.register("John", "Doe", existingEmail, "SecurePassword123", "SecurePassword123");
        // Fetch the error message displayed
        String emailError = registerPage.getErrorMessage();
        // Assert that the correct error message is displayed
        Assert.assertEquals(emailError, "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
    }

}
