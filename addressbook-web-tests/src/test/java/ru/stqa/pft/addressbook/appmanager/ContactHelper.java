package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  protected ContactHelper(WebDriver wd) {
   super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData) {

    changeFieldValue(By.name("firstname"),contactData.getFirstname());
    changeFieldValue(By.name("middlename"),contactData.getMiddlename());
    changeFieldValue(By.name("lastname"),contactData.getLastname());
    changeFieldValue(By.name("nickname"),contactData.getNickname());
    changeFieldValue(By.name("title"),contactData.getTitle());
    changeFieldValue(By.name("company"),contactData.getCompany());
    changeFieldValue(By.name("address"),contactData.getAddress());
    changeFieldValue(By.name("home"),contactData.getHomephone());
    changeFieldValue(By.name("mobile"),contactData.getMobilephone());
    changeFieldValue(By.name("fax"),contactData.getFax());
    changeFieldValue(By.name("email"),contactData.getEmail());
    changeFieldValue(By.name("homepage"),contactData.getHomepage());
    changeFieldValueWithoutClear(By.name("bday"),contactData.getBday());
    changeFieldValueWithoutClear(By.name("bmonth"),contactData.getBmonth());
    changeFieldValue(By.name("byear"),contactData.getByear());
    changeFieldValueWithoutClear(By.name("aday"),contactData.getAday());
    changeFieldValueWithoutClear(By.name("amonth"),contactData.getAmonth());
    changeFieldValue(By.name("ayear"),contactData.getAyear());
    changeFieldValue(By.name("address2"),contactData.getAddress2());
    changeFieldValue(By.name("phone2"),contactData.getSecondaryphone());
    changeFieldValue(By.name("notes"),contactData.getNotes());
  }

  public void initContactCreation() {
    wd.get("http://localhost/addressbook/edit.php");
  }


  public void selectContact() {
    click(By.name("selected[]"));
  }
  public void deleteSelectedContacts() {
    click(new By.ByXPath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
   click(new By.ByXPath("//a/img[contains(@title[1],'Edit')]"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }
}
