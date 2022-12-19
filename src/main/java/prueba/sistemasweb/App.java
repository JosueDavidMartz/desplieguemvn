package prueba.sistemasweb;

import static spark.Spark.*;
import com.google.gson.*;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Gson gson = new Gson();
    public static void main( String[] args )
    {
        //aquí va el cors??

        port(80);
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            System.out.println(accessControlRequestHeaders);
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            System.out.println(accessControlRequestMethod); 
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        
        before((req, res)-> res.header("Access-Control-Allow-Origin", "*")); 
        before((req, res)-> res.type("application/json"));
        post("/imprimir", (req, resp) -> gson.toJson(DAO.dameGatos()));


        post("/agregargato", (req, res) -> {
            System.out.print("Ingresé al post en App.java");
            String datosGato = req.body();
            Gato u = gson.fromJson(datosGato, Gato.class);  
            return DAO.agregarGato(u);
        });
        post("/eliminargato", (req, res) -> {
            String datosGato = req.body();
            Gato u = gson.fromJson(datosGato, Gato.class);
            // usuarios.put(u.getId(), u);
            // return "listo se ingreso el usuario "+u.getId();
            return DAO.eliminarGato(u);
        });

        post("/modificargato", (req, res) -> {
            String datosGato = req.body();
            Gato u = gson.fromJson(datosGato, Gato.class);
            // usuarios.put(u.getId(), u);
            // return "listo se ingreso el usuario "+u.getId();
            return DAO.modificarGato(u);
        });
    }
}
