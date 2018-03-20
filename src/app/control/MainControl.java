package app.control;

import app.model.Computer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * Created by Seong Chee Ken on 16/03/2018.
 * Project Name: PC-Builder.
 */
public class MainControl {
    public StackPane baseStackPane;
    public JFXButton bExit;
    public JFXButton bCompatibility;
    public StackPane secondStack;
    private JFXDialog dialog;

    public void initialize() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/component.fxml"));
        secondStack.getChildren().add(loader.load());
        ComponentControl c = loader.getController();


        bCompatibility.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY){
                FXMLLoader diLoader = new FXMLLoader(getClass().getResource("/app/view/compatibility.fxml"));
                try {
                    dialog = new JFXDialog(baseStackPane, diLoader.load(), JFXDialog.DialogTransition.TOP);
                    CompatibleControl control = diLoader.getController();
                    control.setComputer(c.getComputer());
                    control.call();
                    dialog.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
