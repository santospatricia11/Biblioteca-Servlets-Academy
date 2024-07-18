package model;

import jakarta.persistence.*;

import javax.persistence.Column;

@Entity
@Table(name = "table-user")
public class Usuario {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "name_usuario")
    private String nome ;
    @Column(name = "email")
    private String email ;

    private String password;



    public Usuario(String nome, String email, String password, Long id) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
