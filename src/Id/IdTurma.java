package Id;

public class IdTurma {
    private static int id;

    public static int getId(){
        IdTurma.id++;
        return  IdTurma.id;
    }
}
