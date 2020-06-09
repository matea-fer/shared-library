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
        stage("Deploy") {
            if (config.deploy) {
                println('Config deploy is true')
            }
            else{
              println('Config deploy is false')
            }
        }
        body()
}
