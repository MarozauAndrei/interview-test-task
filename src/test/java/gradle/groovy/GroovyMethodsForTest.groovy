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

    def getResponseSize(String url) {
        def content = new URL(url).text
        def substring = content.toString().substring(content.indexOf('['), content.indexOf(']') + 1)
        def json = new JsonSlurper().parseText(substring)
        assert json instanceof List
        assert json.get(0) instanceof Map
        return json.size()
    }
}
