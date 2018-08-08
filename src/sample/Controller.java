package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private TextArea actors;

    @FXML
    private TextField URL;

    @FXML
    private TextField URLYear;

    @FXML
    private TextField names;

    @FXML
    private Button btnSave1;

    KinopoiskParserFilm parser = new KinopoiskParserFilm();

    @FXML
    void PrevFilm(ActionEvent event) {

    }

    @FXML
    void load(ActionEvent event) {
        URL.setText("https://www.kinopoisk.ru/film/otryad-samoubiyts-2016-468522/");
        parser.start(URL.getText());
        names.setText(parser.name);
        genres.setText(parser.genres);
        rating.setText(parser.rating);
        year.setText(parser.year);
        country.setText(parser.countries);
        writer.setText(parser.writer);
        description.setText(parser.description);
        actors.setText(parser.actors);





        poster.setImage(parser.image);
    }

    @FXML
    void nextFilm(ActionEvent event) {
        KinopoiskParserListYears listYears = new KinopoiskParserListYears();
        listYears.start();
    }

    @FXML
    void save(ActionEvent event) {

    }

}
