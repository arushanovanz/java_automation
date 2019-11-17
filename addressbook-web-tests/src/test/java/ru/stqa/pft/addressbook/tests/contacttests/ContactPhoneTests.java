package ru.stqa.pft.addressbook.tests.contacttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstname("firstname").withMiddlename("middlename").withLastname("lastname")
              .withNickname("nickname").withTitle( "title").withCompany("company").withAddress("address").withHomephone("homephone")
              .withMobilephone("mobilephone").withWorkphone("workphone").withFax("fax").withEmail("email").withHomepage("homepage")
              .withBday("17").withBmonth("March").withByear("1985").withAday("18").withAmonth("April").withAyear("1987").withAddress2("address2")
              .withNotes("notes").withSecondaryPhone("secondaryphone").withGroupname("test1"));
    }
  }

  @Test
  public void testContactPhones(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(),equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String  mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone(),contact.getSecondaryphone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static  String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
