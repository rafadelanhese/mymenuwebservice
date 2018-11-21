/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.android.DAO;

import br.com.android.Model.Receita;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rafael Delanhese
 */
@RequestScoped
public class ReceitaDAO {
    private EntityManager manager;

    /**
     * @deprecated CDI eyes only
     */
    public ReceitaDAO() {
        this(null);
    }

    @Inject
    public ReceitaDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void refresh(Receita receita) {
        getSession().refresh(receita);
    }

    private Session getSession() {
        return manager.unwrap(Session.class);
    }

    public void saveOrUpdate(Receita receita) {
        if(receita.getIdReceita() == null)
            manager.persist(receita);
        else
            manager.merge(receita);
    }
    
    public void delete(Receita receita) {
        manager.remove(receita);
    }

    public List<Receita> listAll() {
        return manager.createQuery("select r from Receita r", Receita.class).getResultList();
    }
    
     public List<Receita> pesquisaPorNome(String titulo, String origem, String categoria) {               
        return manager.createQuery("select r from Receita r where "
                + "r.origem.descricao = :origem and "
                + "r.categoria.descricao = :categoria and "
                + "r.titulo = :titulo", Receita.class)
                .setParameter("titulo", titulo)
                .setParameter("origem", origem)
                .setParameter("categoria", categoria)
                .getResultList();
    }

    public Receita findById(Long id) {
        return manager.find(Receita.class, id);
    }
}
