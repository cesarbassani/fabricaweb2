package br.com.fabricadeprogramador.model.dao;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Perfil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("perfilDAOJPA")
public class PerfilDAOJPA implements PerfilDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Perfil salvar(Perfil perfil) {

        Perfil usu = entityManager.merge(perfil);

        return usu;
    }

    @Override
    @Transactional
    public void excluir(Perfil perfil) throws DAOException {
        try {
            Perfil usuBuscado = entityManager.getReference(Perfil.class, perfil.getId());
            entityManager.remove(usuBuscado);
        } catch (Exception e) {
            throw new DAOException("Não foi possível excluir!", e);
        }
    }

    @Override
    public List<Perfil> buscarTodos() {

        return entityManager.createNamedQuery("Perfil.buscaTodos", Perfil.class).getResultList();
    }

    @Override
    public Perfil buscarPorId(int id) {

        return entityManager.find(Perfil.class, id);
    }

}
