Feature: User Accounts

  # Scenario 1: Successful Login
  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters a valid username "admin" and password "admin123"
    And clicks the "Login" button
    Then the user should be redirected to the "Dashboard" page

  # Scenario 2: Login with Invalid Credentials
  Scenario: User logs in with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username "invalidUser" and password "wrongPassword"
    And clicks the "Login" button
    Then an error message "Invalid credentials" should be displayed

  # Scenario 3: Forgot Password Functionality
  Scenario: User requests password reset
    Given the user is on the login page
    When the user clicks on the "Forgot your password?" link
    And enters a registered email "user@example.com"
    And clicks the "Reset Password" button
    Then a password reset confirmation message "Reset Password link sent successfully" should be displayed

  # Scenario 4: Update Profile Information
  #Background:
  #	Given the user is on the login page
    #When the user enters a valid username "admin" and password "admin123"
    #And clicks the "Login" button
  #
  #Scenario: User updates profile information
    #Given the user is logged in and on the "My Info" page
    #When the user updates their contact information with phone number "123-456-7890"
    #And updates their emergency contact with name as "John Doe" and relation "Friend" and phone "789456123"
    #And saves the changes
    #Then a profile update confirmation message "Profile updated successfully" should be displayed
    #And the updated information should be saved correctly