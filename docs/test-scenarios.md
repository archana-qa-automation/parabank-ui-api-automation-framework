# ParaBank Test Scenarios

## 1. Login

| ID | Scenario | Preconditions | Steps | Expected Result | Type | Automation |
|----|----------|---------------|-------|-----------------|------|------------|
| TS_01 | Login with valid UserName and password | User is registered | 1. Open the Login page<br>2. Enter a valid UserName<br>3. Enter a valid password<br>4. Click the Log In button | User is successfully logged in and redirected to the Accounts Overview page | Positive | Yes |
| TS_03 | Login with invalid UserName | User is registered | 1. Open the Login page<br>2. Enter an invalid UserName<br>3. Enter a valid password<br>4. Click Log In | Error page shows: "The UserName and password could not be verified." | Negative | Yes |
| TS_04 | Login with invalid password | User is registered | 1. Open the Login page<br>2. Enter a valid UserName<br>3. Enter an invalid password<br>4. Click Log In | Error page shows: "The UserName and password could not be verified." | Negative | Yes |
| TS_05 | Login with invalid UserName and invalid password | User is registered | 1. Open the Login page<br>2. Enter an invalid UserName<br>3. Enter an invalid password<br>4. Click Log In | Error page shows: "The UserName and password could not be verified." | Negative | Yes |
| TS_08 | Verify Accounts Overview page after successful login | User is registered | 1. Perform a successful login | Accounts Overview page is displayed successfully | Positive | Yes |
| TS_09 | Verify user session after browser refresh | User is logged in | 1. Log in successfully<br>2. Refresh the browser | User session remains active and the application remains accessible | Positive | Yes |
| TS_10 | Verify access to protected pages after logout | User is logged in | 1. Log in successfully<br>2. Click Log Out<br>3. Try to access the Accounts Overview page URL | User is redirected to the Login page and cannot access protected pages | Positive | Yes |
| TS_11 | Verify Remember Me functionality | User is registered | 1. Select Remember Me<br>2. Login successfully<br>3. Close and reopen browser | User credentials/session are remembered as per application design | Positive | No (verify first) |