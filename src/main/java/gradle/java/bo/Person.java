package gradle.java.bo;

import com.google.gson.annotations.SerializedName;

public class Person {

  @SerializedName("FirstName")
  private String firstName;

  @SerializedName("LastName")
  private String lastName;

  @SerializedName("Designation")
  private String designation;

  @SerializedName("Salary")
  private int salary;

  @SerializedName("DateOfJoining")
  private String dateOfJoining;

  @SerializedName("Address")
  private String address;

  @SerializedName("Gender")
  private String gender;

  @SerializedName("Age")
  private int age;

  @SerializedName("MaritalStatus")
  private String maritalStatus;

  @SerializedName("Interests")
  private String interests;

  public Person() {}

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getDesignation() {
    return designation;
  }

  public int getSalary() {
    return salary;
  }

  public String getDateOfJoining() {
    return dateOfJoining;
  }

  public String getAddress() {
    return address;
  }

  public String getGender() {
    return gender;
  }

  public int getAge() {
    return age;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public String getInterests() {
    return interests;
  }

  @Override
  public String toString() {
    return
        "firstName=" + firstName +
        ", lastName=" + lastName +
        ", designation=" + designation +
        ", salary=" + salary +
        ", dateOfJoining=" + dateOfJoining +
        ", address=" + address +
        ", gender=" + gender +
        ", age=" + age +
        ", maritalStatus=" + maritalStatus +
        ", interests=" + interests
        ;
  }
}
