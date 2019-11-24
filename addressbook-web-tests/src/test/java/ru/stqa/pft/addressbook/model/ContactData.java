package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstname;
  @Expose
  private String middlename;
  @Expose
  private String lastname;
  private String nickname;
  private String title;
  @Expose
  private String company;
  @Expose
  private String address;
  @Expose
  private String homephone;
  @Expose
  private String mobilephone;
  @Expose
  private String workphone;
  @Expose
  private String secondaryphone;
  @Expose
  private String fax;
  @Expose
  private String email;
  @Expose
  private String ayear;
  @Expose
  private String address2;
  @Expose
  private String notes;
  @Expose
  private String groupname;
  @Expose
  private String email2;
  @Expose
  private String email3;
  @Expose
  private String homepage;
  @Expose
  private String bday;
  @Expose
  private String bmonth;
  @Expose
  private String byear;
  @Expose
  private String aday;
  @Expose
  private String amonth;

  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }


  public ContactData withSecondaryPhone(String secondaryphone) {
    this.secondaryphone = secondaryphone;
    return this;
  }


  public String getEmail2() {
    return email2;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  private String allPhones;

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  private String allEmails;


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  public ContactData withMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
    return this;
  }

  public ContactData withWorkphone(String workphone) {
    this.workphone = workphone;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withBday(String bday) {
    this.bday = bday;
    return this;
  }

  public ContactData withBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }

  public ContactData withAday(String aday) {
    this.aday = aday;
    return this;
  }

  public ContactData withAmonth(String amonth) {
    this.amonth = amonth;
    return this;
  }

  public ContactData withAyear(String ayear) {
    this.ayear = ayear;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withGroupname(String groupname) {
    this.groupname = groupname;
    return this;
  }


  public int getId() {
    return id;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homephone;
  }

  public String getMobilePhone() {
    return mobilephone;
  }

  ;

  public String getWorkPhone() {
    return workphone;
  }

  ;

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  ;

  public String getHomepage() {
    return homepage;
  }

  ;

  public String getBday() {
    return bday;
  }

  ;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(address, that.address) &&
            Objects.equals(homephone, that.homephone) &&
            Objects.equals(mobilephone, that.mobilephone) &&
            Objects.equals(workphone, that.workphone) &&
            Objects.equals(secondaryphone, that.secondaryphone) &&
            Objects.equals(email, that.email) &&
            Objects.equals(address2, that.address2) &&
            Objects.equals(groupname, that.groupname) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3) &&
            Objects.equals(allPhones, that.allPhones) &&
            Objects.equals(allEmails, that.allEmails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, address, homephone, mobilephone, workphone, secondaryphone, email, address2, groupname, email2, email3, allPhones, allEmails);
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getAday() {
    return aday;
  }

  public String getAmonth() {
    return amonth;
  }

  public String getAyear() {
    return ayear;
  }

  public String getAddress2() {
    return address2;
  }

  public String getSecondaryphone() {
    return secondaryphone;
  }

  public String getNotes() {
    return notes;
  }

  public String getGroupname() {
    return groupname;
  }
}


