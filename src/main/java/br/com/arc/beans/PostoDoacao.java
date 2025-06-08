package br.com.arc.beans;

public class PostoDoacao {
    private int id;
    private String nome;
    private String descricao;
    private String telefone;
    private Localidade localidade;

    public PostoDoacao() {
        super();
    }

    public PostoDoacao(int id, String nome, String descricao, String telefone, Localidade localidade) {
        super();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.telefone = telefone;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
