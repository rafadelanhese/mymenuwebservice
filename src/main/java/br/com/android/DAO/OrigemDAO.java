/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.android.DAO;

import br.com.android.Model.Origem;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Session;

/**
 *
 * @author Rafael Delanhese
 */
@RequestScoped
public class OrigemDAO {
      private EntityManager manager;

    /**
     * @deprecated CDI eyes only
     */
    public OrigemDAO() {
        this(null);
    }

    @Inject
    public OrigemDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void refresh(Origem origem) {
        getSession().refresh(origem);
    }

    private Session getSession() {
        return manager.unwrap(Session.class);
    }

    public void saveOrUpdate(Origem origem) {
        if(origem.getIdOrigem() == null)
            manager.persist(origem);
        else
            manager.merge(origem);
    }
    
    public void delete(Origem origem) {
        manager.remove(origem);
    }

    public List<Origem> listAll() {
        return manager.createQuery("select o from Origem o", Origem.class).getResultList();
    }     

    public Origem findById(Long id) {
        return manager.find(Origem.class, id);
    }
}
