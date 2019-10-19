package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Client {
    private final SimpleStringProperty surname;
    private final SimpleStringProperty name;
    private final SimpleStringProperty patronymic;
    private LocalDate birthday;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty seria_passport;
    private final SimpleStringProperty number_passport;
    private final SimpleStringProperty who_issue;
    private LocalDate date_issue;
    private final SimpleStringProperty identification_number;
    private final SimpleStringProperty birth_place;
    private final SimpleStringProperty now_city;
    private final SimpleStringProperty now_address;
    private final SimpleStringProperty home_phone;
    private final SimpleStringProperty mob_phone;
    private final SimpleStringProperty mail;
    private final SimpleStringProperty birth_city;
    private final SimpleStringProperty married;
    private final SimpleStringProperty nationality;
    private final SimpleStringProperty disability;
    private final SimpleStringProperty pensioner;
    private final SimpleDoubleProperty money;

    public SimpleDoubleProperty moneyProperty() {
        return money;
    }

    public void setMoney(double money) {
        this.money.set(money);
    }

    public Client(String surname, String name, String patronymic, LocalDate birthday, String gender, String seria_passport, String number_passport, String who_issue, LocalDate date_issue, String identification_number, String birth_place, String now_city, String now_address, String home_phone, String mob_phone, String mail, String birth_city, String married, String nationality, String disability, String pensioner, Double money) {
        this.surname = new SimpleStringProperty(surname);
        this.name = new SimpleStringProperty(name);
        this.patronymic = new SimpleStringProperty(patronymic);
        this.birthday=birthday;
        this.gender = new SimpleStringProperty(gender);
        this.seria_passport = new SimpleStringProperty(seria_passport);
        this.number_passport = new SimpleStringProperty(number_passport);
        this.who_issue = new SimpleStringProperty(who_issue);
        this.date_issue = date_issue;
        this.identification_number = new SimpleStringProperty(identification_number);
        this.birth_place = new SimpleStringProperty(birth_place);
        this.now_city = new SimpleStringProperty(now_city);
        this.now_address = new SimpleStringProperty(now_address);
        this.home_phone = new SimpleStringProperty(home_phone);
        this.mob_phone = new SimpleStringProperty(mob_phone);
        this.mail = new SimpleStringProperty(mail);
        this.birth_city = new SimpleStringProperty(birth_city);
        this.married = new SimpleStringProperty(married);
        this.nationality = new SimpleStringProperty(nationality);
        this.disability = new SimpleStringProperty(disability);
        this.pensioner = new SimpleStringProperty(pensioner);
        this.money = new SimpleDoubleProperty(money);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPatronymic() {
        return patronymic.get();
    }

    public SimpleStringProperty patronymicProperty() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic.set(patronymic);
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday){this.birthday=birthday;}

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getSeria_passport() {
        return seria_passport.get();
    }

    public SimpleStringProperty seria_passportProperty() {
        return seria_passport;
    }

    public void setSeria_passport(String seria_passport) {
        this.seria_passport.set(seria_passport);
    }

    public String getNumber_passport() {
        return number_passport.get();
    }

    public SimpleStringProperty number_passportProperty() {
        return number_passport;
    }

    public void setNumber_passport(String number_passport) {
        this.number_passport.set(number_passport);
    }

    public String getWho_issue() {
        return who_issue.get();
    }

    public SimpleStringProperty who_issueProperty() {
        return who_issue;
    }

    public void setWho_issue(String who_issue) {
        this.who_issue.set(who_issue);
    }

    public LocalDate getDate_issue() {
        return date_issue;
    }

    public void setDate_issue(LocalDate date){this.date_issue=date;}

    public String getIdentification_number() {
        return identification_number.get();
    }

    public SimpleStringProperty identification_numberProperty() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number.set(identification_number);
    }

    public String getBirth_place() {
        return birth_place.get();
    }

    public SimpleStringProperty birth_placeProperty() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place.set(birth_place);
    }

    public String getNow_city() {
        return now_city.get();
    }

    public SimpleStringProperty now_cityProperty() {
        return now_city;
    }

    public void setNow_city(String now_city) {
        this.now_city.set(now_city);
    }

    public String getNow_address() {
        return now_address.get();
    }

    public SimpleStringProperty now_addressProperty() {
        return now_address;
    }

    public void setNow_address(String now_address) {
        this.now_address.set(now_address);
    }

    public String getHome_phone() {
        return home_phone.get();
    }

    public SimpleStringProperty home_phoneProperty() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone.set(home_phone);
    }

    public String getMob_phone() {
        return mob_phone.get();
    }

    public SimpleStringProperty mob_phoneProperty() {
        return mob_phone;
    }

    public void setMob_phone(String mob_phone) {
        this.mob_phone.set(mob_phone);
    }

    public String getMail() {
        return mail.get();
    }

    public SimpleStringProperty mailProperty() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }

    public String getBirth_city() {
        return birth_city.get();
    }

    public SimpleStringProperty birth_cityProperty() {
        return birth_city;
    }

    public void setBirth_city(String birth_city) {
        this.birth_city.set(birth_city);
    }

    public String getMarried() {
        return married.get();
    }

    public SimpleStringProperty marriedProperty() {
        return married;
    }

    public void setMarried(String married) {
        this.married.set(married);
    }

    public String getNationality() {
        return nationality.get();
    }

    public SimpleStringProperty nationalityProperty() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality.set(nationality);
    }

    public String getDisability() {
        return disability.get();
    }

    public SimpleStringProperty disabilityProperty() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability.set(disability);
    }

    public String getPensioner() {
        return pensioner.get();
    }

    public SimpleStringProperty pensionerProperty() {
        return pensioner;
    }

    public void setPensioner(String pensioner) {
        this.pensioner.set(pensioner);
    }

    public double getMoney() {
        return money.get();
    }
}