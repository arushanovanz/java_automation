package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
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
    changeFieldValue(By.name("home"), contactData.getHomePhone());
    changeFieldValue(By.name("mobile"), contactData.getMobilePhone());
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

  public void selectContactById(int id) {

    wd.findElement(By.cssSelector("input[value= '"+id+"']")).click();
  }

  public void deleteSelectedContacts() {
    click(new By.ByXPath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    contactCashe = null;
  }
  public void initContactModification(int index) {

    wd.findElements(new By.ByXPath("//a/img[contains(@title[1],'Edit')]")).get(index).click();
  }
  public void initContactModificationById(int id) {
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
      wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCashe = null;
  }
  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCashe = null;
  }

  public boolean isThereAContact() {
    return isElementPresent(new By.ByXPath("//a/img[contains(@title[1],'Edit')]"));
  }

  private Contacts contactCashe = null;

  public Contacts all() {
    if (contactCashe!=null){
      return new Contacts(contactCashe);
    }
    contactCashe = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> container = element.findElements(By.tagName("td"));
      String firstname = container.get(2).getText();
      String lastname = container.get(1).getText();
      String allPhones = container.get(5).getText();
      String allEmailes = container.get(4).getText();
      String address = container.get(3).getText();

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCashe.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                                        .withAllPhones(allPhones).withAllEmails(allEmailes).withAddress(address));
    }
    return contactCashe;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homephome = wd.findElement(By.name("home")).getAttribute("value");
    String mobilephone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workphone = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String secondaryphone = wd.findElement(By.name("phone2")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomephone(homephome).withMobilephone(mobilephone).withWorkphone(workphone)
            .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address).withSecondaryPhone(secondaryphone);
  }


}

