package ec.edu.ista.marlon.appdesk_consumoapi;

import ec.edu.ista.marlon.appdesk_consumoapi.conexion.Conexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
        Conexion con= new Conexion();

        con.setModulo("lista");
        con.setEndPoint("listar");
        con.setMetodo("GET");

        con.conexcion();

        if (con.getResponseCode()!=200){
            //throw new RuntimeException("Error ocurrido"+ con.getResponseCode());
            System.out.println("ERROR "+con.getResponseCode());
        }else{
            System.out.println("A");
            StringBuilder stringBuilder= new StringBuilder();
            Scanner scanner= null;
            try {
                scanner = new Scanner(con.getUrl().openStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            while (scanner.hasNext()){
                System.out.println("B");
                stringBuilder.append(scanner.nextLine());
            }
        }

        //launch();
    }
}