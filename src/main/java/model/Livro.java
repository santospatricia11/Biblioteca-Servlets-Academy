package model;

import javax.persistence.Id;

public class Livro {
    @Id
    private String ISBN ;
    private  String nomeLivro ;
    private  String categoria;
    private String descricao;
    private String diretorioImagem;
    private int quantidade;

    public Livro() {
    }

    public Livro(String ISBN, String nomeLivro, String categoria, String descricao, int quantidade, String diretorioImagem) {
        this.ISBN = ISBN;
        this.nomeLivro = nomeLivro;
        this.categoria = categoria;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.diretorioImagem = diretorioImagem;

    }

    @Override
    public String toString() {
        return "Livro{" +
                "ISBN='" + ISBN + '\'' +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", diretorioImagem =" + diretorioImagem +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDiretorioImagem() {
        return diretorioImagem;
    }

    public void setDiretorioImagem(String diretorioImagem) {
        this.diretorioImagem = diretorioImagem;
    }
}
