package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main [一个小计算器 A little calculator]
 *
 * @author RunBrick <zhouwei9280@gmail.com>
 * @version 1.0.0
 * @description ""
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("计算器");
        primaryStage.setScene(new Scene(root, 232, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
