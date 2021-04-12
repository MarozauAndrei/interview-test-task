package gradle.java;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import java.io.File;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyApiResponseTest {

  private final static String CLASS_PATH = "src\\test\\java\\gradle\\groovy\\";
  private final static String FILE_NAME = CLASS_PATH + "GroovyMethodsForTest.groovy";
  private final static String URL_PATTERN = "https://social-network.samuraijs.com/api/1.0/users?count=%s";

  @DataProvider(name = "Provider of test data for verifying api response")
  private static Object[] provideDataForApiResponse() {
    return new Object[]{2, 5, 100};
  }

  @Test(dataProvider = "Provider of test data for verifying api response")
  public void verifyKeyValues(int number) throws IOException, IllegalAccessException,
      InstantiationException {
    if (number < 1 || number > 100) {
      Assert.fail("Wrong test data: number must be between 1 and 100!");
    }
    String url = String.format(URL_PATTERN, number);
    Class scriptClass = new GroovyClassLoader().parseClass(new File(FILE_NAME));
    GroovyObject scriptInstance = (GroovyObject) scriptClass.newInstance();
    int responseSize = (int) scriptInstance.invokeMethod("getResponseSize", url);
    Assert.assertEquals(responseSize, number, "Response size differs from test number!");
  }
}
