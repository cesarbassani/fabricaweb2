package br.com.fabricadeprogramador.model.dao;

import javax.persistence.*;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Usuario;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("usuarioDAOJPA")
public class UsuarioDAOJPA implements UsuarioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {

        Usuario usu = entityManager.merge(usuario);

        return usu;
    }

    @Override
    @Transactional
    public void excluir(Usuario usuario) throws DAOException {
        try {
            Usuario usuBuscado = entityManager.getReference(Usuario.class, usuario.getId());
            entityManager.remove(usuBuscado);
        } catch (Exception e) {
            throw new DAOException("Não foi possível excluir!", e);
        }
    }

    @Override
    public List<Usuario> buscarTodos() {

        return entityManager.createNamedQuery("Usuario.buscaTodos", Usuario.class).getResultList();
    }

    @Override
    public Usuario buscarLogin(String login) {
        try {
            Query q = entityManager.createQuery("select u from Usuario u where u.login=:loginParam");
            q.setParameter("loginParam", login);
            q.setMaxResults(1);
            return (Usuario) q.getSingleResult();
        }catch (NoResultException e) {
            return null;
            //throw new DAOException("Regisro nao encontrado", e);
        }

    }

    @Override
    public Usuario buscarPorId(int id) {

        return entityManager.find(Usuario.class, id);
    }

}
