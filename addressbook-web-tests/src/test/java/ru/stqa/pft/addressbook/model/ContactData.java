package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String homephone;
  private final String mobilephone;
  private final String workphone;
  private final String fax;
  private final String email;
  private final String homepage;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String aday;
  private final String amonth;
  private final String ayear;
  private final String address2;
  private final String secondaryphone;
  private final String notes;
  private String groupname;

  public void setId(int id) {
    this.id = id;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }

  public ContactData(int id, String firstname,
                     String middlename, String lastname, String nickname,
                     String title, String company, String address,
                     String homephone, String mobilephone, String workphone,
                     String fax, String email, String homepage, String bday,
                     String bmonth, String byear, String aday,
                     String amonth, String ayear,
                     String address2, String secondaryphone,
                     String notes, String groupname) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homephone = homephone;
    this.mobilephone = mobilephone;
    this.workphone = workphone;
    this.fax = fax;
    this.email = email;
    this.homepage = homepage;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.aday = aday;
    this.amonth = amonth;
    this.ayear = ayear;
    this.address2 = address2;
    this.secondaryphone = secondaryphone;
    this.notes = notes;

    this.groupname = groupname;
  }
  public ContactData(String firstname,
                     String middlename, String lastname, String nickname,
                     String title, String company, String address,
                     String homephone, String mobilephone, String workphone,
                     String fax, String email, String homepage, String bday,
                     String bmonth, String byear, String aday,
                     String amonth, String ayear,
                     String address2, String secondaryphone,
                     String notes, String groupname) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homephone = homephone;
    this.mobilephone = mobilephone;
    this.workphone = workphone;
    this.fax = fax;
    this.email = email;
    this.homepage = homepage;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.aday = aday;
    this.amonth = amonth;
    this.ayear = ayear;
    this.address2 = address2;
    this.secondaryphone = secondaryphone;
    this.notes = notes;
    this.groupname = groupname;
  }

  public int getId() {
    return id;
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

  public String getHomephone() {
    return homephone;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  ;

  public String getWorkphone() {
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


