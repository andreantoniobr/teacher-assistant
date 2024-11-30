package id;

public class IdPeriodo {
    private static int id;

    public static int getId(){
        IdPeriodo.id++;
        return  IdPeriodo.id;
    }
}
