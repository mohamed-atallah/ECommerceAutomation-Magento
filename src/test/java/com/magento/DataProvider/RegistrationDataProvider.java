package com.magento.DataProvider;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {
    // DataProvider for registration test
    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        return new Object[][]{
                {"John Doe", "johndoe@example.com", "john123", "john123"},
                {"Jane Smith", "janesmith@example.com", "janesmith123", "janesmith123"}
        };
    }
}
