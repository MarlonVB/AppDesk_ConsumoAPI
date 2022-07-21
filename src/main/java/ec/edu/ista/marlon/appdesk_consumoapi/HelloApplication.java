package ec.edu.ista.marlon.appdesk_consumoapi;

import ec.edu.ista.marlon.appdesk_consumoapi.conexion.Conexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) throws IOException {
        Conexion conexion= new Conexion();

        conexion.setModulo("lista");
        conexion.setEndPoint("listar");
        conexion.setMetodo("GET");

        HttpURLConnection con= conexion.conexcion();

        if (conexion.getResponseCode() != 200) {
            throw new RuntimeException("Error: "
                    + conexion.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output= br.readLine();
        System.out.println(output);
        /*while ((output = br.readLine()) != null) {
            System.out.println(output);
        }*/

        JSONObject jsonObject = new JSONObject(output);
        System.out.println("OBJECT : "+jsonObject.toString());

        con.disconnect();

        //launch();
    }
}