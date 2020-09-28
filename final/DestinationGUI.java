/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 7        Summer 2020  *
 *                                                          *
 *  Class Name:  Java Summer 2020                           *
 *                                                          *
 *  Programmer:  Adam Page z1859276                         *
 *  Purpose:  Destination GUI                               *
 *                                                          *
 ************************************************************/
import java.io.File;
import java.util.Optional;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//Class that represents the main GUI for the redeemer app
public class DestinationGUI extends Application {

	//Fields of the class
	//Main model and array of month names
	private MileRedeemer redeemer;
	private String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	//-- LEFT PANE
	private ListView<String> lstDest;
	private TextField txtNormalMiles;
	private TextField txtSupersaverMiles;
	private TextField txtUpgrade;
	private TextField txtMonths;
	//-- RIGHT PANE
	private TextField txtInputMiles;
	private ComboBox<String> cbMonths;
	private Button btnRedeem;
	private TextArea txtResults;
	private TextField txtRemainingMiles;

	//Start method for app
	public void start(Stage mainStage) throws Exception {
		//First, we start asking for input file using a Dialog Box
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Input File");
		dialog.setHeaderText(null);
		dialog.setContentText("Enter input file name: ");
		//Get answer from user and read the file
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			//We create the MileRedeemer object with given file
			redeemer = new MileRedeemer();
			redeemer.readDestinations(new Scanner(new File(result.get())));
		}

		//We start initializing main pane. We use a BorderPane
		BorderPane main = new BorderPane();

		//Left pane
		//For left pane, we create a GridPane
		GridPane left = new GridPane();
		left.setStyle("-fx-background-color: #659658;");
		//We init all the needed components to add them to the pane
		//List and scroll pane for it for city names
		lstDest = new ListView<String>(FXCollections.observableArrayList(redeemer.getCityNames()));
		lstDest.setPrefWidth(300);
		ScrollPane scroll = new ScrollPane(lstDest);
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll.setPrefSize(300, 300);
		left.add(scroll, 0, 0, 3, 1);

		//Labels and txtFields for information
		Label lblNormalMiles = new Label("Normal Miles");
		left.add(lblNormalMiles, 0, 1, 1, 1);
		txtNormalMiles = new TextField("");
		txtNormalMiles.setEditable(false);
		left.add(txtNormalMiles, 1, 1, 2, 1);

		Label lblSupersaverMiles = new Label("Supersaver Miles");
		left.add(lblSupersaverMiles, 0, 2, 1, 1);
		txtSupersaverMiles = new TextField("");
		txtSupersaverMiles.setEditable(false);
		left.add(txtSupersaverMiles, 1, 2, 2, 1);

		Label lblUpgrade = new Label("Upgrade cost");
		left.add(lblUpgrade, 0, 3, 1, 1);
		txtUpgrade = new TextField("");
		txtUpgrade.setEditable(false);
		left.add(txtUpgrade, 1, 3, 2, 1);

		Label lblMonths = new Label("Supersaver Dates");
		left.add(lblMonths, 0, 4, 1, 1);
		txtMonths = new TextField("");
		txtMonths.setEditable(false);
		left.add(txtMonths, 1, 4, 2, 1);

		//Now, we handle the Action event on the List to update fields as needed
		lstDest.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//First, we get the selected index
				int index = lstDest.getSelectionModel().getSelectedIndex();
				//If valid index, we update txt fields
				if(index >= 0 && index < redeemer.destinationList.size()) {
					//Loop to find the city with given name
					String name = redeemer.getCityNames()[index];
					for(Destination dest : redeemer.destinationList) {
						if(dest.getCity().equals(name)) {
							//Now, we show its info
							txtNormalMiles.setText(dest.getNormalMiles()+"");
							txtSupersaverMiles.setText(dest.getCheapMiles()+"");
							txtUpgrade.setText(dest.getAdditionalMile()+"");
							//For months, we get them using the month array and knowing that, given the 0-based index array,
							//we use "month-1"
							txtMonths.setText(months[dest.getbeginMonth()-1]+"-"+months[dest.getendMonth()-1]);
							break;
						}
					}
				}
			}
		});

		//Set pref size for pane and add it to left of main
		left.setPrefSize(300, 400);
		main.setLeft(left);

		//Right pane
		//For right pane, we create a GridPane
		GridPane right = new GridPane();
		right.setStyle("-fx-background-color: #5a5aee;");
		right.setHgap(10);
		//We init all the needed components to add them to the pane
		//Labels and input fields to look for
		Label lblInputMiles = new Label("Enter your miles");
		right.add(lblInputMiles, 0, 0);
		txtInputMiles = new TextField("");
		right.add(txtInputMiles, 1, 0);

		Label lblDepMonth = new Label("Select month of departure");
		right.add(lblDepMonth, 0, 1);
		//Combo box for months
		cbMonths = new ComboBox<String>(FXCollections.observableArrayList(months));
		cbMonths.setStyle("-fx-pref-width: 200;");
		right.add(cbMonths, 1, 1);
		
		btnRedeem = new Button("Redeem miles");
		btnRedeem.setPrefWidth(400);
		right.add(btnRedeem, 0, 2, 2, 1);

		txtResults = new TextArea("");
		txtResults.setPrefSize(400, 300);
		txtResults.setEditable(false);
		right.add(txtResults, 0, 3, 2, 1);

		Label lblRemaining = new Label("Total remaining miles");
		right.add(lblRemaining, 0, 4);
		txtRemainingMiles = new TextField("");
		txtRemainingMiles.setEditable(false);
		right.add(txtRemainingMiles, 1, 4);
		
		//Now, we handle the Action event on the Button to update fields as needed
		btnRedeem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//We use try-catch in case the inputs are not valid (month not selected or non-positive integer for miles)
				try {
					int miles = Integer.parseInt(txtInputMiles.getText());
					if(miles < 0) {
						throw new Exception("Positive number of miles needed.");
					}
					int index = cbMonths.getSelectionModel().getSelectedIndex();
					//We call for results for given inputs
					String[] res = redeemer.reedemMiles(miles, index+1);
					//Finally, we show the info on text area and text field for rem miles
					txtResults.setText("");
					for(String str : res) {
						if(str != null) {
							txtResults.setText(txtResults.getText()+"\n"+str);
						}
					}
					txtRemainingMiles.setText(redeemer.getRemainingMiles()+"");
				} catch (Exception e) {
					//If any Errors, we just show a message
					txtResults.setText("Ivalid inputs: "+e.getMessage());
					txtRemainingMiles.setText("");
				}
			}
		});

		//Set pref size for pane and add it to right of main
		right.setPrefSize(400, 400);
		main.setRight(right);

		//Finally, set scene for main pane and show it
		mainStage.setScene(new Scene(main));
		mainStage.setTitle("Mile Redeemer App");
		mainStage.setResizable(false);
		mainStage.setWidth(700);
		mainStage.setHeight(400);
		mainStage.show();
	}

	//Main method to launch the app
	public static void main(String[] args) {
		launch(args);
	}
}
