package tableview;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class FXMLDocumentController implements Initializable {
    

    @FXML
    private TableView<users> table_users;

    @FXML
    private TableColumn<users, Integer> col_id;

    @FXML
    private TableColumn<users, String> col_username;

    @FXML
    private TableColumn<users, String> col_password;

    @FXML
    private TableColumn<users, String> col_email;

    @FXML
    private TableColumn<users, String> col_type;
    
    ObservableList<users> listM;
    ObservableList<users> dataList;
    
   
    
    int index = -1;
    
    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void UpdateTable(){
        listM = mysqlconnect.getDatausers();
        table_users.setItems(listM);
        
        col_id.setCellValueFactory(new PropertyValueFactory<users,Integer>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
        col_password.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
        col_email.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
        col_type.setCellValueFactory(new PropertyValueFactory<users,String>("type"));
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    UpdateTable();
    } 
}
