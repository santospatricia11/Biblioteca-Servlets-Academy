package dao;

import model.Livro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LivroDao {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public LivroDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("LivroPU");
        entityManager = (EntityManager) entityManagerFactory.createEntityManager();
    }

    public void salvarLivro(Livro livro) {
        entityManager.getTransaction().begin();
        entityManager.persist(livro);
        entityManager.getTransaction().commit();
    }

    public Livro buscarLivroPorISBN(String ISBN) {
        return entityManager.find(Livro.class, ISBN);
    }

    public List<Livro> listarLivros() {
        Query query = entityManager.createQuery("SELECT l FROM Livro l");
        return query.getResultList();
    }

    public void atualizarLivro(Livro livro) {
        entityManager.getTransaction().begin();
        entityManager.merge(livro);
        entityManager.getTransaction().commit();
    }

    public void deletarLivro(String ISBN) {
        Livro livro = entityManager.find(Livro.class, ISBN);
        entityManager.getTransaction().begin();
        entityManager.remove(livro);
        entityManager.getTransaction().commit();
    }

    public void fecharConexao() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
