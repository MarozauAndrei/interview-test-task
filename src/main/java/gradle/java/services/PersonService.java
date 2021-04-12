package gradle.java.services;

public class PersonService {

  public PersonService () {
  }

  public Object getVariableValue(Object object, String fieldName) {
    Class clazz = object.getClass();
    try {
      java.lang.reflect.Field field = clazz.getDeclaredField(fieldName);
      field.setAccessible(true);
      return field.get(object);
    } catch(Exception ex) {
      return null;
    }
  }
}
