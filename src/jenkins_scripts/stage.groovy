
def update_user_name() {
    if (JOB_ID =~ "HOURLY" && integration_tests =~ "operator") {
        def operator_owner = UTIL.run_cmd_get_stdout("jq -r '.special_test_check.owner | @tsv' ${test_config_file} | tr '\t' ',' | tr -d '\n'")
        println "operator_owner: $operator_owner"
        if (operator_owner != "") {
          ALL_USER_NAME = ALL_USER_NAME + ",${operator_owner}"
        }
    }
    println "ALL_USER_NAME: $ALL_USER_NAME"
}

return this
