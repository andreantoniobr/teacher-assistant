package Id;

public class IdMetodoAvaliativo {
    private static int id;

    public static int getId(){
        IdMetodoAvaliativo.id++;
        return  IdMetodoAvaliativo.id;
    }
}
