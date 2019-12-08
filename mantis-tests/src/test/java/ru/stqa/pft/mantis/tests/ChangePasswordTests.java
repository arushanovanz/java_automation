package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

public class ChangePasswordTests extends  TestBase {


  @Test
  public void testChangePassword() throws IOException {
    HttpSession session =app.newSession();
    session.login(app.getProperty("web.adminLogin"),app.getProperty("web.adminPassword"));
    app.registration().goToManagePage();

  }
}
