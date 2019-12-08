package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

public class ChangePasswordTests extends  TestBase {


  @Test
  public void testChangePassword() throws IOException {
    HttpSession session =app.newSession();
    //    Администратор входит в систему, переходит на страницу управления пользователями,
    session.login(app.getProperty("web.adminLogin"),app.getProperty("web.adminPassword"));
    app.registration().goToManagePage();

//    выбирает заданного пользователя из db
//    Администратор нажимает кнопку Reset Password
//    Отправляется письмо на адрес пользователя
//    Получаем это письмо, извлекаем из него ссылку для смены пароля, проходим по этой ссылке и меняем пароль.
//    Проверить, что пользователь может войти в систему с новым паролем

  }
}
