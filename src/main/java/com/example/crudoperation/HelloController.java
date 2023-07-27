package com.example.crudoperation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.*;
import java.io.IOException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    String driver="com.mysql.cj.jdbc.Driver";
    String databaseUrl="jdbc:mysql://localhost:3306/Javafx";
    String userName ="root";
    String password="";
    Connection conn= DriverManager.getConnection(databaseUrl,userName,password);
    int idNo;
    String name;
    int age;
    String mobile;
    String parent;
    String address;
    private double xOffSet=0;
    private double yOffSet=0;
    public HelloController(int idNo, String name, int age, String mobile, String parent, String address) throws SQLException {
        this.idNo = idNo;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.parent = parent;
        this.address = address;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @FXML
    private TableColumn<Student, String> columnAddress;

    @FXML
    private TableColumn<Student, Integer> columnAge;

    @FXML
    private TableColumn<Student, Integer> columnId;

    @FXML
    private TableColumn<Student, String> columnMobile;

    @FXML
    private TableColumn<Student, String> columnName;

    @FXML
    private TableColumn<Student, String> columnParent;
    @FXML
    public TableView<Student> tblView;
    ObservableList<Student> list = FXCollections.observableArrayList();
    @FXML
    private MenuItem mAdd;

    @FXML
    private MenuItem mDelete;

    @FXML
    private MenuItem mExit;

    @FXML
    private MenuItem mHelpAbout;

    @FXML
    private MenuItem mNew;

    @FXML
    private MenuItem mOpen;

    @FXML
    private MenuItem mSave;

    @FXML
    private MenuItem mShowWelcomePage;

    @FXML
    private MenuItem mUpdate;

    @FXML
    private MenuItem mLogout;

    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtIdSerach;
    @FXML
    public void getTableData(MouseEvent event) {
        try {
            Student std=tblView.getSelectionModel().getSelectedItem();
            idNo=std.getId();
            name=std.getName();
            age=std.getAge();
            mobile=std.getMobile();
            parent=std.getParent();
            address=std.getAddress();
        }
        catch (Exception ex){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(null);
            a.setContentText(ex.getMessage());
            a.showAndWait();
            System.out.println(ex.getMessage());
        }
    }
    public void delete(){
        try {
            if (idNo==0){
                Alert a=new Alert(Alert.AlertType.WARNING,"Please choose a person to delete..");
                a.setHeaderText(null);
                a.setTitle("Degniin");
                a.showAndWait();
            }
            else {
                Alert alertDialog=new Alert(

                        Alert.AlertType.CONFIRMATION,"Are you sure you want to delete this " +idNo + " ?"
                        ,ButtonType.YES, ButtonType.NO
                );
                alertDialog.setTitle("Hubin");
                alertDialog.setHeaderText(null);
                alertDialog.showAndWait();
                if (alertDialog.getResult()==ButtonType.NO){
                }
                else {
                    try {
                        Statement st=conn.createStatement();
                        String sql="DELETE FROM STUDENT WHERE ID ='"+idNo+"'";
                        st.executeUpdate(sql);
                        Alert al=new Alert(Alert.AlertType.INFORMATION);
                        al.setContentText("Your Deleted is successful");
                        al.show();
                        getData();
                    }
                    catch (Exception ex){
                        Alert a=new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setHeaderText(null);
                        a.setContentText(ex.getMessage());
                        a.showAndWait();
                        System.out.println(ex.getMessage());
                    }
                }

            }
        }
        catch (Exception ex){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(null);
            a.setContentText(ex.getMessage());
            a.showAndWait();
            System.out.println(ex.getMessage());
        }


    }
    public HelloController() throws SQLException {
    }
    public void exit(ActionEvent event) throws IOException {
       try{
           System.exit(0);
//           Parent root = FXMLLoader.load(getClass().getResource("Login-view.fxml"));
//           Stage st=new Stage();
//           Scene scene=new Scene(root);
//           st.setScene(scene);
//           st.setTitle("Login Student Management System");
//           st.show();
//           ((Node)(event.getSource())).getScene().getWindow().hide();
       }
       catch (Exception ex){
           System.out.println(ex.getMessage());
       }
    }
    public void add(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("Add-view.fxml"));
            Stage st=new Stage();
            Scene scene=new Scene(root);
            st.setScene(scene);
            st.setTitle("Register Student");
            st.initStyle(StageStyle.UNDECORATED);
            st.show();
            scene.getStylesheets().getClass().getResource("Add.css");
//            ((Node)(event.getSource())).getScene().getWindow().hide();

    }
    public void update() throws IOException {
        try {
            if (idNo==0){
                Alert a=new Alert(Alert.AlertType.WARNING,"Please choose a person to update..");
                a.setHeaderText(null);
                a.setTitle("Degniin");
                a.showAndWait();
            }
            else {
                Student std=tblView.getSelectionModel().getSelectedItem();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Add-view.fxml"));
                Parent root = loader.load();
                AddViewController contr=(AddViewController) loader.getController();
                contr.btnAdd.setText("Update");
                contr.lblStdInfo.setText("Update Student");
//            contr.txtid.cancelEdit();
                contr.inFlatUi(std);
                Stage st=new Stage();
                Scene scene=new Scene(root);
                st.setScene(scene);
                st.setTitle("Edit Student");
                st.initStyle(StageStyle.UNDECORATED);
                st.show();
                scene.getStylesheets().getClass().getResource("Add.css");
            }

        }
        catch (Exception ex){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(null);
            a.setContentText(ex.getMessage());
            a.showAndWait();
            System.out.println(ex.getMessage());
        }

    }

    public void aboutSystem() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AboutSystem-view.fxml"));
        Stage st=new Stage();
        Scene scene=new Scene(root);
        st.setScene(scene);
        st.setTitle("About System");
        st.show();
    }
    public void showWelcomePage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WelcomePage-view.fxml"));
        Stage st=new Stage();
        Scene scene=new Scene(root);
        st.setScene(scene);
        st.setTitle("Welcome Page");
        st.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            getData();
        }
        catch (Exception ex){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(null);
            a.setContentText(ex.getMessage());
            a.showAndWait();
            System.out.println(ex.getMessage());
        }
    }
    public void getData(){
        try {
            tblView.getItems().clear();
            tblView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            columnId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
            columnName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
            columnAge.setCellValueFactory(new PropertyValueFactory<Student,Integer>("age"));
            columnMobile.setCellValueFactory(new PropertyValueFactory<Student,String>("mobile"));
            columnParent.setCellValueFactory(new PropertyValueFactory<Student,String>("parent"));
            columnAddress.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
            Statement st=conn.createStatement();
            String sql ="SELECT * FROM STUDENT";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                list.addAll(new Student(rs.getInt("id") , rs.getString("name") , rs.getInt("age") , rs.getString("mobile") , rs.getString("parent") , rs.getString("address")));
            }
            tblView.setItems(list);
        }
        catch (Exception ex){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(null);
            a.setContentText(ex.getMessage());
            a.showAndWait();
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    public void refresh(ActionEvent event) {
        try{
            txtIdSerach.setText("");
            getData();
        }
        catch (Exception ex){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(null);
            a.setContentText(ex.getMessage());
            a.showAndWait();
            System.out.println(ex.getMessage());
        }

    }
    public void getSearchData(){
        try {
            int id= Integer.parseInt(txtIdSerach.getText());
            tblView.getItems().clear();
            tblView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            columnId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
            columnName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
            columnAge.setCellValueFactory(new PropertyValueFactory<Student,Integer>("age"));
            columnParent.setCellValueFactory(new PropertyValueFactory<Student,String>("parent"));
            columnAddress.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
            Statement st=conn.createStatement();
            String sql ="SELECT * FROM STUDENT WHERE ID = '"+id+"'";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                list.addAll(new Student(rs.getInt("id") , rs.getString("name") , rs.getInt("age") , rs.getString("mobile") , rs.getString("parent") , rs.getString("address")));
            }
            tblView.setItems(list);
        }
        catch (Exception ex){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(null);
            a.setContentText(ex.getMessage());
            a.showAndWait();
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    void handle_close(MouseEvent event) throws IOException {
        System.exit(0);
    }
    @FXML
    void logout(ActionEvent event) throws IOException {
       try {
           Parent root = FXMLLoader.load(getClass().getResource("Login-view.fxml"));
           Stage st=new Stage();
           Scene scene=new Scene(root);
           st.setScene(scene);
           st.setTitle("Student Management System");
           root.setOnMousePressed(e->{
               xOffSet=e.getSceneX();
               yOffSet=e.getSceneY();
           });
           root.setOnMouseDragged(e->{
               st.setX(e.getScreenX()-xOffSet);
               st.setY(e.getScreenY()-yOffSet);
           });
           st.initStyle(StageStyle.UNDECORATED);
           st.show();
           ((Node)(event.getSource())).getScene().getWindow().hide();
       }
       catch (Exception ex){
           Alert a=new Alert(Alert.AlertType.ERROR);
           a.setTitle("Error");
           a.setHeaderText(null);
           a.setContentText(ex.getMessage());
           a.showAndWait();
           System.out.println(ex.getMessage());
       }
    }
}