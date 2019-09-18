$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/UserRegistration.feature");
formatter.feature({
  "name": "User Registration",
  "description": "      I want to check that the user can register in Cervello",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "User Registration",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "The user in the home page",
  "keyword": "Given "
});
formatter.step({
  "name": "He clicks on Register link",
  "keyword": "When "
});
formatter.step({
  "name": "He entered \"\u003cfirstName\u003e\" , \"\u003claseName\u003e\" , \"\u003cemail\u003e\" , \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "The registration page displayed successfully",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "firstName",
        "laseName",
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "ahmed",
        "mohamed",
        "ahmed@user21434.com",
        "12345678"
      ]
    },
    {
      "cells": [
        "Moataz",
        "ahmed",
        "test@newuser12233.com",
        "87654321"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User Registration",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "The user in the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "UserRegistration.the_user_in_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "He clicks on Register link",
  "keyword": "When "
});
formatter.match({
  "location": "UserRegistration.the_user_clicks_on_Register_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "He entered \"ahmed\" , \"mohamed\" , \"ahmed@user21434.com\" , \"12345678\"",
  "keyword": "And "
});
formatter.match({
  "location": "UserRegistration.heEntered(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The registration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistration.theRegistrationPageDisplayedSuccessfully()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User Registration",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "The user in the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "UserRegistration.the_user_in_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "He clicks on Register link",
  "keyword": "When "
});
formatter.match({
  "location": "UserRegistration.the_user_clicks_on_Register_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "He entered \"Moataz\" , \"ahmed\" , \"test@newuser12233.com\" , \"87654321\"",
  "keyword": "And "
});
formatter.match({
  "location": "UserRegistration.heEntered(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The registration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistration.theRegistrationPageDisplayedSuccessfully()"
});
formatter.result({
  "status": "passed"
});
});