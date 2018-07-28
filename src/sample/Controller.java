package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private ImageView poster;

    @FXML
    private TextArea description;

    @FXML
    private TextField year;

    @FXML
    private TextField country;

    @FXML
    private TextField genres;

    @FXML
    private TextField writer;

    @FXML
    private TextField rating;

    @FXML
    private TextArea Actors;

    @FXML
    private TextField URL;

    @FXML
    private TextField URLYear;

    @FXML
    private TextField names;

    @FXML
    private Button btnSave1;

    KinopoiskParser parser = new KinopoiskParser();

    @FXML
    void PrevFilm(ActionEvent event) {

    }

    @FXML
    void load(ActionEvent event) {
        parser.start(URL.getText());
        writer.setText(parser.writer);
//        Image imagePoster = new Image(parser.URLPoster,poster.getFitWidth(), poster.getFitHeight(), false, false);


        poster.setImage(parser.image);
    }

    @FXML
    void nextFilm(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {

    }

}
