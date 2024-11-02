package com.example.sisapsoo.model.dao;

import com.example.sisapsoo.connection.ConnectionFactory;
import com.example.sisapsoo.model.Salgado;
import jakarta.persistence.EntityManager;
import java.util.List;

public class SalgadoDAO {
    EntityManager em = ConnectionFactory.getConnection();

    //insert-update
    public Salgado save(Salgado s) {
        try {
            em.getTransaction().begin();
            if (s.getId() == null) {
                em.persist(s);
            } else {
                em.merge(s);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return s;
    }

    //select where id = <valor desejado>
    public Salgado findById(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        Salgado s = null;

        try {
            s= em.find(Salgado.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return s;
    }

    //Lista de todos os objetos Tabelateste
    public List<Salgado> findAll() {
        EntityManager em = ConnectionFactory.getConnection();
        List<Salgado> ss = null;

        try {
            ss = em.createQuery("from Salgado s").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return ss;
    }

    //delete
    public Salgado remove(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        Salgado s = null;

        try {
            s = em.find(Salgado.class, id);
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return s;

    }

}