package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("java-jpa");
        } catch (Exception e) {
            // logar -> log4j
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<E> abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade) {
        em.persist(entidade);
        return this;
    }

    public DAO<E> atualizar(E entidade) {
        em.merge(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade) {
        return this.abrirTransacao().incluir(entidade).fecharTransacao();
    }

    public void remover(E entidade) {
        em.remove(entidade);
    }

    public E obterUm(Object id) {
        return em.find(classe, id);
    }

    public List<E> obterTodos() {
        return this.obterTodos(150, 0);
    }

    public List<E> obterTodos(int quantidade, int deslocamento) {
        if (classe == null) {
            throw new UnsupportedOperationException("A classe está nula.");
        }
        String jpql = String.format("select e from %s e", classe.getName());
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(quantidade).setFirstResult(deslocamento);
        return query.getResultList();
    }

    public List<E> consultar(String nome, Object... params) {
        TypedQuery<E> query = em.createNamedQuery(nome, classe);
        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }
        return query.getResultList();
    }

    public E consultarUm(String nome, Object... params) {
        List<E> lista = consultar(nome, params);
        return lista.isEmpty() ? null : lista.get(0);
    }

    public void fechar() {
        em.close();
    }

}
