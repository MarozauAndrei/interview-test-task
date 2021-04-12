package gradle.data_providers;

import java.util.Arrays;
import org.testng.annotations.DataProvider;

public class DataProviderSource {

  @DataProvider(name = "Provider of test data for verify list of persons")
  public static Object[][] provideDataForListOfPersons() {
    return new Object[][]{
        {Arrays.asList("Gender", "Female"),
            Arrays.asList(
                "{Address=8417 Blue Spring St. Port Orange, FL 32127, Age=62, DateOfJoining=1993-01-11, Designation=CEO, FirstName=ELVA, Gender=Female, Interests=Body Building,Illusion,Protesting,Taxidermy,TV watching,Cartooning,Skateboarding, LastName=RECHKEMMER, MaritalStatus=Unmarried, Salary=154000}",
                "{Address=16 Manor Station Court Huntsville, AL 35803, Age=45, DateOfJoining=2013-02-07, Designation=President, FirstName=JENNEFER, Gender=Female, Interests=String Figures,Working on cars,Button Collecting,Surf Fishing, LastName=WENIG, MaritalStatus=Married, Salary=110000}")},
        {Arrays.asList("Gender", "Male"),
            Arrays.asList(
                "{Address=287 SE. Schoolhouse Street Clifton, NJ 07011, Age=63, DateOfJoining=2010-01-14, Designation=President, FirstName=LAUREN, Gender=Male, Interests=Saltwater Aquariums, LastName=RIDENS, MaritalStatus=Unmarried, Salary=123000}")},
        {Arrays.asList("MaritalStatus", "Unmarried"),
            Arrays.asList(
                "{Address=8417 Blue Spring St. Port Orange, FL 32127, Age=62, DateOfJoining=1993-01-11, Designation=CEO, FirstName=ELVA, Gender=Female, Interests=Body Building,Illusion,Protesting,Taxidermy,TV watching,Cartooning,Skateboarding, LastName=RECHKEMMER, MaritalStatus=Unmarried, Salary=154000}",
                "{Address=287 SE. Schoolhouse Street Clifton, NJ 07011, Age=63, DateOfJoining=2010-01-14, Designation=President, FirstName=LAUREN, Gender=Male, Interests=Saltwater Aquariums, LastName=RIDENS, MaritalStatus=Unmarried, Salary=123000}")}
    };
  }
}
