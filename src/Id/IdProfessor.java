package Id;

public class IdProfessor {
    private static int id;

    public static int getId(){
        IdProfessor.id++;
        return  IdProfessor.id;
    }
}
