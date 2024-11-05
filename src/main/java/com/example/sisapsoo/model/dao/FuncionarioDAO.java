package com.example.sisapsoo.model.dao;
import com.example.sisapsoo.connection.ConnectionFactory;
import com.example.sisapsoo.model.Funcionario;
import jakarta.persistence.EntityManager;


import java.util.List;

public class FuncionarioDAO {

    EntityManager entityManager = getEntityManager();

    private EntityManager getEntityManager() {
        return ConnectionFactory.getConnection();
    }

    public Funcionario save(Funcionario funcionario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(funcionario);
            entityManager.getTransaction().commit();
            System.out.println("SALVOU FUNCIONARIO");
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            System.err.println("Erro ao salvar funcionário: " + exception.getMessage());
        } finally {
            entityManager.close();
        }
        return funcionario;
    }

    public Funcionario findById(Integer id) {
        EntityManager entityManager = getEntityManager();
        Funcionario funcionario = null;

        try {
            funcionario = entityManager.find(Funcionario.class, id);
        } catch (Exception exception) {
            System.err.println("Erro ao buscar funcionário: " + exception.getMessage());
        } finally {
            entityManager.close();
        }
        return funcionario;
    }

    public List<Funcionario> findAll() {
        EntityManager entityManager = getEntityManager();
        List<Funcionario> funcionarios = null;

        try {
            funcionarios = entityManager.createQuery("from Funcionario f").getResultList();
        } catch (Exception exception) {
            System.err.println("Erro ao listar funcionários: " + exception);
        } finally {
            entityManager.close();
        }
        return funcionarios;
    }

    public Funcionario remove(Integer id) {
        EntityManager entityManager = getEntityManager();
        Funcionario funcionario = null;

        try {
            funcionario = entityManager.find(Funcionario.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            System.err.println("Erro ao remover funcionário: " + exception.getMessage());
            throw exception;
        } finally {
            entityManager.close();
        }

        return funcionario;
    }
}
