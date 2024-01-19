package saki.sakisproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

import static javafx.scene.paint.Color.rgb;

public class Game {
    @FXML
    ImageView flagView;
    @FXML
    Button buttonA, buttonB, buttonC, buttonD, score;
    @FXML
    Label result, questionNumber;
    @FXML
    AnchorPane pan;

    public void exit() throws IOException {
        Stage stage = (Stage) pan.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitHint(""); // no hind
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }


    ArrayList<Image> images = new ArrayList<>();
    ArrayList<String> strings = new ArrayList<>();
    boolean isExit = false;


    private int currentFlag, count = 9, oneClick = 1;


    public void checkA() {
        if (oneClick == 0 || isExit) return;
        oneClick = 0;

        String flag = buttonA.getText();
        if (Objects.equals(flag, strings.get(currentFlag))) {
            String ss = score.getText();
            int k = Integer.parseInt(ss);
            score.setText(Integer.toString(k + 10));
            result.setText("You earn 10 score.");

            buttonA.setBackground(Background.fill(Color.GREEN));
        } else {
            String ss = score.getText();
            int k = Integer.parseInt(ss);
            score.setText(Integer.toString(k - 5));
            result.setText("Flag Name: " + strings.get(currentFlag) + ". You loss 5 score.");

            buttonA.setBackground(Background.fill(Color.RED));
        }
    }

    public void checkB() {
        if (oneClick == 0 || isExit) return;
        oneClick = 0;

        String flag = buttonB.getText();
        if (Objects.equals(flag, strings.get(currentFlag))) {
            String ss = score.getText();
            int k = Integer.parseInt(ss);
            score.setText(Integer.toString(k + 10));
            result.setText("You earn 10 score.");

            buttonB.setBackground(Background.fill(Color.GREEN));
        } else {
            String ss = score.getText();
            int k = Integer.parseInt(ss);
            score.setText(Integer.toString(k - 5));
            result.setText("Flag Name: " + strings.get(currentFlag) + ". You loss 5 score.");

            buttonB.setBackground(Background.fill(Color.RED));
        }
    }


    public void checkC() {
        if (oneClick == 0 || isExit) return;
        oneClick = 0;

        String flag = buttonC.getText();
        if (Objects.equals(flag, strings.get(currentFlag))) {
            String ss = score.getText();
            int k = Integer.parseInt(ss);
            score.setText(Integer.toString(k + 10));
            result.setText("You earn 10 score.");

            buttonC.setBackground(Background.fill(Color.GREEN));
        } else {
            String ss = score.getText();
            int k = Integer.parseInt(ss);
            score.setText(Integer.toString(k - 5));
            result.setText("Flag Name: " + strings.get(currentFlag) + ". You loss 5 score.");

            buttonC.setBackground(Background.fill(Color.RED));
        }
    }


    public void checkD() {
        if (oneClick == 0 || isExit) return;
        oneClick = 0;

        String flag = buttonD.getText();
        if (Objects.equals(flag, strings.get(currentFlag))) {
            String ss = score.getText();
            int k = Integer.parseInt(ss);
            score.setText(Integer.toString(k + 10));
            result.setText("You earn 10 score.");

            buttonD.setBackground(Background.fill(Color.GREEN));
        } else {
            String ss = score.getText();
            int k = Integer.parseInt(ss);
            score.setText(Integer.toString(k - 5));
            result.setText("Flag Name: " + strings.get(currentFlag) + ". You loss 5 score.");

            buttonD.setBackground(Background.fill(Color.RED));
        }
    }

    public void newFlag() {
        if (oneClick == 1 || isExit) return;

        result.setText("");
        oneClick = 1;

        if (count > 0) {
            ArrayList<Integer> option = new ArrayList<>();
            int x = 0;

            for (int i = 0; i < 4; i++) {
                x = (int) (Math.random() * (197124 + i * 7));
                x = x % (255);
                option.add(x);
            }
            Collections.shuffle(option);
            Collections.shuffle(option);

            currentFlag = x;
            flagView.setImage(images.get(x));

            buttonA.setText(strings.get(option.get(0)));
            buttonB.setText(strings.get(option.get(1)));
            buttonC.setText(strings.get(option.get(2)));
            buttonD.setText(strings.get(option.get(3)));
            option.clear();

            count--;
            questionNumber.setText("Question Remain : " + count);


            buttonA.setBackground(Background.fill(rgb(204, 204, 255)));
            buttonB.setBackground(Background.fill(rgb(204, 204, 255)));
            buttonC.setBackground(Background.fill(rgb(204, 204, 255)));
            buttonD.setBackground(Background.fill(rgb(204, 204, 255)));

        } else {
            result.setText("Game is Over");
            isExit = true;
        }

    }


    public void initialize() throws URISyntaxException {

        int t = 1;
        while (t < 256) {
            String s = "flagImage (" + t + ").png";
            Image image = new Image(s);
            images.add(t - 1, image);
            t++;
        }

        File file = new File(getClass().getResource("flag.txt").toURI());
        if (file.exists()) {
            Scanner ss = null;
            try {
                ss = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }


            while (true) {
                assert ss != null;
                if (!ss.hasNextLine()) break;
                strings.add(ss.nextLine());
            }

            buttonA.setBackground(Background.fill(rgb(204, 204, 255)));
            buttonB.setBackground(Background.fill(rgb(204, 204, 255)));
            buttonC.setBackground(Background.fill(rgb(204, 204, 255)));
            buttonD.setBackground(Background.fill(rgb(204, 204, 255)));


            ArrayList<Integer> option = new ArrayList<>();
            int x = 0;

            for (int i = 0; i < 4; i++) {
                x = (int) (Math.random() * (197124 + i * 7));
                x = x % 255;
                option.add(x);
            }
            Collections.shuffle(option);
            Collections.shuffle(option);

            currentFlag = x;
            flagView.setImage(images.get(x));

            buttonA.setText(strings.get(option.get(0)));
            buttonB.setText(strings.get(option.get(1)));
            buttonC.setText(strings.get(option.get(2)));
            buttonD.setText(strings.get(option.get(3)));
            option.clear();
        }
//        Testing test = new Testing(flagView,labelA,labelB);
    }
}