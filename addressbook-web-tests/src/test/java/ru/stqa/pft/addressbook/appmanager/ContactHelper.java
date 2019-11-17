package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  protected ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {

    changeFieldValue(By.name("firstname"), contactData.getFirstname());
    changeFieldValue(By.name("middlename"), contactData.getMiddlename());
    changeFieldValue(By.name("lastname"), contactData.getLastname());
    changeFieldValue(By.name("nickname"), contactData.getNickname());
    changeFieldValue(By.name("title"), contactData.getTitle());
    changeFieldValue(By.name("company"), contactData.getCompany());
    changeFieldValue(By.name("address"), contactData.getAddress());
    changeFieldValue(By.name("home"), contactData.getHomephone());
    changeFieldValue(By.name("mobile"), contactData.getMobilephone());
    changeFieldValue(By.name("fax"), contactData.getFax());
    changeFieldValue(By.name("email"), contactData.getEmail());
    changeFieldValue(By.name("homepage"), contactData.getHomepage());
    changeFieldValueWithoutClear(By.name("bday"), contactData.getBday());
    changeFieldValueWithoutClear(By.name("bmonth"), contactData.getBmonth());
    changeFieldValue(By.name("byear"), contactData.getByear());
    changeFieldValueWithoutClear(By.name("aday"), contactData.getAday());
    changeFieldValueWithoutClear(By.name("amonth"), contactData.getAmonth());
    changeFieldValue(By.name("ayear"), contactData.getAyear());
    changeFieldValue(By.name("address2"), contactData.getAddress2());
    changeFieldValue(By.name("phone2"), contactData.getSecondaryphone());
    changeFieldValue(By.name("notes"), contactData.getNotes());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroupname());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    wd.get("http://localhost/addressbook/edit.php");
  }


  public void selectContact(int index) {

    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContacts() {
    click(new By.ByXPath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }
  public void delete(int index) {
    selectContact(index);
    deleteSelectedContacts();
  }
  public void initContactModification(int index) {

    wd.findElements(new By.ByXPath("//a/img[contains(@title[1],'Edit')]")).get(index).click();
//    click(new By.ByXPath("//a/img[contains(@title[1],'Edit')]"));
  }
  public void modify(ContactData contact) {
    fillContactForm(contact, false);
    submitContactModification();
  }
  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent(new By.ByXPath("//a/img[contains(@title[1],'Edit')]"));
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> container = element.findElements(By.tagName("td"));
      String firstname = container.get(2).getText();
      String lastname = container.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }
}

