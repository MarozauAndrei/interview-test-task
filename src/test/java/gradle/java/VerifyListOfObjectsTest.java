package gradle.java;

import gradle.data_providers.DataProviderSource;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyListOfObjectsTest {

  private final static String CLASS_PATH = "src\\test\\java\\gradle\\groovy\\";
  private final static String FILE_NAME = CLASS_PATH + "GroovyMethodsForTest.groovy";

  @Test(dataProvider = "Provider of test data for verify list of persons",
      dataProviderClass = DataProviderSource.class)
  public void verifyPersonsWithConditions(List<String> params, List<String> expectedPersons)
      throws IOException, IllegalAccessException, InstantiationException {
    Class scriptClass = new GroovyClassLoader().parseClass(new File(FILE_NAME));
    GroovyObject scriptInstance = (GroovyObject) scriptClass.newInstance();
    List<String> persons = (List<String>) scriptInstance
        .invokeMethod("getObjectsWithKeyValue", params);
    Assert.assertEquals(persons.toString(), expectedPersons.toString(),
        "Persons with required conditions differ from expected values!");
  }
}
