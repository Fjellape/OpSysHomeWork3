package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton firstRadioButtom;

    @FXML
    private RadioButton secondRadioButtom;

    @FXML
    private RadioButton thirdRadioButtom;

    @FXML
    private RadioButton myOwnRadioButtom;

    @FXML
    private Label firstTextLabel;

    @FXML
    private Label secondTextLabel;

    @FXML
    private Label thirdTextLabel;

    @FXML
    private TextField myOwnTextlabel;

    @FXML
    private Button algFcfs;

    @FXML
    private Button algSstf;

    @FXML
    private Button algScan;

    @FXML
    private Button algLook;

    @FXML
    private Button algClean;

    @FXML
    private ToggleGroup tgRadionButton;

    @FXML
    private TextArea tableInformation;

    @FXML
    void initialize() {


        //Algorithm FCFS
        algFcfs.setOnAction(event -> {
            System.out.println("You just pressed button FCFS");
            if (tgRadionButton.getSelectedToggle() != null ) {
                if (tgRadionButton.getSelectedToggle() == firstRadioButtom) {
                    tableInformation.setText(firstTextLabel.getText());
                }
                else if (tgRadionButton.getSelectedToggle() == secondRadioButtom){
                    tableInformation.setText(secondTextLabel.getText());
                }

                else if (tgRadionButton.getSelectedToggle() == thirdRadioButtom) {
                    tableInformation.setText(thirdTextLabel.getText());
                }

                else if (tgRadionButton.getSelectedToggle() == myOwnRadioButtom) {
                    //delete empty spaces
                    String myOwnText = myOwnTextlabel.getText().trim();

                   if (validateField(myOwnText)) {
                       try {
                           System.out.println("whats uppppppppp");
                           tableInformation.setText(myOwnText);
                       } catch (Exception e1) {
                           System.err.println(e1);
                       }
                   }

                }
            }



        } );



        //Button clear input from Label(top right)
        algClean.setOnAction(event -> {
            tableInformation.clear();
            myOwnTextlabel.clear();
        });




    }

    private boolean validateField(String myOwnText) {
        if (myOwnTextlabel.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText("Palun sisestage muster");
            alert.showAndWait();

            return false;
        }
        tableInformation.setText(myOwnText);
        return false;
    }
}
