package commons.read;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperty {

    public static String readProperty(String file, String propertyName) {
        // Define String variable to save property value there
        String propertyValue = null;
        // Initialize Properties Object
        Properties properties = new Properties();
        try {// Add try catch in case exception happen while reading file
            // Read The Provided File content as inputStream
            // This will retrieve all string content from file
            InputStream inputStream = new FileInputStream (file);
            // Load inputStream Object to Properties
            // This will convert string content to keys and values
            properties.load(inputStream);
            // Return Property value from readPropFile Method
            // Check if Property Name exist
            if (properties.containsKey(propertyName))
                // If exist then return property value
                propertyValue = properties.getProperty(propertyName);
            else// If not exist then return error and fail the test case
                Assert.fail("Property Name isn't exist, " +
                        "check " + propertyName);
        } catch (Throwable throwable) {// In case exception happen
            Assert.fail("Read Property File failed, " +
                    "please check log: \n" + throwable.getMessage());
        }
        // Return property value string
        return propertyValue;
    }
}
