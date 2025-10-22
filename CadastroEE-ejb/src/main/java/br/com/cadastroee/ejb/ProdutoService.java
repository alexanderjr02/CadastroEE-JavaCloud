package br.com.cadastroee.ejb;

import br.com.cadastroee.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProdutoService {

    @PersistenceContext(unitName = "CadastroPU")
    private EntityManager em;

    public List<Produto> listarTodos() {
        return em.createQuery("SELECT p FROM Produto p ORDER BY p.id", Produto.class)
                 .getResultList();
    }

    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

    public void incluir(Produto p) {
        em.persist(p);
    }

    public void alterar(Produto p) {
        em.merge(p);
    }

    public void excluir(Long id) {
        Produto ref = em.find(Produto.class, id);
        if (ref != null) {
            em.remove(ref);
        }
    }
}