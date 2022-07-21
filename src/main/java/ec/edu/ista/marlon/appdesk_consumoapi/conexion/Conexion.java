package ec.edu.ista.marlon.appdesk_consumoapi.conexion;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.json.JSONObject;

public class Conexion {
    private String endPoint;
    private String modulo;
    private String metodo;

    private int responseCode;

    private URL url;

    public Conexion(String endPoint, String modulo, String metodo) {
        this.endPoint = endPoint;
        this.modulo = modulo;
        this.metodo = metodo;
    }

    public Conexion() {

    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getResponseCode() {
        return responseCode;
    }

    private void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public URL getUrl() {
        return url;
    }

    private void setUrl(URL url) {
        this.url = url;
    }

    public HttpURLConnection conexcion(){
        try {
            System.out.println("MODULO "+getModulo());
            System.out.println("ENDPOINT "+getEndPoint());

            //setUrl(new URL("http://localhost:9090/"+getModulo()+"/"+getEndPoint()));
            setUrl(new URL("https://pokeapi.co/api/v2/pokemon/ditto"));
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(getMetodo());
            connection.connect();

            setResponseCode(connection.getResponseCode());

            return connection;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void listarJson(){
        String urlstr="https://pokeapi.co/api/v2/pokemon/ditto";
        try{
            URL url = new  URL(urlstr);
            InputStream is = url.openStream();
            JsonReader rdr=Json.createReader(new InputStreamReader(is, "UTF-8"));
            JsonArray results= rdr.readArray();
            Iterator<?> iterator = results.iterator();
            while(iterator.hasNext()){
                JsonObject jsonObject = (JsonObject) iterator.next();
                System.out.println("JSON-> El id es: "+jsonObject.get("id").toString().toUpperCase()+", el nombre es: "+jsonObject.get("nombre").toString().toUpperCase()+", el puesto es: "+jsonObject.get("puesto").toString().toUpperCase());
            }
        }catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

}
