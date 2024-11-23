package Id;

public class IdNota {
    private static int id;

    public static int getId(){
        IdNota.id++;
        return  IdNota.id;
    }
}
