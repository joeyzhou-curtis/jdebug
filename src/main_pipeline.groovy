#!/bin/groovy

JOB_ID = "HOURLY"
integration_tests="k8s-operator"
ALL_USER_NAME="Baka.Nocerino"

timestamps {
  wrap([$class: 'AnsiColorBuildWrapper']) {
    try {
      UTIL = load("src/jenkins_scripts/util.groovy")
      STAGE = load("src/jenkins_scripts/stage.groovy")
    } catch (java.lang.Throwable error) {
      println "exception caught:"
      println error.getMessage()
      throw error
    }

    try {
      UTIL.pre_pipeline()
      UTIL.create_tmp_config()
      STAGE.update_user_name()
    } catch(err) {
      println "exception caught:"
      throw err
    }
  }
}
