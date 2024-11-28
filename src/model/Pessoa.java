package model;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String email;
    private Perfil perfil;

    public Pessoa(int id, String nome, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.perfil = perfil;
    }

    public Pessoa(int id, String nome, String email,Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        /*
        String emailText = email;
        if(email == null || email.isEmpty()){
            emailText = "Sem e-mail Cadastrado.";
        }*/
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
