package ru.sbrf.kalita.devops.jira

import javafx.scene.chart.ScatterChart

class JiraClient {

    def final script
    final Map config

    JiraClient(script, config) {
        this.script = script
        this.config = config
    }

    def request(httpMethod = 'GET', path = '', request = null, debugOutput = false) {
        try {
            httpRequest(
                    httpMode: httpMethod,
                    url: "${config.jiraUrl}${path}",
                    consoleLogResponseBody: debugOutput,
                    contentType: 'APPLICATION_JSON',
                    ignoreSslErrors: true,
                    authentication: config.jiraCreds,
                    requestBody: request,
                    validResponseCodes: '200:204'
            )
        } catch(ex) {
            println "request to jira failed"
            throw ex

        }
    }
}
