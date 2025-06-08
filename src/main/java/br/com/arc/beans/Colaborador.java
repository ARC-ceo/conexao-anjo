package br.com.arc.beans;

public class Colaborador {
    private String nome;
    private String tipo;
    private String telefone;

    public Colaborador() {
        super();
    }

    public Colaborador(String nome, String tipo, String telefone) {
        super();
        this.nome = nome;
        this.tipo = tipo;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
