import groovy.time.*
import groovy.json.*
import net.sf.json.*
jenkins_script_dir = "src/jenkins_script"
config_dir = "${jenkins_script_dir}/config"

def pre_pipeline() {
  echo "Start pre_pipeline()"  
  TEST_CONFIG = readJSON file: "${config_dir}/test_config.json"
}

def create_tmp_config() {
  test_config_file = "${config_dir}/temp_test_config.json"
  writeJSON file: test_config_file, json: TEST_CONFIG, pretty: 4
}

def run_cmd_get_stdout(String cmd, Boolean run_bash_mod = false, Boolean showCmd = true) {
  if (run_bash_mod) {
    if (showCmd) {
      echo cmd
    }
    cmd = "#!/bin/bash \n ${cmd}"
  }
  def result = sh(script: cmd, returnStdout: true)
  while (result.endsWith('\n')) {
    result = result.substring(0, result.length() - 1)
  }
  return result
}

return this
