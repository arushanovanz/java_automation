package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

public class UserHelper extends HelperBase {

  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void loginAsAdmin() {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    changeFieldValue(By.name("username"), app.getProperty("web.adminLogin"));
    changeFieldValue(By.name("password"), app.getProperty("web.adminPassword"));
    click(By.cssSelector("input[value='Login']"));
  }

  public void startChangePassword(String user) {
    if (!isElementPresent(By.linkText("Manage Users"))) {
      click(By.linkText("Manage"));
    }
    click(By.linkText("Manage Users"));
    click(By.linkText(user));
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public UserData selectUserFromDbWithoutAdmin(Users users) {
    for (UserData user : users) {
      if (!user.getUsername().equals("administrator"))
      { return user;
      }
    }
    return null;
  }
}