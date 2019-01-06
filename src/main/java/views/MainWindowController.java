package views;

import entities.UsersEntity;
import entities.db.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import persistence.abstracts.AddingControllers;
import persistence.abstracts.FormControllers;
import tableviews.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.URL;
import java.util.*;

public class MainWindowController extends FormControllers implements Initializable {
    private UsersEntity user = new UsersEntity();

    private int currentTable;
    private int currentRow;

    //region Lists
    private List<dbBuildingtableEntity> buildings;
    private List<dbFlattableEntity> flats;
    private List<dbHouseholdtableEntity> households;
    private List<dbHumantableEntity> humans;
    private List<dbMigrationtableEntity> migrations;
    private List<dbSalariestableEntity> salaries;
    //endregion

    //region Observables
    private ObservableList<MigrationTableView> migrationsData;
    private ObservableList<BuildingTableView> buildingsData;
    private ObservableList<FlatTableView> flatsData;
    private ObservableList<HouseholdTableView> householdsData;
    private ObservableList<HumanTableView> humansData;
    //endregion

    //region FXML
    @FXML
    private ComboBox<String> tableSelectComboBox;
    @FXML
    private ComboBox<String> rowSelectComboBox;
    @FXML
    private TextField firstFilterTextField;
    @FXML
    private Button renewButton;
    @FXML
    private CheckBox masterDetailCheckBox;
    @FXML
    private Button newBuildingButton;
    @FXML
    private Button newFlatButton;
    @FXML
    private Button newHouseholdButton;
    @FXML
    private MenuItem nameMenu;
    @FXML
    private MenuItem lastnameMenu;
    @FXML
    private MenuItem exitMenu;
    @FXML
    private MenuItem changeUserMenu;
    @FXML
    private Button newPersonButton;
    @FXML
    private Button newMigratorButton;
    @FXML
    private TableView<HumanTableView> humanTableView;
    @FXML
    private TableView<MigrationTableView> migrationTableView;
    @FXML
    private TableView<BuildingTableView> buildingTableView;
    @FXML
    private TableView<FlatTableView> flatTableView;
    @FXML
    private TableView<HouseholdTableView> householdTableView;
    @FXML
    private TableColumn<MigrationTableView, String> migrationSex;
    @FXML
    private TableColumn<MigrationTableView, String> migrationYear;
    @FXML
    private TableColumn<MigrationTableView, String> migrationCountry;
    @FXML
    private TableColumn<MigrationTableView, String> migrationTarget;
    @FXML
    private TableColumn<MigrationTableView, String> migrationLasting;
    @FXML
    private TableColumn<MigrationTableView, String> migrationMotherCountry;
    @FXML
    private TableColumn<MigrationTableView, String> migrationCitizenship;
    @FXML
    private TableColumn<HouseholdTableView, String> peopleCount;
    @FXML
    private TableColumn<HouseholdTableView, String> chamberCount;
    @FXML
    private TableColumn<HouseholdTableView, String> internet;
    @FXML
    private TableColumn<FlatTableView, String> flatType;
    @FXML
    private TableColumn<FlatTableView, String> flatSquare;
    @FXML
    private TableColumn<FlatTableView, String> flatChamberCount;
    @FXML
    private TableColumn<FlatTableView, String> flatPhone;
    @FXML
    private TableColumn<FlatTableView, String> flatTv;
    @FXML
    private TableColumn<FlatTableView, String> flatRadio;
    @FXML
    private TableColumn<BuildingTableView, String> homeType;
    @FXML
    private TableColumn<BuildingTableView, String> dateFound;
    @FXML
    private TableColumn<BuildingTableView, String> wallMaterial;
    @FXML
    private TableColumn<BuildingTableView, String> energy;
    @FXML
    private TableColumn<BuildingTableView, String> stove;
    @FXML
    private TableColumn<BuildingTableView, String> gas;
    @FXML
    private TableColumn<BuildingTableView, String> heat;
    @FXML
    private TableColumn<BuildingTableView, String> water;
    @FXML
    private TableColumn<BuildingTableView, String> hotWater;
    @FXML
    private TableColumn<BuildingTableView, String> canalisation;
    @FXML
    private TableColumn<BuildingTableView, String> closet;
    @FXML
    private TableColumn<BuildingTableView, String> shower;
    @FXML
    private TableColumn<BuildingTableView, String> garbage;
    @FXML
    private TableColumn<BuildingTableView, String> kitchen;
    @FXML
    private TableColumn<HumanTableView, String> humanWhoIs;
    @FXML
    private TableColumn<HumanTableView, String> humanSex;
    @FXML
    private TableColumn<HumanTableView, String> humanBirthDate;
    @FXML
    private TableColumn<HumanTableView, String> humanBirthPlace;
    @FXML
    private TableColumn<HumanTableView, String> humanMarriage;
    @FXML
    private TableColumn<HumanTableView, String> humanCitizenship;
    @FXML
    private TableColumn<HumanTableView, String> humanNationality;
    @FXML
    private TableColumn<HumanTableView, String> humanEducation;
    @FXML
    private TableColumn<HumanTableView, String> humanReadnWrite;
    @FXML
    private TableColumn<HumanTableView, String> humanScienceGrade;
    @FXML
    private TableColumn<HumanTableView, String> humanDoYouStudy;
    @FXML
    private TableColumn<HumanTableView, String> humanPrimarySchool;
    @FXML
    private TableColumn<HumanTableView, String> humanRussian;
    @FXML
    private TableColumn<HumanTableView, String> humanOtherLang;
    @FXML
    private TableColumn<HumanTableView, String> humanMotherTongue;
    @FXML
    private TableColumn<HumanTableView, String> humanSalarySources;
    @FXML
    private TableColumn<HumanTableView, String> humanMainSource;
    @FXML
    private TableColumn<HumanTableView, String> humanOctoberSalary;
    @FXML
    private TableColumn<HumanTableView, String> humanPosition;
    @FXML
    private TableColumn<HumanTableView, String> humanWorkNear;
    @FXML
    private TableColumn<HumanTableView, String> humanWorkInRf;
    @FXML
    private TableColumn<HumanTableView, String> humanWorkNotRf;
    @FXML
    private TableColumn<HumanTableView, String> humanSecondJob;
    @FXML
    private TableColumn<HumanTableView, String> humanLookingForJob;
    @FXML
    private TableColumn<HumanTableView, String> humanNear2Weeks;
    @FXML
    private TableColumn<HumanTableView, String> humanWhyNotLooking;
    @FXML
    private TableColumn<HumanTableView, String> humanLiveSinceBirth;
    @FXML
    private TableColumn<HumanTableView, String> humanYearWhereLive;
    @FXML
    private TableColumn<HumanTableView, String> humanTypePlace;
    @FXML
    private TableColumn<HumanTableView, String> humanChildCount;
    @FXML
    private TableColumn<HumanTableView, String> humanPlaceWhereLive;
    @FXML
    private TableColumn<HumanTableView, String> humanFirstChildBirthdate;
    //endregion

    //region SETs
    public void setPerson(UsersEntity newPerson){
        user = newPerson;
        nameMenu.setText(user.getUserName());
        lastnameMenu.setText(user.getUserLastname());
    }

    private ObservableList<MigrationTableView> setMigrationData(List<dbMigrationtableEntity> list){
        List <MigrationTableView> temp = new ArrayList<>();
        for (dbMigrationtableEntity h : list){
            temp.add(new MigrationTableView(h));
        }
        return FXCollections.observableList(temp);
    }

    private ObservableList<BuildingTableView> setBuildingsData(List<dbBuildingtableEntity> list){
        List <BuildingTableView> temp = new ArrayList<>();
        for (dbBuildingtableEntity h : list){
            temp.add(new BuildingTableView(h));
        }
        return FXCollections.observableList(temp);
    }

    private ObservableList<HumanTableView>  setHumansData(List<dbHumantableEntity> list, List<dbSalariestableEntity> listTwo){
        List <HumanTableView> temp = new ArrayList<>();
        for (dbHumantableEntity h : list){
            int what = checkSalaries(h);
            if (what == -1){
                temp.add(new HumanTableView(h, null));
            } else {
                temp.add(new HumanTableView(h, listTwo.get(what)));
            }
        }
        return FXCollections.observableList(temp);
    }

    private ObservableList<FlatTableView> setFlatsData(List<dbFlattableEntity> list){
        List <FlatTableView> temp = new ArrayList<>();
        for (dbFlattableEntity h : list){
            temp.add(new FlatTableView(h));
        }
        return FXCollections.observableList(temp);
    }

    private ObservableList<HouseholdTableView> setHouseholdsData(List<dbHouseholdtableEntity> list){
        List <HouseholdTableView> temp = new ArrayList<>();
        for (dbHouseholdtableEntity h : list){
            temp.add(new HouseholdTableView(h));
        }
        return FXCollections.observableList(temp);
    }
    //endregion

    //region Initilizers
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL location, ResourceBundle resources) {
        readHostAndPort();
        createOrUpdateLists();
        initializeComboBoxes();

        dataSetsUpdate();

        initializeMigrationTable();
        initializeHouseholdTable();
        initializeFlatTable();
        initializeBuildingTable();
        initializeHumanTable();

        tablesUpdate();
    }

    private void initializeMigrationTable() {
        migrationSex.setCellValueFactory(new PropertyValueFactory<> ("sex"));
        migrationYear.setCellValueFactory(new PropertyValueFactory<> ("year"));
        migrationCountry.setCellValueFactory(new PropertyValueFactory<> ("permanentCountry"));
        migrationTarget.setCellValueFactory(new PropertyValueFactory<> ("purpose"));
        migrationLasting.setCellValueFactory(new PropertyValueFactory<> ("lasting"));
        migrationMotherCountry.setCellValueFactory(new PropertyValueFactory<> ("motherCountry"));
        migrationCitizenship.setCellValueFactory(new PropertyValueFactory<> ("citizenship"));
    }

    private void initializeFlatTable() {
        flatType.setCellValueFactory(new PropertyValueFactory<>("flatType"));
        flatChamberCount.setCellValueFactory(new PropertyValueFactory<>("chamberCount"));
        flatSquare.setCellValueFactory(new PropertyValueFactory<>("square"));
        flatPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        flatRadio.setCellValueFactory(new PropertyValueFactory<>("radio"));
        flatTv.setCellValueFactory(new PropertyValueFactory<>("tv"));

        flatTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && masterDetailCheckBox.isSelected()) {
                householdTableView.setItems(getHouseholdsIds(flatTableView.getSelectionModel().getSelectedItem().getId()));
            }
        });
    }

    private void initializeBuildingTable() {
        homeType.setCellValueFactory(new PropertyValueFactory<>("homeType"));
        dateFound.setCellValueFactory(new PropertyValueFactory<>("dateFound"));
        wallMaterial.setCellValueFactory(new PropertyValueFactory<>("wallMaterial"));
        energy.setCellValueFactory(new PropertyValueFactory<>("energy"));
        stove.setCellValueFactory(new PropertyValueFactory<>("stove"));
        gas.setCellValueFactory(new PropertyValueFactory<>("gas"));
        heat.setCellValueFactory(new PropertyValueFactory<>("heat"));
        water.setCellValueFactory(new PropertyValueFactory<>("water"));
        hotWater.setCellValueFactory(new PropertyValueFactory<>("hotWater"));
        canalisation.setCellValueFactory(new PropertyValueFactory<>("canalisation"));
        closet.setCellValueFactory(new PropertyValueFactory<>("closet"));
        shower.setCellValueFactory(new PropertyValueFactory<>("shower"));
        garbage.setCellValueFactory(new PropertyValueFactory<>("garbage"));
        kitchen.setCellValueFactory(new PropertyValueFactory<>("kitchen"));

        buildingTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && masterDetailCheckBox.isSelected()) {
                flatTableView.setItems(getFlatIds(buildingTableView.getSelectionModel().getSelectedItem().getId()));
            }
        });
    }

    private void initializeHouseholdTable() {
        peopleCount.setCellValueFactory(new PropertyValueFactory<>("peopleCount"));
        chamberCount.setCellValueFactory(new PropertyValueFactory<>("chamberCount"));
        internet.setCellValueFactory(new PropertyValueFactory<>("internet"));

        householdTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && masterDetailCheckBox.isSelected()) {
                humanTableView.setItems(getHumanIds(householdTableView.getSelectionModel().getSelectedItem().getId()));
            }
        });
    }

    private void initializeHumanTable() {
        humanWhoIs.setCellValueFactory(new PropertyValueFactory<>("whoIs"));
        humanSex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        humanBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        humanBirthPlace.setCellValueFactory(new PropertyValueFactory<>("birthPlace"));
        humanMarriage.setCellValueFactory(new PropertyValueFactory<>("marriage"));
        humanCitizenship.setCellValueFactory(new PropertyValueFactory<>("citizenship"));
        humanNationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        humanEducation.setCellValueFactory(new PropertyValueFactory<>("education"));
        humanReadnWrite.setCellValueFactory(new PropertyValueFactory<>("readnWrite"));
        humanScienceGrade.setCellValueFactory(new PropertyValueFactory<>("scienceGrade"));
        humanDoYouStudy.setCellValueFactory(new PropertyValueFactory<>("doYouStudy"));
        humanPrimarySchool.setCellValueFactory(new PropertyValueFactory<>("primarySchool"));
        humanRussian.setCellValueFactory(new PropertyValueFactory<>("russian"));
        humanOtherLang.setCellValueFactory(new PropertyValueFactory<>("otherLang"));
        humanMotherTongue.setCellValueFactory(new PropertyValueFactory<>("motherTongue"));
        humanSalarySources.setCellValueFactory(new PropertyValueFactory<>("salarySources"));
        humanMainSource.setCellValueFactory(new PropertyValueFactory<>("mainSource"));
        humanOctoberSalary.setCellValueFactory(new PropertyValueFactory<>("octoberSalary"));
        humanPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        humanWorkNear.setCellValueFactory(new PropertyValueFactory<>("workNear"));
        humanWorkInRf.setCellValueFactory(new PropertyValueFactory<>("workInRf"));
        humanWorkNotRf.setCellValueFactory(new PropertyValueFactory<>("workNotRf"));
        humanSecondJob.setCellValueFactory(new PropertyValueFactory<>("secondJob"));
        humanLookingForJob.setCellValueFactory(new PropertyValueFactory<>("lookingForJob"));
        humanNear2Weeks.setCellValueFactory(new PropertyValueFactory<>("near2Weeks"));
        humanWhyNotLooking.setCellValueFactory(new PropertyValueFactory<>("whyNotLooking"));
        humanLiveSinceBirth.setCellValueFactory(new PropertyValueFactory<>("liveSinceBirth"));
        humanYearWhereLive.setCellValueFactory(new PropertyValueFactory<>("yearWhereLive"));
        humanPlaceWhereLive.setCellValueFactory(new PropertyValueFactory<>("placeWhereLive"));
        humanTypePlace.setCellValueFactory(new PropertyValueFactory<>("typePlace"));
        humanChildCount.setCellValueFactory(new PropertyValueFactory<>("childCount"));
        humanFirstChildBirthdate.setCellValueFactory(new PropertyValueFactory<>("firstChildBirthdate"));

        humanTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && masterDetailCheckBox.isSelected()) {
                migrationTableView.setItems(getMigrationIds(humanTableView.getSelectionModel().getSelectedItem().getId()));
            }
        });
    }

    private void initializeComboBoxes(){
        tableSelectComboBox.setItems(tablesOptions);
    }
    //endregion

    //region FXML Methods
    @FXML
    private void masterDetailCheckBoxClick(){
        if (!masterDetailCheckBox.isSelected()){
            tablesUpdate();
        }
    }
    @FXML
    private void exitMenuClick(){
        Stage stage = (Stage) humanTableView.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void changeUserMenuClick() {
        Stage stage = (Stage) humanTableView.getScene().getWindow();
        try {
            Stage stage1 = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void newHumanButtonClick() {
        int resultId;
        if (householdTableView.getSelectionModel().getSelectedIndex()!=-1) {
            resultId = householdTableView.getSelectionModel().getSelectedItem().getId();
            createNewStage("/views/FormL.fxml", resultId);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Выберите элемент в таблице домохозяйств");
            alert.showAndWait();
        }
    }
    @FXML
    private void newMigratorButtonClick() {
        int resultId;
        if (humanTableView.getSelectionModel().getSelectedIndex()!=-1) {
            resultId = humanTableView.getSelectionModel().getSelectedItem().getId();
            createNewStage("/views/FormP.fxml", resultId);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Выберите элемент в таблице людей");
            alert.showAndWait();

        }
    }
    @FXML
    private void newBuildingButtonClick() {
        createNewStage("/views/FormV.fxml", 0);
    }
    @FXML
    private void newFlatButtonClick() {
        int resultId;
        if (buildingTableView.getSelectionModel().getSelectedIndex()!=-1) {
            resultId = buildingTableView.getSelectionModel().getSelectedItem().getId();
            createNewStage("/views/FormVPt2.fxml", resultId);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Выберите элемент в таблице зданий");
            alert.showAndWait();

        }
    }
    @FXML
    private void newHouseholdButtonClick() {
        int resultId;
        if (flatTableView.getSelectionModel().getSelectedIndex()!=-1) {
            resultId = flatTableView.getSelectionModel().getSelectedItem().getId();
            createNewStage("/views/FormVPt3.fxml", resultId);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Выберите элемент в таблице квартир");
            alert.showAndWait();
        }
    }
    @FXML
    private void renewButtonClick(){
        createOrUpdateLists();
        dataSetsUpdate();
        tablesUpdate();
        masterDetailCheckBox.setSelected(false);
    }
    @FXML
    private void tableSelectComboBoxOnSelect() throws IOException {
        tablesUpdate();
        firstFilterTextField.setText("");
        int index = tableSelectComboBox.getSelectionModel().getSelectedIndex();
        rowSelectComboBox.setItems(null);
        firstFilterTextField.setDisable(true);
        switch (index){
            case 0:{
                rowSelectComboBox.setItems(buildingsOptions);
                break;
            }
            case 1:{
                rowSelectComboBox.setItems(flatsOptions);
                break;
            }
            case 2:{
                rowSelectComboBox.setItems(householdsOptions);
                break;
            }
            case 3:{
                rowSelectComboBox.setItems(peopleOptions);
                break;
            }
            case 4:{
                rowSelectComboBox.setItems(migratorsOptions);
                break;
            }
            default : {
                throw new IOException("Wrong selection");
            }
        }

    }
    @FXML
    private void rowSelectComboBoxOnSelect(){
        currentTable = tableSelectComboBox.getSelectionModel().getSelectedIndex();
        currentRow = rowSelectComboBox.getSelectionModel().getSelectedIndex();
        firstFilterTextFieldOnAction();
    }
    @FXML
    private void firstFilterTextFieldOnAction(){
        firstFilterTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            switch (currentTable) {
                case 0: {
                    switch (currentRow) {
                        case 0: {
                            createBuildingTypeListener(newValue);
                            break;
                        }
                        case 1: {
                            createBuildingWallListener(newValue);
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (currentRow) {
                        case 0: {
                            createFlatSquareListener(newValue);
                            break;
                        }
                        case 1: {
                            createFlatChamberListener(newValue);
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (currentRow) {
                        case 0: {
                            createHouseholdHumanListener(newValue);
                            break;
                        }
                        case 1: {
                            createHouseholdChamberListener(newValue);
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    switch (currentRow) {
                        case 0: {
                            createHumanDateListener(newValue);
                            break;
                        }
                        case 1: {
                            createHumanBirthplaceListener(newValue);
                            break;
                        }
                        case 2: {
                            createHumanCitizenshipListener(newValue);
                            break;
                        }
                        case 3: {
                            createHumanNationalityListener(newValue);
                            break;
                        }
                        case 4: {
                            createHumanMotherTongueListener(newValue);
                            break;
                        }
                        case 5: {
                            createHumanOtherLanguagesListener(newValue);
                            break;
                        }
                        case 6: {
                            createHumanYearTransistListener(newValue);
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    switch (currentRow) {
                        case 0: {
                            createMigratorYearListener(newValue);
                            break;
                        }
                        case 1: {
                            createMigratorMotherlandListener(newValue);
                            break;
                        }
                        case 2: {
                            createMigratorCurrentCountryListener(newValue);
                            break;
                        }
                        case 3: {
                            createMigratorPurposeListener(newValue);
                            break;
                        }
                    }
                    break;
                }
                default: {

                    break;
                }
            }
        });

        firstFilterTextField.setDisable(false);
    }
    //endregion

    //region Updates
    @SuppressWarnings("unchecked")
    private void createOrUpdateLists(){
        try {
            Socket socket = new Socket(host, port);

            DataOutputStream type = new DataOutputStream(socket.getOutputStream());

            type.writeUTF("database");
            type.flush();

            DataOutputStream string = new DataOutputStream(socket.getOutputStream());

            string.writeUTF("getAll");
            string.flush();
            ObjectInputStream object = new ObjectInputStream(socket.getInputStream());
            buildings = (List<dbBuildingtableEntity>) object.readObject();
            flats = (List<dbFlattableEntity>) object.readObject();
            households = (List<dbHouseholdtableEntity>) object.readObject();
            humans = (List<dbHumantableEntity>) object.readObject();
            migrations = (List<dbMigrationtableEntity>) object.readObject();
            salaries = (List<dbSalariestableEntity>) object.readObject();

            string.close();
            object.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void dataSetsUpdate(){
        migrationsData = setMigrationData(migrations);
        flatsData = setFlatsData(flats);
        buildingsData = setBuildingsData(buildings);
        householdsData = setHouseholdsData(households);
        humansData = setHumansData(humans, salaries);
    }

    private void tablesUpdate(){
        ObservableList<MigrationTableView> migrationCopy = migrationsData;
        ObservableList<BuildingTableView> buildingCopy = buildingsData;
        ObservableList<HouseholdTableView> householdCopy = householdsData;
        ObservableList<FlatTableView> flatCopy = flatsData;
        ObservableList<HumanTableView> humanCopy = humansData;

        migrationTableView.setItems(migrationCopy);
        buildingTableView.setItems(buildingCopy);
        householdTableView.setItems(householdCopy);
        flatTableView.setItems(flatCopy);
        humanTableView.setItems(humanCopy);
    }


    //endregion

    private int checkSalaries(dbHumantableEntity human){
        Integer id = human.getSalarySources();
        if (id==null){
            return -1;
        }
        for (int i = 0; i < salaries.size(); i++){
            if (salaries.get(i).getSalaryId()==id){
                return i;
            }
        }
        return -1;
    }

    private void createNewStage(String path, int resultId) {
        try {
            Stage primaryStage = (Stage) newMigratorButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));

            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            AddingControllers controller = fxmlLoader.getController();
            controller.setResultID(resultId);

            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            createOrUpdateLists();
            dataSetsUpdate();
            tablesUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //region get....Ids для реализации master-detail
    private ObservableList<BuildingTableView> getBuildingIds(int index){
        List<dbBuildingtableEntity> temp = new ArrayList<>();
        for(dbBuildingtableEntity b: buildings){
            if (b.getBuildingId()==index){
                temp.add(b);
            }
        }
        return setBuildingsData(temp);
    }

    private ObservableList<MigrationTableView> getMigrationIds(int index){
        List<dbMigrationtableEntity> temp = new ArrayList<>();
        for(dbMigrationtableEntity b: migrations){
            if (b.getHumanId()==index){
                temp.add(b);
            }
        }
        return setMigrationData(temp);
    }

    private ObservableList<HouseholdTableView> getHouseholdsIds(int index){
        List<dbHouseholdtableEntity> temp = new ArrayList<>();
        for(dbHouseholdtableEntity b: households){
            if (b.getFlatId()==index){
                temp.add(b);
            }
        }
        return setHouseholdsData(temp);
    }

    private ObservableList<FlatTableView> getFlatIds(int index){
        List<dbFlattableEntity> temp = new ArrayList<>();
        for(dbFlattableEntity b: flats){
            if (b.getBuildingId()==index){
                temp.add(b);
            }
        }
        return setFlatsData(temp);
    }

    private ObservableList<HumanTableView> getHumanIds(int index){
        List<dbHumantableEntity> temp = new ArrayList<>();
        List<dbSalariestableEntity> tempTwo = new ArrayList<>();
        for(int i =0; i<humans.size();i++){
            if (humans.get(i).getHouseholdId() == index){
                temp.add(humans.get(i));
                tempTwo.add(salaries.get(i));
            }
        }
        return setHumansData(temp, tempTwo);
    }
    //endregion
    private ObservableList list;

    @SuppressWarnings("unchecked")
    private boolean renewFilterBuildings(String newValue, TableView tableView, ObservableList tableData){
        list = FXCollections.observableArrayList();
        dataSetsUpdate();

        if (newValue.equals("")){
            dataSetsUpdate();
            tableView.getItems().clear();
            tableView.setItems(tableData);
            return true;
        } else {
            return false;
        }
    }

    private void createBuildingTypeListener(String newValue){
        if (renewFilterBuildings(newValue, buildingTableView, buildingsData)){
            return;
        }

        for (BuildingTableView x: buildingsData){
            if(x.getHomeType().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        buildingTableView.getItems().clear();
        buildingTableView.setItems(list);
    }

    private void createBuildingWallListener(String newValue){
        if (renewFilterBuildings(newValue, buildingTableView, buildingsData)){
            return;
        }

        for (BuildingTableView x: buildingsData){
            if(x.getWallMaterial().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        buildingTableView.getItems().clear();
        buildingTableView.setItems(list);
    }

    private void createFlatSquareListener(String newValue){
        if (renewFilterBuildings(newValue, flatTableView, flatsData)){
            return;
        }

        for (FlatTableView x: flatsData){
            if(x.getSquare().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        flatTableView.getItems().clear();
        flatTableView.setItems(list);
    }

    private void createFlatChamberListener(String newValue){
        if (renewFilterBuildings(newValue, flatTableView, flatsData)){
            return;
        }

        for (FlatTableView x: flatsData){
            if(x.getChamberCount().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        flatTableView.getItems().clear();
        flatTableView.setItems(list);
    }

    private void createHouseholdHumanListener(String newValue){
        if (renewFilterBuildings(newValue, householdTableView, householdsData)){
            return;
        }

        for (HouseholdTableView x: householdsData){
            if(x.getPeopleCount().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        householdTableView.getItems().clear();
        householdTableView.setItems(list);
    }

    private void createHouseholdChamberListener(String newValue){
        if (renewFilterBuildings(newValue, householdTableView, householdsData)){
            return;
        }

        for (HouseholdTableView x: householdsData){
            if(x.getChamberCount().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        householdTableView.getItems().clear();
        householdTableView.setItems(list);
    }

    private void createMigratorYearListener(String newValue){
        if (renewFilterBuildings(newValue, migrationTableView, migrationsData)){
            return;
        }

        for (MigrationTableView x: migrationsData){
            if(x.getYear().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        migrationTableView.getItems().clear();
        migrationTableView.setItems(list);
    }

    private void createMigratorMotherlandListener(String newValue){
        if (renewFilterBuildings(newValue, migrationTableView, migrationsData)){
            return;
        }

        for (MigrationTableView x: migrationsData){
            if(x.getPermanentCountry().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        migrationTableView.getItems().clear();
        migrationTableView.setItems(list);
    }

    private void createMigratorCurrentCountryListener(String newValue){
        if (renewFilterBuildings(newValue, migrationTableView, migrationsData)){
            return;
        }

        for (MigrationTableView x: migrationsData){
            if(x.getMotherCountry().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        migrationTableView.getItems().clear();
        migrationTableView.setItems(list);
    }

    private void createMigratorPurposeListener(String newValue){
        if (renewFilterBuildings(newValue, migrationTableView, migrationsData)){
            return;
        }

        for (MigrationTableView x: migrationsData){
            if(x.getPurpose().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        migrationTableView.getItems().clear();
        migrationTableView.setItems(list);
    }

    private void createHumanDateListener(String newValue){
        if (renewFilterBuildings(newValue, humanTableView, humansData)){
            return;
        }

        for (HumanTableView x: humansData){
            if(x.getBirthDate().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        humanTableView.getItems().clear();
        humanTableView.setItems(list);
    }

    private void createHumanBirthplaceListener(String newValue){
        if (renewFilterBuildings(newValue, humanTableView, humansData)){
            return;
        }

        for (HumanTableView x: humansData){
            if(x.getBirthPlace().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        humanTableView.getItems().clear();
        humanTableView.setItems(list);
    }

    private void createHumanCitizenshipListener(String newValue){
        if (renewFilterBuildings(newValue, humanTableView, humansData)){
            return;
        }

        for (HumanTableView x: humansData){
            if(x.getCitizenship().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        humanTableView.getItems().clear();
        humanTableView.setItems(list);
    }

    private void createHumanNationalityListener(String newValue){
        if (renewFilterBuildings(newValue, humanTableView, humansData)){
            return;
        }

        for (HumanTableView x: humansData){
            if(x.getNationality().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        humanTableView.getItems().clear();
        humanTableView.setItems(list);
    }

    private void createHumanOtherLanguagesListener(String newValue){
        if (renewFilterBuildings(newValue, humanTableView, humansData)){
            return;
        }

        for (HumanTableView x: humansData){
            if(x.getOtherLang().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        humanTableView.getItems().clear();
        humanTableView.setItems(list);
    }

    private void createHumanMotherTongueListener(String newValue){
        if (renewFilterBuildings(newValue, humanTableView, humansData)){
            return;
        }

        for (HumanTableView x: humansData){
            if(x.getMotherTongue().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        humanTableView.getItems().clear();
        humanTableView.setItems(list);
    }

    private void createHumanYearTransistListener(String newValue){
        if (renewFilterBuildings(newValue, humanTableView, humansData)){
            return;
        }

        for (HumanTableView x: humansData){
            if(x.getYearWhereLive().toLowerCase().contains(newValue.toLowerCase())){
                list.add(x);
            }
        }

        humanTableView.getItems().clear();
        humanTableView.setItems(list);
    }
    //TODO: прихуярить множество лисенеров. Тобi пизда
}
