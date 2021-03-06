package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase {

  public RegistrationHelper(ApplicationManager app) {
   super (app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl")+"/signup_page.php");
    changeFieldValue(By.name("username"),username);
    changeFieldValue(By.name("email"),email);
    click(By.cssSelector("input[value='Signup']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    changeFieldValue(By.name("password"),password);
    changeFieldValue(By.name("password_confirm"),password);
    click(By.cssSelector("input[value='Update User']"));
  }


}
