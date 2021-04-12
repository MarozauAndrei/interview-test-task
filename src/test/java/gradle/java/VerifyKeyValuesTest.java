package gradle.java;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyKeyValuesTest {

  private final static String CLASS_PATH = "src\\test\\java\\gradle\\groovy\\";
  private final static String FILE_NAME = CLASS_PATH + "GroovyMethodsForTest.groovy";

  @DataProvider(name = "Provider of test data for verifying key values")
  private static Object[][] provideDataForKeyValues() {
    return new Object[][]{
        {"FirstName", Arrays.asList("ELVA", "JENNEFER", "LAUREN")},
        {"LastName", Arrays.asList("RECHKEMMER", "WENIG", "RIDENS")}
    };
  }

  @Test(dataProvider = "Provider of test data for verifying key values")
  public void verifyKeyValues(String key, List<String> expectedKeyValues) throws IOException,
      IllegalAccessException, InstantiationException {
    Class scriptClass = new GroovyClassLoader().parseClass(new File(FILE_NAME));
    GroovyObject scriptInstance = (GroovyObject) scriptClass.newInstance();
    List<String> values = (List<String>) scriptInstance.invokeMethod("getValuesByKey", key);
    Assert.assertEquals(values.toString(), expectedKeyValues.toString(),
        "Key values differ from expected values!");
  }
}
