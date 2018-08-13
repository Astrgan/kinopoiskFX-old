package sample.Logics;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

public class MoonwalkParserFilm {
    public JsonArray jsonArray;
    public List<Film> listFilms;
    File dir;
    Gson gson;

    public MoonwalkParserFilm(String path) {


        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(path) ) );

            gson = new Gson();
            JsonObject jsonObject = gson.fromJson( content, JsonObject.class);

            jsonArray = jsonObject.get("report").getAsJsonObject().get("movies").getAsJsonArray();
//            System.out.println(jsonArray.get(1).getAsJsonObject().get("kinopoisk_id").getAsString());

            Type listType = new TypeToken<List<Film>>() {}.getType();
            listFilms = gson.fromJson(jsonArray, listType);
//            System.out.println(listFilms.get(1).getKinopoisk_id());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void save(){

        try (FileWriter moviJson = new FileWriter("moviJson.json"))
        {
            moviJson.write(gson.toJson(listFilms));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
