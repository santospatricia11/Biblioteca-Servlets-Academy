package dao;

import model.Livro;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LivroDao {

        private EntityManager entityManager;

        public LivroDao() {
            this.entityManager = entityManager;
        }

        public void salvarLivro(Livro livro) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.persist(livro);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            }
        }

        public void atualizarLivro(Livro livro) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.merge(livro);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            }
        }

        public void deletarLivro(String isbn) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                Livro livro = entityManager.find(Livro.class, isbn);
                if (livro != null) {
                    entityManager.remove(livro);
                }
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            }
        }

        public Livro buscarLivroPorISBN(String isbn) {
            return entityManager.find(Livro.class, isbn);
        }

        public List<Livro> listarLivros() {
            return entityManager.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
        }

        public void fecharConexao() {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

    }
