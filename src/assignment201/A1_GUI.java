package assignment201;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

 

public class A1_GUI extends Application {

 
/*
    private static ArrayList<A1_Model> presidents = new ArrayList<>();
    private ComboBox<String> presidentBox;
    private Label nameLabel, surnameLabel, lengthLabel;
    private TextField lengthValueField;
    private ImageView presidentImageView;
    private Button saveButton;
    private SimpleIntegerProperty presidentIndex; */

 
	private static ArrayList<A1_Model> presidents = new ArrayList<>();
	private ComboBox<String> presidentBox;
	private Label surnameLabel, dobLabel, lengthLabel, nameLabel;
	private TextField lengthValueField;
	private ImageView presidentImageView;
	private Button saveButton;
	private SimpleIntegerProperty presidentIndex;
	
	
    public static void main(String[] args) {
        loadObjectsFromCSV();
        launch(args); // Launch the JavaFX application
    }

 

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Female Best Presidents");

 

        // Increase the size of the primary stage
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

 

        // Initialize UI elements
        presidentBox = new ComboBox<>();
        nameLabel = new Label("Name: ");
        surnameLabel = new Label("Surname: ");
        dobLabel = new Label ("Birthyear: ");
        lengthLabel = new Label("Length of presidency: ");
        lengthValueField = new TextField();
        presidentImageView = new ImageView();
        presidentImageView.setFitWidth(200); // Limit the image width
        presidentImageView.setFitHeight(200); // Limit the image height
        saveButton = new Button("Save");
       // saveButton.setOnAction(e -> saveMarketValue());
        presidentIndex = new SimpleIntegerProperty(0);

 

        // Populate the ComboBox with player names
        for (A1_Model name : presidents) {
            presidentBox.getItems().add(name.getName());
        }

 

        // Set up initial player information
        showPlayerInfo(0);

 

        // Handle ComboBox selection changes
        presidentBox.setOnAction(e -> showPlayerInfo(presidentBox.getSelectionModel().getSelectedIndex()));

 

        // Create navigation buttons
        Button prevButton = new Button("Previous");
        Button nextButton = new Button("Next");
// test dini mueter
 

        prevButton.setOnAction(e -> showPlayerInfo(presidentIndex.get() - 1));
        nextButton.setOnAction(e -> showPlayerInfo(presidentIndex.get() + 1));

 

        // Create a layout
        BorderPane root = new BorderPane();
        HBox topBox = new HBox(presidentBox);
        HBox buttonBox = new HBox(prevButton, nextButton, saveButton);
        root.setTop(topBox);
        VBox playerInfoBox = new VBox(nameLabel, surnameLabel, dobLabel, lengthValueField);
        HBox playerBox = new HBox(presidentImageView);
        root.setLeft(playerInfoBox);
        root.setCenter(playerBox);
        root.setBottom(buttonBox);

 

        // Create a scene and set it on the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);



        // Show the stage
        primaryStage.show();
    }



    public void showPlayerInfo(int index) {
        if (index >= 0 && index < presidents.size()) {
            A1_Model name = presidents.get(index);
            nameLabel.setText("Name: " + name.getName());
            surnameLabel.setText("Surname: " + name.getSurname());
            lengthLabel.setText("Market Value: ");
            //lengthValueField.setText(String.valueOf(name.getMarketValue())); // Set the text in the TextField

 

            // Load and display player's image (replace with your image loading code)
            Image presidentImage = new Image(name.getPicture());
            presidentImageView.setImage(presidentImage);

 

            presidentBox.getSelectionModel().select(index);
            presidentIndex.set(index);
        }
    }

 /*

    public void saveMarketValue() {
        int index = presidentIndex.get();
        if (index >= 0 && index < presidents.size()) {
            A1_Model player = presidents.get(index);
            try {
                int newLength = Integer.parseInt(lengthValueField.getText());
                player.setMarketValue(newLength);
                saveToCSV();
            } catch (NumberFormatException e) {
                // Handle invalid input
                lengthValueField.setText(String.valueOf(player.getMarketValue()));
            }
        }
    }

 */

    public static void loadObjectsFromCSV() {
        // Implement CSV loading logic here
    try {
		Scanner scan = new Scanner(new File ("C:\\Users\\dombt\\eclipse-workspace\\Programming1\\src\\objects.csv"));
		scan.nextLine();
	while (scan.hasNext()) {
		String lineString = scan.nextLine();
		String [] words = lineString.split(";");
		
		A1_Model a = new A1_Model (words[0], words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3]), words[4]);
		
		//System.out.println(scan.nextLine());
		System.out.println(a);
	}
	
		
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

    public void saveObjectsToCSV(String filename) {
        // Implement CSV saving logic here
    }

   /* public ArrayList<A1_Input> getObjects() {
        return objects;
    }
*/
    public void updateObject(A1_Input updatedObject) {
        // Implement object update logic here
}

}
 
/*
    public static void saveToCSV() {
        try (FileWriter writer = new FileWriter("C:\\Users\\franc\\eclipse-workspace\\HelloWorld\\src\\footballPlayers\\footballPlayers.csv")) {
            writer.write("name;surname;marketValue;picture\n");
            for (A1_Model player : presidents) {
                writer.write(player.getName() + ";" + player.getSurname() + ";" + player.getMarketValue() + ";" + player.getPicture() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
