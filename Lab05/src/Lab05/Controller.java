package Lab05;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller {
    @FXML
    private TableView<StudentRecord> tableView;
    @FXML
    private TableColumn<Object, Object> StudentID;
    @FXML
    private TableColumn<Object, Object> Assignments;
    @FXML
    private TableColumn<Object, Object> Midterm;
    @FXML
    private TableColumn<Object, Object> FinalExam;
    @FXML
    private TableColumn<Object, Object> FinalMark;
    @FXML
    private TableColumn<Object, Object> LetterGrade;

    private TableView<StudentRecord> people;

    @FXML
    public void initialize(){
        StudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        Assignments.setCellValueFactory(new PropertyValueFactory<>("Assignments"));
        Midterm.setCellValueFactory(new PropertyValueFactory<>("Midterm"));
        FinalExam.setCellValueFactory(new PropertyValueFactory<>("FinalExam"));
        FinalMark.setCellValueFactory(new PropertyValueFactory<>("FinalMark"));
        LetterGrade.setCellValueFactory(new PropertyValueFactory<>("LetterGrade"));

        tableView.setItems(DataSource.getAllMarks());
    }
}
