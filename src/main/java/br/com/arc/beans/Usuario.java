package br.com.arc.beans;

public class Usuario {
    private int id;
    private String nome;
    private String telefone;
    private int loginId;
    private Localidade localidade;

    public Usuario() {
        super();
    }

    public Usuario(int id, String nome, String telefone, int loginId, Localidade localidade) {
        super();
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.loginId = loginId;
        this.localidade = localidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }
}
