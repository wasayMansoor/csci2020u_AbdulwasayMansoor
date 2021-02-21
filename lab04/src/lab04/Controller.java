package lab04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class Controller {
    //variables
    @FXML
    private Text actiontarget;
    @FXML
    private TextField userNameField;
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneNumberField;

    private String regex = "^\\d{3}-\\d{3}-\\d{4}";

    //Button Output
    @FXML
    public void register(ActionEvent actionEvent) {
        String userName = userNameField.getText();
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();

        System.out.println("User Name: " + userName);
        System.out.println("Full Name: " + fullName);
        System.out.println("Email: " + email);


        if (phoneNumber.matches(regex)){
            System.out.println("Phone Number: " + phoneNumber);
        }else {
            System.out.println("Phone Number Format Should Be 000-000-0000");
        }
    }
}
