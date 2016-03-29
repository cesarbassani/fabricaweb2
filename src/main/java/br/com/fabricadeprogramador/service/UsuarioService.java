package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.model.dao.UsuarioDAO;
import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Usuario;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cesar on 14/03/2016.
 */
@Service
public class UsuarioService {

    @Autowired
    @Qualifier(value = "usuarioDAOJPA")
    UsuarioDAO usuarioDAO;

    public Usuario salvar(Usuario usuario) throws ServiceException {
        //Verifica��es
        Usuario usuarioExistente = usuarioDAO.buscarLogin(usuario.getLogin());
        //J� existe
        if (usuarioExistente != null) {
            throw new ServiceException("Usuario ja existente!");
        }

        return usuarioDAO.salvar(usuario);
    }

    public void excluir(Usuario usuario) throws ServiceException {
        try {
            usuarioDAO.excluir(usuario);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Usuario buscarPorId(int id) {
        return usuarioDAO.buscarPorId(id);
    }

    public List<Usuario> buscarTodos() {
        return usuarioDAO.buscarTodos();
    }

    public Usuario buscarLogin(String login) {
        return usuarioDAO.buscarLogin(login);
    }
}
