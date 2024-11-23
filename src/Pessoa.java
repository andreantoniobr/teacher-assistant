public class Pessoa {
    private String id;
    private String nome;
    private String email;
    private Perfil perfil;

    public Pessoa(String nome, Perfil perfil) {
        //this.id = id;
        this.nome = nome;
        this.perfil = perfil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        this.email = email;
        return false;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    private boolean validarEmail(String email) {
        return false;
    }
}
