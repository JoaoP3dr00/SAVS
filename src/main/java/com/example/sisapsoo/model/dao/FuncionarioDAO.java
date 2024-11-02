package com.example.sisapsoo.model.dao;

import com.example.sisapsoo.connection.ConnectionFactory;
import com.example.sisapsoo.model.Funcionario;
import jakarta.persistence.EntityManager;
import java.util.List;

public class FuncionarioDAO {
    EntityManager em = new ConnectionFactory().getConnection();

    //insert
    public Funcionario save(Funcionario f) {
        try {
            em.getTransaction().begin();
            em.persist(f);
            System.out.println("SALVOU FUNCIONARIO ----------------------------------------------");
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return f;
    }

    // update
    public Funcionario update(Funcionario f){
        try {
            em.getTransaction().begin();
        }catch(Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return f;
    }

    //select where id = <valor desejado>
    public Funcionario findById(String cpf) {
        EntityManager em = new ConnectionFactory().getConnection();
        Funcionario f = null;

        try {
            f = em.find(Funcionario.class, cpf);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return f;
    }

    //Lista de todos os objetos Funcionario
    public List<Funcionario> findAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Funcionario> f = null;

        try {
            f = em.createQuery("from Funcionario f").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return f;
    }

    //delete
    public Funcionario remove(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Funcionario f = null;

        try {
            f = em.find(Funcionario.class, id);
            em.getTransaction().begin();
            em.remove(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return f;

    }

}
