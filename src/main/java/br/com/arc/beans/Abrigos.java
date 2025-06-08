package br.com.arc.beans;

public class Abrigos {
    private int id;
    private String nome;
    private int capacidade;
    private String telefone;
    private Localidade localidade;

    public Abrigos() {
        super();
    }

    public Abrigos(int id, String nome, int capacidade, String telefone) {
        super();
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.telefone = telefone;
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

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }
}

