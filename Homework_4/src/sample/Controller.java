package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  {
    public void menuItemExitAction(ActionEvent actionEvent)
    {
        Platform.exit();
    }

    @FXML
    TextArea filesList;
    @FXML
    TextField textField;


    public void sendMesageEvent(ActionEvent actionEvent) {
        filesList.clear();
        filesList.appendText(textField.getText());
    }
}
