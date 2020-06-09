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
