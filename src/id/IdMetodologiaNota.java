package id;

public class IdMetodologiaNota {
    private static int id;

    public static int getId(){
        IdMetodologiaNota.id++;
        return  IdMetodologiaNota.id;
    }
}
