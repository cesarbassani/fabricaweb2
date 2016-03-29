package br.com.fabricadeprogramador.model.dao;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Usuario;

import java.util.List;

/**
 * Padrao do Objeto de acesso a dados Usuario
 *
 * @author Virmerson
 */
public interface UsuarioDAO {

    Usuario salvar(Usuario usuario);

    void excluir(Usuario usuario) throws DAOException;

    Usuario buscarPorId(int id);

    List<Usuario> buscarTodos();

    Usuario buscarLogin(String login);
}
