$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/BDDTestNG/src/main/java/com/qa/feature/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Free CRM Login Feature",
  "description": "",
  "id": "free-crm-login-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Free CRM Login Test Scenario",
  "description": "",
  "id": "free-crm-login-feature;free-crm-login-test-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "user is already on Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "title of login page is Free CRM",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "logo of login page is CRMlogo",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user enters username and password",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user is on home page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.user_is_already_on_Login_Page()"
});
formatter.result({
  "duration": 301697231,
  "error_message": "java.lang.NullPointerException\r\n\tat com.qa.base.TestBase.initialization(TestBase.java:63)\r\n\tat com.qa.stepDefinition.LoginPageSteps.user_is_already_on_Login_Page(LoginPageSteps.java:50)\r\n\tat ✽.Given user is already on Login Page(D:/BDDTestNG/src/main/java/com/qa/feature/Login.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginPageSteps.title_of_login_page_is_Free_CRM()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginPageSteps.logo_of_login_page_is_CRMlogo()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginPageSteps.user_enters_username_and_password()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginPageSteps.user_is_on_home_page()"
});
formatter.result({
  "status": "skipped"
});
});