package dao;

import dao.util.Conexao;
import model.Livro;

import java.sql.*;

public class LivroDao {
    private Connection connection;

    private void conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = Conexao.getConexao();
        }
    }

    private void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }


    public Livro inserirLivro(Livro livro) throws SQLException {

        String sql = "INSERT INTO livro ( ISBN,nome_livro, categoria,descricao,capa,quantidade) " + " VALUES (?,?,?,?, ?, ?)";

        conectar();

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, livro.getISBN());
        statement.setString(2, livro.getNome_livro());
        statement.setString(3, livro.getCategoria());
        statement.setString(4, livro.getDescricao());
        statement.setString(5, livro.getCapa());
        statement.setInt(6, livro.getQuantidade());
        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();
       String isbn = "isbn";
        if(resultSet.next())
            isbn = resultSet.getString("isbn");
        statement.close();

        desconectar();

        livro.setISBN(isbn);
        return livro;
    }


        /*private EntityManager entityManager;

        public LivroDao() {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("nome-da-sua-unidade-de-persistencia");
            this.entityManager = emf.createEntityManager();
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
        }*/
    }



