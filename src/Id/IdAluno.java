package Id;

public class IdAluno {
    private static int id;

    public static int getId(){
        IdAluno.id++;
        return  IdAluno.id;
    }
}
