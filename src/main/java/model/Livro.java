package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import javax.persistence.Id;
@Entity
@Table(name = "Livros")

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ISBN ;
    private  String nome_livro;
    private  String categoria;
    private String descricao;
    private String capa;
    private int quantidade;

    public Livro() {
    }

    public Livro(String ISBN, String nome_livro, String categoria, String descricao, int quantidade, String capa) {
        this.ISBN = ISBN;
        this.nome_livro = nome_livro;
        this.categoria = categoria;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.capa = capa;

    }

    @Override
    public String toString() {
        return "Livro{" +
                "ISBN='" + ISBN + '\'' +
                ", nomeLivro='" + nome_livro + '\'' +
                ", categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", diretorioImagem =" + capa +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public String getNome_livro() {
        return nome_livro;
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

    public void setNome_livro(String nomeLivro) {
        this.nome_livro = nomeLivro;
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

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
}
