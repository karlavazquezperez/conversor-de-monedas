import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeHistorial {
    private FileWriter escritura;
    //private Gson gson;

    public GeneradorDeHistorial(String nombreArchivo) throws IOException {
        this.escritura=new FileWriter(nombreArchivo,true);
    }

    public void guardarConversion(String conversion) throws IOException {
        escritura.write(conversion + "\n");
    }

    public void cerrarArchivo() throws IOException {
        if(escritura!=null){
            escritura.close();
        }
    }
}
