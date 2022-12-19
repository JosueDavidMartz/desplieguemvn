package prueba.sistemasweb;

public class Gato {
    int id;
    String nombre;

    public Gato(String string) {
        this.nombre = string;
    }
    
    public Gato(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
