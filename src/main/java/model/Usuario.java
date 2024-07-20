package model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long ID;
    private String nome ;

    private String email ;

    private String password;


    public Usuario(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;

    }

    public Usuario(String password, String email) {
    }

    public Usuario() {

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +

                '}';
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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


}
