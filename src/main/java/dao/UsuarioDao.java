package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Usuario;
import java.util.List;

import java.util.Optional;

public class UsuarioDao {

    private EntityManager entityManager;

    public UsuarioDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("usuarioPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void addUsuario(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
    }

    public void deleteUsuario(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        }
    }

    public void updateUsuario(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
    }

    public List<Usuario> getAllUsuarios() {
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        return Optional.ofNullable(usuario);
    }

    public Optional<Usuario> getUsuarioByEmail(String email) {
        try {
            Usuario usuario = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                    .setParameter("email", email)
                    .getSingleResult();
            return Optional.of(usuario);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public boolean validateUsuario(String email, String password) {
        try {
            Usuario usuario = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password", Usuario.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            return usuario != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
