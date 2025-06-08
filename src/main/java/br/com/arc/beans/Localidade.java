package br.com.arc.beans;

public class Localidade {
    private int id;
    private String uf;
    private String cidade;

    public Localidade() {
        super();
    }

    public Localidade(int id, String uf, String cidade) {
        super();
        this.id = id;
        this.uf = uf;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
