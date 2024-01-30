Feature: Login in to SDUU website

  
  Background:
  Given the user in on the login page of SSDU
  
# Positive Testcase - Successfully logged in as User with valid credentials
@validCredentials
Scenario: Login Successfully with valid test data
  When the user enters the valid UserID
  And the user enters the valid Password 
  And the user clicks on the Login button
  Then the user should be logged in successfully and navigates to the Home Page

#Negative Testcase-Unsuccessfully logged in as User with Invalid credentials
@invalidCredentials
Scenario Outline: Login Unsucesfully with Invalid test data
When the user enters the <UserID> and <Password>
And the user clicks on the Login button
Then the error message appears Your Login id or Password was not correct. is shown

Examples:

|UserID       |Password  |
|"c143"  |"passwd@2" |
|"cddd" |" @123"  |
|"1439"  |"passwd"  |


 @missingCredentials
  Scenario Outline: Login unsuccessfully with missing credentials
    When the user enters the missing <UserID> and <Password>
    And the user clicks on the Login button
    Then the username or password fields is required error message appears

    Examples:
      | UserID  | Password   |
      | " "     | "passwd@2" |
      | "c1439" | " "        |

  
