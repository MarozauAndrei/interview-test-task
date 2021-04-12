package gradle.java.learning_examples;

import com.google.gson.Gson;
import gradle.data_providers.DataProviderSource;
import gradle.java.bo.Person;
import gradle.java.services.PersonService;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingGroovyMethodsFromJavaExamples {

  private final static String CLASS_PATH = "src\\test\\java\\gradle\\groovy\\";
  private final static String FILE_NAME = CLASS_PATH + "GroovyMethodsExamples.groovy";

  @Test
  public void usingJsonScript() {
    String script = "a = 1.0 \n" +
        "def mul2(x) { 2.0 * x }\n";

    Binding binding = new Binding();

    GroovyShell gs = new GroovyShell(binding);
    Script sc = gs.parse(script);
    sc.run();

    System.out.println();
    System.out.printf("binding.getVariable(\"a\") == %s\n", binding.getVariable("a"));
    System.out.printf("mul2(a) = %s%n", sc.invokeMethod("mul2", gs.evaluate("a")));
    System.out.printf("mul2(a) = %s%n", sc.invokeMethod("mul2", binding.getVariable("a")));
    System.out.println();
  }

//  @Test    //  NOT WORK !!!!!!
//  public void simpleTestForInvokeMethod() throws IOException {
//    new GroovyShell().parse(new File( FILE_NAME ) ).invokeMethod( "hello_world", null) ;
//  }

  @Test
  public void runningTestsFromGroovyFileWithoutParameters() throws IOException,
      IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    Class scriptClass = new GroovyClassLoader().parseClass( new File( FILE_NAME ) ) ;
    Object scriptInstance = scriptClass.newInstance() ;
    System.out.println();
    scriptClass.getDeclaredMethod( "hello_world", new Class[] {} ).invoke( scriptInstance ) ;
    System.out.println();
    int something = (int)scriptClass.getDeclaredMethod( "getNumber", new Class[] {} ).invoke( scriptInstance, new Object[] {} ) ;
    something++;
    System.out.println("number + 1 = " + something);
  }

  @Test
  public void parseJsonToSingleMapInGroovy()
      throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
    Class scriptClass = new GroovyClassLoader().parseClass( new File( FILE_NAME ) ) ;
    Object scriptInstance = scriptClass.newInstance() ;
    System.out.println();
    scriptClass.getDeclaredMethod( "parseStringToSingleMap", new Class[] {} ).invoke( scriptInstance ) ;
  }

  @Test
  public void parseJsonToClassInGroovy()
      throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
    Class scriptClass = new GroovyClassLoader().parseClass( new File( FILE_NAME) ) ;
    Object scriptInstance = scriptClass.newInstance() ;
    System.out.println();
    scriptClass.getDeclaredMethod( "parsePersonClass", new Class[] {} ).invoke( scriptInstance ) ;
    System.out.println();
    Person javaPerson = (Person) scriptClass.getDeclaredMethod( "getPerson", new Class[] {} ).invoke( scriptInstance, new Object[] {} ) ;
    System.out.println("Person from Java = " + javaPerson.getFirstName() + " " + javaPerson.getLastName());
  }

  @Test
  public void parseJsonToMapInGroovy()
      throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
    Class scriptClass = new GroovyClassLoader().parseClass( new File( FILE_NAME ) ) ;
    Object scriptInstance = scriptClass.newInstance() ;
    System.out.println();
    scriptClass.getDeclaredMethod( "parseStringToMap", new Class[] {} ).invoke( scriptInstance ) ;
  }

  @Test
  public void parseJsonToListOfMapsInGroovy()
      throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
    Class scriptClass = new GroovyClassLoader().parseClass( new File( FILE_NAME) ) ;
    Object scriptInstance = scriptClass.newInstance() ;
    System.out.println();
    scriptClass.getDeclaredMethod( "parseStringToListOfMaps", new Class[] {} ).invoke( scriptInstance ) ;
  }

  @Test
  public void getValuesFromMap()
      throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
    Class scriptClass = new GroovyClassLoader().parseClass( new File( FILE_NAME) ) ;
    Object scriptInstance = scriptClass.newInstance() ;
    System.out.println();
    scriptClass.getDeclaredMethod( "getValuesByKey", new Class[] {} ).invoke( scriptInstance ) ;
  }

  @Test
  public void runningTestsFromGroovyFileWithParameters() // !!!!!
      throws IOException, IllegalAccessException, InstantiationException {
        Class scriptClass = new GroovyClassLoader().parseClass(new File(FILE_NAME));
        GroovyObject scriptInstance = (GroovyObject) scriptClass
            .newInstance(); // вместо Object надо создать GroovyObject, у которого есть метод invoke()
        System.out.println();
        scriptInstance.invokeMethod("getValuesByParameterKey", "FirstName");
      }
}
