package id;

public class IdAluno {
    private static int id;

    public static int getId(){
        IdAluno.id++;
        return  IdAluno.id;
    }

    public static void setId(int id){
        if(id > IdAluno.id){
            IdAluno.id = id;
        }
    }
}
