package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table (name="addressbook")
public class ContactData {
  @Id
  @Column (name= "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column (name= "firstname")
  private String firstname;
  @Expose
  @Column (name= "middlename")
  private String middlename;
  @Expose
  @Column (name= "lastname")
  private String lastname;
  @Column (name= "nickname")
  private String nickname;
  @Transient
  private String title;
  @Expose
  @Transient
  private String company;

  @Expose
  @Transient
  @Column (name= "address")
  @Type(type="text")
  private String address;

  @Expose
  @Column (name= "home")
  @Type(type="text")
  private String homephone;

  @Expose
  @Column (name= "mobile")
  @Type(type="text")
  private String mobilephone;
  @Expose

  @Column (name= "work")
  @Type(type="text")
  private String workphone;

  @Expose
  @Transient
  private String secondaryphone;

  @Expose
  @Transient
  private String fax;

  @Expose
  @Type(type="text")
  @Column (name= "email")
  private String email;

  @Expose
  @Transient
  private String ayear;

  @Expose
  @Transient
  private String address2;

  @Expose
  @Transient
  private String notes;

  @Expose
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name= "address_in_groups",
          joinColumns = @JoinColumn(name="id"), inverseJoinColumns =@JoinColumn (name= "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  @Expose
  @Transient
  @Column (name= "email2")
  @Type(type="text")
  private String email2;
  @Expose
  @Transient
  @Column (name= "email2")
  @Type(type="text")
  private String email3;

  @Expose
  @Transient
  private String homepage;
  @Expose
  @Transient
  private String bday;
  @Expose
  @Transient
  private String bmonth;
  @Expose
  @Transient
  private String byear;
  @Expose
  @Transient
  private String aday;
  @Expose
  @Transient
  private String amonth;

  @Column(name ="photo")
  @Type(type="text")
  private String photo;

  @Transient
  private String allPhones;
  @Transient
  private String allEmails;

  public File getPhoto() {
    return new File (photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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



  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }




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

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", middlename='" + middlename + '\'' +
            ", lastname='" + lastname + '\'' +
            ", homephone='" + homephone + '\'' +
            ", mobilephone='" + mobilephone + '\'' +
            ", workphone='" + workphone + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            '}';
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

  public String getWorkPhone() {
    return workphone;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBday() {
    return bday;
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

  public Set<GroupData> getGroups() {
    return new Groups(groups);
  }

  public void setGroups(Set<GroupData> groups) {
    this.groups = groups;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(middlename, that.middlename) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(nickname, that.nickname) &&
            Objects.equals(title, that.title) &&
            Objects.equals(company, that.company) &&
            Objects.equals(address, that.address) &&
            Objects.equals(homephone, that.homephone) &&
            Objects.equals(mobilephone, that.mobilephone) &&
            Objects.equals(workphone, that.workphone) &&
            Objects.equals(email, that.email) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, middlename, lastname,
                             nickname, title, company, address,
                              homephone, mobilephone, workphone, email, email2, email3);
  }

  public ContactData inGroup(GroupData group) {
     groups.add(group);
     return this;
  }
}


