package com.example.javafx.sphere;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

import java.io.IOException;

public class DrawSphere extends Application {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;

    @Override
    public void start(Stage stage) throws IOException {
        Sphere sphere = new Sphere(50);
        Group group = new Group();
        group.getChildren().add(sphere);

        Camera camera = new PerspectiveCamera();

        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        sphere.translateXProperty().set(WIDTH / 2);
        sphere.translateYProperty().set(HEIGHT / 2);

        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case W:
                    sphere.translateZProperty().set(sphere.getTranslateZ() + 50);
                    break;
                case S:
                    sphere.translateZProperty().set(sphere.getTranslateZ() - 50);
                    break;
            }
        });

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}