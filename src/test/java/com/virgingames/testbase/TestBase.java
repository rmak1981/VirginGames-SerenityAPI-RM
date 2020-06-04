package com.virgingames.testbase;

import com.virgingames.constants.Path;
import com.virgingames.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

/*
 * Ravi's Creation
 * Date of Creation 01/06/20
 */
public class TestBase {


    public static PropertyReader propertyReader;

    @BeforeClass
    public static void inIt() {

        propertyReader = PropertyReader.getInstance();

        RestAssured.baseURI = propertyReader.getProperty("baseURL");
        RestAssured.basePath = Path.PATH;

    }

}
