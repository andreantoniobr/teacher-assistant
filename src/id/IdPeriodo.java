package id;

public class IdPeriodo {
    private static int id;

    public static int getId(){
        System.out.println(IdPeriodo.id);
        IdPeriodo.id++;
        return  IdPeriodo.id;
    }
}
