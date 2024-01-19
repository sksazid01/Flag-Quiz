package saki.sakisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    public void exit(ActionEvent e) {
        System.exit(0);
    }

    public void StartNow(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitHint(""); // no hind
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

//    @FXML
//    AnchorPane anchorPane;
//    public void initialize(){
//        Image image=new Image("spain flag korea flag vietnam flag russian flag canadian flag.jpg");
//        ImageView imageView=new ImageView(image);
//        anchorPane.getChildren().add(imageView);
//    }
}