package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  @Test
  public void testDeleteSelectedContact() {

    app.goTo().homePage();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData("deletefirstname", "deletemiddlename",
              "lastname",
              "nickname", "title",
              "company", "address",
              "homephone", "mobilephone",
              "workphone", "fax",
              "email", "homepage",
              "17", "March", "1985",
              "18", "April", "1987",
              "address2", "secondaryphone", "notes", "test1"));
    }
    List<ContactData> before = app.contact().list();
    int index= before.size() - 1;
    app.contact().delete(index);;
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(before, after);
    app.goTo().homePage();

  }



}
