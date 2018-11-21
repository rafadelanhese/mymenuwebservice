/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.android.DAO;

import br.com.android.Model.Categoria;
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
public class CategoriaDAO {
    private EntityManager manager;

    /**
     * @deprecated CDI eyes only
     */
    public CategoriaDAO() {
        this(null);
    }

    @Inject
    public CategoriaDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void refresh(Categoria categoria) {
        getSession().refresh(categoria);
    }

    private Session getSession() {
        return manager.unwrap(Session.class);
    }

    public void saveOrUpdate(Categoria categoria) {
        if(categoria.getIdCategoria() == null)
            manager.persist(categoria);
        else
            manager.merge(categoria);
    }
    
    public void delete(Categoria categoria) {
        manager.remove(categoria);
    }

    public List<Categoria> listAll() {
        return manager.createQuery("select c from Categoria c", Categoria.class).getResultList();
    }
    
    public Categoria findById(Long id) {
        return manager.find(Categoria.class, id);
    }
}
