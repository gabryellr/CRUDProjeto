package br.com.gabriel.dao;

import br.com.gabriel.model.Produto;
import br.com.gabriel.services.Manager;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoProduto {

    private EntityManager em;

    public DaoProduto() {
        em = Manager.getInstance().getEm();
    }

    public void salvar(Produto p) {
        em.getTransaction().begin();
        if (p.getCodigo() > 0) {
            p = em.merge(p);
        }
        em.persist(p);
        em.getTransaction().commit();
    }

    public List<Produto> buscaProduto() {
        Query qry = em.createQuery("Select p from br.com.gabriel.model.Produto p");
        List produtos = qry.getResultList();
        return (List<Produto>) produtos;
    }

    public void remover(Produto p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

    }

    
}
