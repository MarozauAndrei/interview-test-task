package gradle.java.learning_examples;

import com.google.gson.Gson;
import gradle.java.bo.UserDetails;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParseJsonToJavaClass {

//  private final static String URL = "https://social-network.samuraijs.com/api/1.0/users?term=serg"; // Example
  private final static String JSON = "{ 'name':'John', 'email':'john.doe@gmail.com', 'age':29, 'phone':5168161922, 'city':'NewYork', 'hasCreditCard':false }";
  private final static String BODY =
      "[{ 'name':'John', 'email':'john.doe@gmail.com', 'age':29, 'phone':5168161922, 'city':'NewYork', 'hasCreditCard':false },"
     + "{ 'name':'Bill', 'email':'bill.jim@gmail.com', 'age':33, 'phone':6192251681, 'city':'LosAngeles', 'hasCreditCard':true }]";

  @Test(priority = 1)
  public void parseJsonStringYToJavaClass() {
    Gson gson = new Gson();
    UserDetails user = gson.fromJson(JSON, UserDetails.class);
    System.out.println();
    System.out.println("First test result:");
    System.out.println("user name = " + user.getName());
    System.out.println("user = " + user.toString());
    System.out.println();
  }

  @Test(priority = 2)
  public void parseJsonStringYToArrayOfJavaClasses() {
//    UserDetails[] allItems = RestAssured.get(URL).as(UserDetails[].class);
    UserDetails[] users = new Gson().fromJson(BODY, UserDetails[].class);
    System.out.println();
    System.out.println("Second test result:");
    Arrays.stream(users).forEach(item -> System.out.println(item.getEmail()));
    Arrays.stream(users).forEach(item -> System.out.println(item.toString()));
    Assert.assertTrue(users.length > 0);
  }
}
