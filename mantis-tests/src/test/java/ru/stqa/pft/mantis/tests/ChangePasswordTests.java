package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends  TestBase {


  @Test
  public void testChangePassword() throws IOException, MessagingException {
//    Администратор входит в систему, переходит на страницу управления пользователями,
      String newPassword = "1qaz@wsx";
      String jamesPassword = "password";
      app.user().loginAsAdmin();
      Users users = app.db().getAllUsers();
//    выбирает заданного пользователя из db
//    Администратор нажимает кнопку Reset Password
//    Отправляется письмо на адрес пользователя
      UserData user = app.user().selectUserFromDbWithoutAdmin(users);
      app.user().startChangePassword(user.getUsername());
//    меняет пароль в james для user на дефолтный
      app.james().setUserPasswordToDefault(user.getUsername());
//    Получаем это письмо, извлекаем из него ссылку для смены пароля, проходим по этой ссылке и меняем пароль.
     List<MailMessage> mailMessages = app.james().waitForMail(user.getUsername(), jamesPassword, 60000);
     String confirmationLink =findConfirmationLink(mailMessages,user.getEmail()) ;
      app.registration().finish(confirmationLink, newPassword);
//    Проверить, что пользователь может войти в систему с новым паролем
    assertTrue(app.newSession().login(user.getUsername(),newPassword));

  }
  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex= VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

}
