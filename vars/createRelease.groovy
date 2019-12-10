import ru.sbrf.kalita.devops.jira.JiraClient

def call(String path) {
    JiraClient.request(path: path)
}