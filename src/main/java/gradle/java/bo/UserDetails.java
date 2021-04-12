package gradle.java.bo;

public class UserDetails {

  private String name;
  private String email;
  private int age;
  private long phone;
  private String city;
  private boolean hasCreditCard;

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public int getAge() {
    return age;
  }

  public long getPhone() {
    return phone;
  }

  public String getCity() {
    return city;
  }

  public boolean isHasCreditCard() {
    return hasCreditCard;
  }

  @Override
  public String toString() {
    return "UserDetails{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", age=" + age +
        ", phone=" + phone +
        ", city='" + city + '\'' +
        ", hasCreditCard=" + hasCreditCard +
        '}';
  }
}
