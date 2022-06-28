package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane tabPane = FXMLLoader.load(this.getClass().getResource("Principal.fxml"));
        Scene scene = new Scene(tabPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("PlayMusic App");
        primaryStage.show();
    }
}
