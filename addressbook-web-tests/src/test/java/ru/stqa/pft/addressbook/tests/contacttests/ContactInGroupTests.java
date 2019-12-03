package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.io.File;

public class ContactInGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePrecontions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("name3").withHeader("header3").withFooter("footer3"));
    }
    if (app.db().contacts().size()== 0) {
      File photo = new File("src/test/resources/example.png");
      app.contact().create(new ContactData().withFirstname("modifyfirstname").withMiddlename("modifymiddlename").withLastname("lastname")
              .withNickname("nickname").withTitle("title").withCompany("company").withAddress("address").withHomephone("homephone")
              .withMobilephone("mobilephone").withWorkphone("workphone").withFax("fax").withEmail("email").withHomepage("homepage")
              .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
              .withNotes("notes").withSecondaryPhone("secondaryphone").withPhoto(photo));
    }
  }
  @Test

  public void  testAddContactInGroup () {

         Contacts contactsBefore = app.db().contacts();
         Groups groupsBefore = app.db().groups();
         ContactData contact = app.db().contacts().iterator().next();
         GroupData group = app.db().groups().iterator().next();
         app.goTo().homePage();
         app.contact().addContactToGroup(contact.getId(), group.getId());
  }

}
