package com.example.javafx.rotation;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class Rotation3D extends Application {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;

    @Override
    public void start(Stage stage) {
        Box box = new Box(100, 20, 50);
        SmartGroup group = new SmartGroup();
        group.getChildren().add(box);

        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        group.translateXProperty().set(WIDTH/2);
        group.translateYProperty().set(HEIGHT/2);
        group.translateZProperty().set(-700);

//        Transform transform = new Rotate(65, new Point3D(0, 1, 0));
//        box.getTransforms().add(transform);

        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case W:
                    group.translateZProperty().set(group.getTranslateZ() + 50);
                    break;
                case S:
                    group.translateZProperty().set(group.getTranslateZ() - 50);
                    break;
                case F:
                    group.rotateByX(10);
                    break;
                case J:
                    group.rotateByX(-10);
                    break;
                case U:
                    group.rotateByY(10);
                    break;
                case D:
                    group.rotateByY(-10);
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

    class SmartGroup extends Group {
        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int angle) {
            r = new Rotate(angle, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().add(t);
        }

        void rotateByY(int angle) {
            r = new Rotate(angle, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().add(t);
        }
    }
}