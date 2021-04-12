package gradle.java.learning_examples;

import com.google.gson.Gson;
import gradle.java.bo.Person;
import gradle.java.services.PersonService;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestsInJava {

  @DataProvider(name = "Provider of test data for verify key values")
  private static Object[][] provideDataForKeyValues() {
    return new Object[][]{
        {"firstName", Arrays.asList("ELVA", "JENNEFER", "LAUREN")},
        {"lastName", Arrays.asList("RECHKEMMER", "WENIG", "RIDENS")}
    };
  }

  @Test(dataProvider = "Provider of test data for verify key values")
  public void verifyKeyValues(String key, List<String> expectedKeyValues) {
    String response = ResourceBundle.getBundle("response").getString("response");
    Person[] allPersons = new Gson().fromJson(response, Person[].class);
//    Arrays.stream(allPersons).forEach(person -> System.out.println(person.toString()));
    PersonService personService = new PersonService();
    List<String> values = Arrays.stream(allPersons)
        .map(person -> personService.getVariableValue(person, key).toString())
        .collect(Collectors.toList());
    Assert.assertEquals(values.toString(), expectedKeyValues.toString(),
        "Key values differ from expected values!");
  }

  @DataProvider(name = "Provider of test data for verify list of persons")
  public static Object[][] provideDataForListOfPersons() {
    return new Object[][]{
        {"gender", "Female", Arrays.asList("ELVA RECHKEMMER", "JENNEFER WENIG")},
        {"gender", "Male", Arrays.asList("LAUREN RIDENS")},
        {"maritalStatus", "Unmarried", Arrays.asList("ELVA RECHKEMMER", "LAUREN RIDENS")},
    };
  }

  @Test(dataProvider = "Provider of test data for verify list of persons")
  public void verifyPersonsWithConditions(String variable, String value, List<String> expectedPersons) {
    String response = ResourceBundle.getBundle("response").getString("response");
    Person[] allPersons = new Gson().fromJson(response, Person[].class);
    PersonService personService = new PersonService();
    List<String> persons = Arrays.stream(allPersons)
        .filter(person -> personService.getVariableValue(person, variable).equals(value))
        .map(person -> String.format("%s %s", person.getFirstName(), person.getLastName()))
        .collect(Collectors.toList());
    Assert.assertEquals(persons.toString(), expectedPersons.toString(),
        "Persons with required conditions differ from expected values!");
  }
}
