package com.example.javafx.camera;

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

public class Camera3D extends Application {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;

    @Override
    public void start(Stage stage) {
        Sphere sphere = new Sphere(50);
        Group group = new Group();
        group.getChildren().add(sphere);

        Camera camera = new PerspectiveCamera(true);

        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        camera.translateXProperty().set(0);
        camera.translateYProperty().set(0);
        camera.translateZProperty().set(-500);

        camera.setNearClip(1);
        camera.setFarClip(1000);

        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case W:
                    camera.translateZProperty().set(camera.getTranslateZ() + 50);
                    break;
                case S:
                    camera.translateZProperty().set(camera.getTranslateZ() - 50);
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