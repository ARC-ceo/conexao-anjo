package br.com.arc.beans;

public class Login {
    private int id;
    private String tipoConta;
    private String email;
    private String senha;

    public Login() {
        super();
    }

    public Login(int id, String tipoConta, String email, String senha) {
        super();
        this.id = id;
        this.tipoConta = tipoConta;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
