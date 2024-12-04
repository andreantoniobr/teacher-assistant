package id;

public class IdTurma {
    private static int id;

    public static int getId(){
        IdTurma.id++;
        return  IdTurma.id;
    }

    public static void setId(int id){
        if(id > IdTurma.id){
            IdTurma.id = id;
        }
    }
}
