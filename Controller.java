package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ObservableList cities = FXCollections.observableArrayList();
    ObservableList marriedList = FXCollections.observableArrayList();
    ObservableList nationalities = FXCollections.observableArrayList();
    ObservableList disabilities = FXCollections.observableArrayList();
    ObservableList pensionerList = FXCollections.observableArrayList("да","нет");
    ObservableList genderList = FXCollections.observableArrayList("мужской","женский");
    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, String> surname;
    @FXML
    private TableColumn<Client, String> name;
    @FXML
    private TableColumn<Client, String> patronymic;
    @FXML
    private TableColumn<Client, LocalDate> birthday;
    @FXML
    private TableColumn<Client, String> gender;
    @FXML
    private TableColumn<Client, String> seria_passport;
    @FXML
    private TableColumn<Client, String> number_passport;
    @FXML
    private TableColumn<Client, String> who_issue;
    @FXML
    private TableColumn<Client, LocalDate> date_issue;
    @FXML
    private TableColumn<Client, String> identification_number;
    @FXML
    private TableColumn<Client, String> birth_place;
    @FXML
    private TableColumn<Client, String> now_city;
    @FXML
    private TableColumn<Client, String> now_address;
    @FXML
    private TableColumn<Client, String> home_phone;
    @FXML
    private TableColumn<Client, String> mob_phone;
    @FXML
    private TableColumn<Client, String> mail;
    @FXML
    private TableColumn<Client, String> birth_city;
    @FXML
    private TableColumn<Client, String> married;
    @FXML
    private TableColumn<Client, String> nationality;
    @FXML
    private TableColumn<Client, String> disability;
    @FXML
    private TableColumn<Client, String> pensioner;
    @FXML
    private TableColumn<Client, Double> money;
    @FXML
    private Button deleteButton;

    public void EndButtonPushed(ActionEvent event) throws IOException {
        System.exit(0);
    }


    public void newClientButtonPushed(ActionEvent event) throws IOException {
        SceneChanger sc = new SceneChanger();
        sc.changeScene(event, "addClient.fxml", "Добавить нового клиента");
    }

    public void deleteButtonPushed() throws SQLException {
        ObservableList<Client> clientsSelected, allClients;
        Connection conn = MyConnection.getConnection();
        allClients=clientTable.getItems();
        clientsSelected=clientTable.getSelectionModel().getSelectedItems();
        for(Client client:clientsSelected) {
            PreparedStatement delete = conn.prepareStatement("DELETE FROM rppzl.client WHERE `Идент. номер` = '" + client.getIdentification_number() + "' ;");
            delete.executeUpdate();
        }
        clientsSelected.forEach(allClients::remove);
        if (conn != null)
            conn.close();
    }

    public void loadClients() throws SQLException {
        ObservableList<Client> clients = FXCollections.observableArrayList();

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = MyConnection.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM client");
            while (resultSet.next()) {
                Client newClient = new Client(resultSet.getString("Фамилия"),
                        resultSet.getString("Имя"),
                        resultSet.getString("Отчество"),
                        resultSet.getDate("Дата рождения").toLocalDate(),
                        resultSet.getString("Пол"),
                        resultSet.getString("Серия паспорта"),
                        resultSet.getString("№ паспорта"),
                        resultSet.getString("Кем выдан"),
                        resultSet.getDate("Дата выдачи").toLocalDate(),
                        resultSet.getString("Идент. номер"),
                        resultSet.getString("Место рождения"),
                        resultSet.getString("Город факт. проживания"),
                        resultSet.getString("Адрес факт. проживания"),
                        resultSet.getString("Телефон дом."),
                        resultSet.getString("Телефон моб."),
                        resultSet.getString("E-mail"),
                        resultSet.getString("Город прописки"),
                        resultSet.getString("Семейное положение"),
                        resultSet.getString("Гражданство"),
                        resultSet.getString("Инвалидность"),
                        resultSet.getString("Пенсионер"),
                        resultSet.getDouble("Ежемесячный доход")
                );
                clients.add(newClient);
            }
            clientTable.getItems().addAll(clients);

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
    }
    @Override
    //@FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        surname.setCellValueFactory(new PropertyValueFactory<Client, String>("surname"));
        name.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        patronymic.setCellValueFactory(new PropertyValueFactory<Client, String>("patronymic"));
        birthday.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("birthday"));
        gender.setCellValueFactory(new PropertyValueFactory<Client, String>("gender"));
        seria_passport.setCellValueFactory(new PropertyValueFactory<Client, String>("seria_passport"));
        number_passport.setCellValueFactory(new PropertyValueFactory<Client, String>("number_passport"));
        who_issue.setCellValueFactory(new PropertyValueFactory<Client, String>("who_issue"));
        date_issue.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("date_issue"));
        identification_number.setCellValueFactory(new PropertyValueFactory<Client, String>("identification_number"));
        birth_place.setCellValueFactory(new PropertyValueFactory<Client, String>("birth_place"));
        now_city.setCellValueFactory(new PropertyValueFactory<Client, String>("now_city"));
        now_address.setCellValueFactory(new PropertyValueFactory<Client, String>("now_address"));
        home_phone.setCellValueFactory(new PropertyValueFactory<Client, String>("home_phone"));
        mob_phone.setCellValueFactory(new PropertyValueFactory<Client, String>("mob_phone"));
        mail.setCellValueFactory(new PropertyValueFactory<Client, String>("mail"));
        birth_city.setCellValueFactory(new PropertyValueFactory<Client, String>("birth_city"));
        married.setCellValueFactory(new PropertyValueFactory<Client, String>("married"));
        nationality.setCellValueFactory(new PropertyValueFactory<Client, String>("nationality"));
        disability.setCellValueFactory(new PropertyValueFactory<Client, String>("disability"));
        pensioner.setCellValueFactory(new PropertyValueFactory<Client, String>("pensioner"));
        money.setCellValueFactory(new PropertyValueFactory<Client, Double>("money"));

        clientTable.setEditable(true);

        //*****************************
        cities.removeAll(cities);
        marriedList.removeAll(marriedList);
        nationalities.removeAll(nationalities);
        disabilities.removeAll(disabilities);

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            try {
                conn = MyConnection.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM city");
            while (resultSet.next()) {
                cities.add(resultSet.getString("city"));
            }
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM disability");
            while (resultSet.next()) {
                disabilities.add(resultSet.getString("type_disability"));
            }
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM marital_status");
            while (resultSet.next()) {
                marriedList.add(resultSet.getString("marital_status"));
            }
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM nationality");
            while (resultSet.next()) {
                nationalities.add(resultSet.getString("Гражданство"));
            }
            //*****************************
            surname.setCellFactory(TextFieldTableCell.forTableColumn());
            name.setCellFactory(TextFieldTableCell.forTableColumn());
            patronymic.setCellFactory(TextFieldTableCell.forTableColumn());
            birthday.setCellFactory(TextFieldTableCell.<Client, LocalDate>forTableColumn(new LocalDateStringConverter()));
            gender.setCellFactory(ComboBoxTableCell.forTableColumn(genderList));
            seria_passport.setCellFactory(TextFieldTableCell.forTableColumn());
            number_passport.setCellFactory(TextFieldTableCell.forTableColumn());
            who_issue.setCellFactory(TextFieldTableCell.forTableColumn());
            date_issue.setCellFactory(TextFieldTableCell.<Client, LocalDate>forTableColumn(new LocalDateStringConverter()));
            identification_number.setCellFactory(TextFieldTableCell.forTableColumn());
            birth_place.setCellFactory(TextFieldTableCell.forTableColumn());
            now_city.setCellFactory(ComboBoxTableCell.forTableColumn(cities));
            now_address.setCellFactory(TextFieldTableCell.forTableColumn());
            home_phone.setCellFactory(TextFieldTableCell.forTableColumn());
            mob_phone.setCellFactory(TextFieldTableCell.forTableColumn());
            mail.setCellFactory(TextFieldTableCell.forTableColumn());
            birth_city.setCellFactory(ComboBoxTableCell.forTableColumn(cities));
            married.setCellFactory(ComboBoxTableCell.forTableColumn(marriedList));
            nationality.setCellFactory(ComboBoxTableCell.forTableColumn(nationalities));
            disability.setCellFactory(ComboBoxTableCell.forTableColumn(disabilities));
            pensioner.setCellFactory(ComboBoxTableCell.forTableColumn(pensionerList));
            money.setCellFactory(TextFieldTableCell.<Client, Double>forTableColumn(new DoubleStringConverter()));

            try {
                loadClients();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            deleteButton.setOnAction(e -> {
                try {
                    deleteButtonPushed();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onEditChangesSurname(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setSurname(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("ALTER TABLE rppzl.client DROP PRIMARY KEY;");
        update.executeUpdate();
        update = conn.prepareStatement("ALTER TABLE rppzl.client ADD PRIMARY KEY (`Идент. номер`);");
        update.executeUpdate();
        update = conn.prepareStatement("UPDATE rppzl.client SET `Фамилия` = '" + client.getSurname() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        update = conn.prepareStatement("ALTER TABLE rppzl.client DROP PRIMARY KEY;");
        update.executeUpdate();
        update = conn.prepareStatement("ALTER TABLE rppzl.client ADD PRIMARY KEY (`Идент. номер`,`Фамилия`);");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesName(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setName(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Имя` = '" + client.getName() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesPatronymic(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setPatronymic(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Отчество` = '" + client.getPatronymic() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesBirthday(TableColumn.CellEditEvent<Client, LocalDate> clientLocalDateCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setBirthday(clientLocalDateCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Дата рождения` = '" + client.getBirthday() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesSeriaPassport(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setSeria_passport(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Серия паспорта` = '" + client.getSeria_passport() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesGender(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setGender(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Пол` = '" + client.getGender() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesNumberPassport(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setNumber_passport(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `№ паспорта` = '" + client.getNumber_passport() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesWhoIssue(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setWho_issue(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Кем выдан` = '" + client.getWho_issue() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesDateIssue(TableColumn.CellEditEvent<Client, LocalDate> clientLocalDateCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setDate_issue(clientLocalDateCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Дата выдачи` = '" + client.getDate_issue() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesID(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setIdentification_number(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("ALTER TABLE rppzl.client DROP PRIMARY KEY;");
        update.executeUpdate();
        update = conn.prepareStatement("ALTER TABLE rppzl.client ADD PRIMARY KEY (`Фамилия`);");
        update.executeUpdate();
        update = conn.prepareStatement("UPDATE rppzl.client SET `Идент. номер` = '" + client.getIdentification_number() + "' WHERE `Серия паспорта`='"+client.getSeria_passport()+"' AND `№ паспорта`='"+client.getNumber_passport()+"';");
        update.executeUpdate();
        update = conn.prepareStatement("ALTER TABLE rppzl.client DROP PRIMARY KEY;");
        update.executeUpdate();
        update = conn.prepareStatement("ALTER TABLE rppzl.client ADD PRIMARY KEY (`Идент. номер`,`Фамилия`);");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesBirthPlace(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setBirth_place(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Место рождения` = '" + client.getBirth_place() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesNowCity(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setNow_city(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Город факт. проживания` = '" + client.getNow_city() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesNowAddress(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setNow_address(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Адрес факт. проживания` = '" + client.getNow_address() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesMobPhone(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setMob_phone(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Телефон моб.` = '" + client.getMob_phone() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesHomePhone(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setHome_phone(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Телефон дом.` = '" + client.getHome_phone() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesMail(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setMail(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `E-mail` = '" + client.getMail() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesBirthCity(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setBirth_city(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Город прописки` = '" + client.getBirth_city() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesMarried(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setMarried(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Семейное положение` = '" + client.getMarried() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesNationality(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setNationality(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Гражданство` = '" + client.getNationality() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesDisability(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setDisability(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Инвалидность` = '" + client.getDisability() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesPensioner(TableColumn.CellEditEvent<Client, String> clientStringCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setPensioner(clientStringCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Пенсионер` = '" + client.getPensioner() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }

    public void onEditChangesMoney(TableColumn.CellEditEvent<Client, Double> clientDoubleCellEditEvent) throws SQLException {
        Client client=clientTable.getSelectionModel().getSelectedItem();
        client.setMoney(clientDoubleCellEditEvent.getNewValue());

        Connection conn = MyConnection.getConnection();

        PreparedStatement update = conn.prepareStatement("UPDATE rppzl.client SET `Ежемесячный доход` = '" + client.getMoney() + "' WHERE `Идент. номер`='"+client.getIdentification_number()+"';");
        update.executeUpdate();
        if (conn != null)
            conn.close();
    }
}
