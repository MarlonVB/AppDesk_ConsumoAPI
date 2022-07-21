package ec.edu.ista.marlon.appdesk_consumoapi.conexion;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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

    public void conexcion(){
        try {
            System.out.println("MODULO "+getModulo());
            System.out.println("ENDPOINT "+getEndPoint());

            setUrl(new URL("http://localhost:9090/"+getModulo()+"/"+getEndPoint()));
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(getMetodo());
            connection.connect();

            setResponseCode(connection.getResponseCode());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
