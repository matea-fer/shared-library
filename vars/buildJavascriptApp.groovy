// tells Jenkins what method to run when the var is called
// from a Jenkinsfile
// all variables must have a call method 

// poziv metode s parametrom deploy: true -> buildJavascriptApp deploy: true

// calling the variable from a Jenkinsfile and passing a closure:
/* buildJavascriptApp {
  stage(“extra step”) {
    …
  }
} */

def call(Map config=[:], Closure body) {
    node {
        git url: "https://github.com/werne2j/sample-nodejs"
        stage("Install") {
            sh "npm install"
        }
        stage("Test") {
            sh "npm test"
        }
        stage("Deploy") {
            if (config.deploy) {
                sh "npm publish"
            }
        }
        body()
    }
}