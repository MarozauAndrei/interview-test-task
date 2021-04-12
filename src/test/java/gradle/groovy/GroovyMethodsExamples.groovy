package gradle.groovy

import com.google.gson.Gson
import gradle.java.bo.Person
import groovy.json.JsonSlurper

class GroovyMethodsExamples {

    def hello_world() {
        println "Hello, world!"
    }

    def getNumber() {
        return 55;
    }

    def parseStringToSingleMap() {
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText('{ "name": "John Doe" } /* some comment */');
        assert object instanceof Map
        assert object.name == 'John Doe'
        println "object.name = " + object.name
    }

    def parsePersonClass () {
        String response = ResourceBundle.getBundle("response").getString("response");
        Person[] allPersons = new Gson().fromJson(response, Person[].class as Class<Object>) as Person[];
        println(allPersons[1].gender)
        for (person in allPersons) {   // == For each in Java
            println person
        }
    }

    def getPerson () {
        String response = ResourceBundle.getBundle("response").getString("response");
        Person[] allPersons = new Gson().fromJson(response, Person[].class as Class<Object>) as Person[];
        return allPersons[0]
    }

    def parseStringToMap() {
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText('{ "name": "John Doe" , "id":"123", "value":15.6 }');
        assert object instanceof Map
        assert object.name == 'John Doe'
        println "object.name = " + object.name
        println(object.toString())
    }

    def parseStringToListOfMaps() {

        // Example Response Data
        def restResponse = '[{"uid":10512213, "name":"Bob"},{"uid":7208201, "name":"John"},{"uid":10570, "name":"Jim"},{"uid":1799657, "name":"Sally"}]'

        // Parse the response
        def list = new JsonSlurper().parseText( restResponse )

        // Print them out to make sure
        list.each { println it }
    }

    def getValuesByKey() {
        def people = [
                [name: 'Bob', age: 32, gender: 'M'],
                [name: 'Johnny', age: 36, gender: 'M'],
                [name: 'Claire', age: 21, gender: 'F'],
                [name: 'Amy', age: 54, gender: 'F']
        ]
        def females = people.findAll {it.gender == 'F' }
        println "List of female:"
        females.each { println it }
        println()
        println "List of names:"
        def values = people.collect({ entry -> entry.get('name') })
        println(values.toString())
    }

    def getValuesByParameterKey(String parameter) {
        def people = [
                [name: 'Bob', age: 32, gender: 'M'],
                [name: 'Johnny', age: 36, gender: 'M'],
                [name: 'Claire', age: 21, gender: 'F'],
                [name: 'Amy', age: 54, gender: 'F']
        ]
        println "List of parameter value:"
        def values = people.collect({ entry -> entry.get('name') })
        println(values.toString())
    }
}
