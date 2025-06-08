package br.com.arc.beans;

public class ItemDoado {
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private CategoriaDoacao categoria;
    private int colabId;

    public ItemDoado() {
        super();
    }

    public ItemDoado(int id, String nome, String descricao, int quantidade, CategoriaDoacao categoria, int colabId) {
        super();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.colabId = colabId;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public CategoriaDoacao getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDoacao categoria) {
        this.categoria = categoria;
    }

    public int getColabId() {
        return colabId;
    }

    public void setColabId(int colabId) {
        this.colabId = colabId;
    }
}
