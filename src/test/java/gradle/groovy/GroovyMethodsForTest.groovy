package gradle.groovy

import groovy.json.JsonSlurper

class GroovyMethodsForTest {

    def getValuesByKey(String key) {
        String response = ResourceBundle.getBundle("response").getString("response");
        def list = new JsonSlurper().parseText(response)
        assert list instanceof List
        assert list.get(0) instanceof Map
        return list.collect({ entry -> entry.get(key) })
    }

    def getObjectsWithKeyValue(List<String> params) {
        String response = ResourceBundle.getBundle("response").getString("response");
        def list = new JsonSlurper().parseText(response)
        assert list instanceof List
        assert list.get(0) instanceof Map
        return list.findAll { it[params.get(0)] == params.get(1) }
    }
}
