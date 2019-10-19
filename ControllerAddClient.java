package sample;

import com.mysql.cj.conf.StringProperty;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerAddClient implements Initializable {
    ObservableList cities = FXCollections.observableArrayList();
    ObservableList marriedList = FXCollections.observableArrayList();
    ObservableList nationalities = FXCollections.observableArrayList();
    ObservableList disabilities = FXCollections.observableArrayList();
    @FXML
    private TextField new_surname;
    @FXML
    private Label stateSurname;
    @FXML
    private TextField new_name;
    @FXML
    private Label stateName;
    @FXML
    private TextField new_patronymic;
    @FXML
    private Label statePatronymic;
    @FXML
    private DatePicker new_birthday;
    @FXML
    private Label stateBirthday;
    @FXML
    private RadioButton man_gender;
    @FXML
    RadioButton woman_gender;
    private ToggleGroup genderToggleGroup;
    @FXML
    private Label stateGender;
    @FXML
    private TextField new_seria_passport;
    @FXML
    private Label stateSeria;
    @FXML
    private TextField new_number_passport;
    @FXML
    private Label stateNumber;
    @FXML
    private TextField new_who_issue;
    @FXML
    private Label stateWho;
    @FXML
    private DatePicker new_date_issue;
    @FXML
    private Label stateDate;
    @FXML
    private TextField new_identification_number;
    @FXML
    private Label stateId;
    @FXML
    private TextField new_birth_place;
    @FXML
    private Label stateBirthPlace;
    @FXML
    private ChoiceBox<String> new_now_city;
    @FXML
    private Label stateNowCity;
    @FXML
    private TextField new_now_address;
    @FXML
    private Label stateNowAddress;
    @FXML
    private TextField new_home_phone;
    @FXML
    private TextField new_mob_phone;
    @FXML
    private TextField new_mail;
    @FXML
    private ChoiceBox<String> new_birth_city;
    @FXML
    private Label stateBirthCity;
    @FXML
    private ChoiceBox<String> new_married;
    @FXML
    private Label stateMarried;
    @FXML
    private ChoiceBox<String> new_nationality;
    @FXML
    private Label stateNationality;
    @FXML
    private ChoiceBox<String> new_disability;
    @FXML
    private Label stateDisability;
    @FXML
    private CheckBox new_pensioner;
    @FXML
    private TextField new_money;

    @FXML
    private Button addClient;

    public void EndButtonPushed(ActionEvent event) throws IOException {
        System.exit(0);
    }

    public void PrevButtonPushed(ActionEvent event) throws IOException {
        SceneChanger sc = new SceneChanger();
        sc.changeScene(event, "sample.fxml", "Работа с клиентами");
    }

    //This method for check statement
    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }


    public int checkStateText() {
        int stateForText = 0;
        if (!isNullOrEmpty(new_surname.getText())) {
            stateSurname.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateSurname.setTextFill(Color.web("#ff0000"));
        if (!isNullOrEmpty(new_name.getText())){
            stateName.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateName.setTextFill(Color.web("#ff0000"));
        if (!isNullOrEmpty(new_patronymic.getText())){
            statePatronymic.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            statePatronymic.setTextFill(Color.web("#ff0000"));
        if (new_birthday.getValue()!=null){
            stateBirthday.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateBirthday.setTextFill(Color.web("#ff0000"));
        if (this.genderToggleGroup.getSelectedToggle() != null){
            stateGender.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateGender.setTextFill(Color.web("#ff0000"));
        if (!new_seria_passport.getText().equals("__")){
            stateSeria.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateSeria.setTextFill(Color.web("#ff0000"));
        if (!new_number_passport.getText().equals("_______")){
            stateNumber.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateNumber.setTextFill(Color.web("#ff0000"));
        if (!isNullOrEmpty(new_who_issue.getText())){
            stateWho.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateWho.setTextFill(Color.web("#ff0000"));
        if (new_date_issue.getValue()!=null){
            stateDate.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateDate.setTextFill(Color.web("#ff0000"));
        if (!isNullOrEmpty(new_identification_number.getText())){
            stateId.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateId.setTextFill(Color.web("#ff0000"));
        if (!isNullOrEmpty(new_birth_place.getText())){
            stateBirthPlace.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateBirthPlace.setTextFill(Color.web("#ff0000"));
        if (!new_now_city.getSelectionModel().isEmpty()){
            stateNowCity.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateNowCity.setTextFill(Color.web("#ff0000"));
        if (!isNullOrEmpty(new_now_address.getText())){
            stateNowAddress.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateNowAddress.setTextFill(Color.web("#ff0000"));
        if (!new_birth_city.getSelectionModel().isEmpty()){
            stateBirthCity.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateBirthCity.setTextFill(Color.web("#ff0000"));
        if (!new_married.getSelectionModel().isEmpty()){
            stateMarried.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateMarried.setTextFill(Color.web("#ff0000"));
        if (!new_nationality.getSelectionModel().isEmpty()){
            stateNationality.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateNationality.setTextFill(Color.web("#ff0000"));
        if (!new_disability.getSelectionModel().isEmpty()){
            stateDisability.setTextFill(Color.web("#000000"));
            stateForText++;
        }
        else
            stateDisability.setTextFill(Color.web("#ff0000"));
        return stateForText;
    }


    public void addClient() throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
       int stateForText = checkStateText();
        if (stateForText == 17) {
            try (Connection connection = MyConnection.getConnection()) {
                String sql = "INSERT INTO rppzl.client(Фамилия,Имя,Отчество,`Дата рождения`,Пол,`Серия паспорта`,`№ паспорта`,`Кем выдан`,`Дата выдачи`,`Идент. номер`,`Место рождения`,`Город факт. проживания`,`Адрес факт. проживания`,`Телефон дом.`,`Телефон моб.`,`E-mail`,`Город прописки`,`Семейное положение`,Гражданство,Инвалидность,Пенсионер,`Ежемесячный доход`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                ps = connection.prepareStatement(sql);

                ps.setString(1, new_surname.getText());
                ps.setString(2, new_name.getText());
                ps.setString(3, new_patronymic.getText());
                ps.setDate(4, Date.valueOf(new_birthday.getValue()));
                System.out.println(Date.valueOf(new_birthday.getValue().toString()));
                if (this.genderToggleGroup.getSelectedToggle().equals(this.man_gender))
                    ps.setString(5, "мужской");
                if (this.genderToggleGroup.getSelectedToggle().equals(this.woman_gender))
                    ps.setString(5, "женский");
                ps.setString(6, new_seria_passport.getText());
                ps.setString(7, new_number_passport.getText());
                ps.setString(8, new_who_issue.getText());
                ps.setDate(9, Date.valueOf(new_date_issue.getValue().toString()));
                ps.setString(10, new_identification_number.getText());
                ps.setString(11, new_birth_place.getText());
                ps.setString(12, String.valueOf(new_now_city.getValue()));
                ps.setString(13, new_now_address.getText());
                ps.setString(14, new_home_phone.getText());
                ps.setString(15, new_mob_phone.getText());
                ps.setString(16, new_mail.getText());
                ps.setString(17, new_birth_city.getValue());
                ps.setString(18, new_married.getValue());
                ps.setString(19, new_nationality.getValue());
                ps.setString(20, new_disability.getValue());
                if (new_pensioner.isSelected())
                    ps.setString(21, "да");
                else
                    ps.setString(21, "нет");
                ps.setDouble(22, Double.parseDouble(new_money.getText()));

                ps.executeUpdate();

               // PrevButtonPushed(event);
            } catch (SQLException e) {
                System.out.println("ERROR!!!!!!");
                e.printStackTrace();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Пожалуйста, заполните все поля");
    }

    public void load() throws SQLException {
        cities.removeAll(cities);
        marriedList.removeAll(marriedList);
        nationalities.removeAll(nationalities);
        disabilities.removeAll(disabilities);

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //This items are for configuration the choiceBox
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rppzl" +
                    "?verifyServerCertificate=false" +
                    "&useSSL=false" +
                    "&requireSSL=false" +
                    "&useLegacyDatetimeCode=false" +
                    "&amp" +
                    "&serverTimezone=UTC", "root", "28092003");
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM city");
            while (resultSet.next()) {
                cities.add(resultSet.getString("city"));
            }
            statement = null;
            resultSet = null;
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM disability");
            while (resultSet.next()) {
                disabilities.add(resultSet.getString("type_disability"));
            }
            statement = null;
            resultSet = null;
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM marital_status");
            while (resultSet.next()) {
                marriedList.add(resultSet.getString("marital_status"));
            }
            statement = null;
            resultSet = null;
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM nationality");
            while (resultSet.next()) {
                nationalities.add(resultSet.getString("Гражданство"));
            }

            ChoiceBox choiceBoxNowCity = new_now_city;
            ChoiceBox choiceBoxBirthCity = new_birth_city;
            ChoiceBox choiceBoxMarried = new_married;
            ChoiceBox choiceBoxNationality = new_nationality;
            ChoiceBox choiceBoxDisability = new_disability;
            choiceBoxNowCity.getItems().addAll(cities);
            choiceBoxBirthCity.getItems().addAll(cities);
            choiceBoxMarried.getItems().addAll(marriedList);
            choiceBoxNationality.getItems().addAll(nationalities);
            choiceBoxDisability.getItems().addAll(disabilities);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();

        }

        //This items are for configuration the RadioButton
        genderToggleGroup = new ToggleGroup();
        this.man_gender.setToggleGroup(genderToggleGroup);
        this.woman_gender.setToggleGroup(genderToggleGroup);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            load();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        addClient.setOnAction(e-> {
            try {
                addClient();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

    }
}
