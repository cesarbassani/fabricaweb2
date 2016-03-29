package br.com.fabricadeprogramador.model.dao;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Perfil;
import br.com.fabricadeprogramador.model.entidade.Usuario;

import java.util.List;

/**
 * Padrao do Objeto de acesso a dados Perfil
 *
 * @author Virmerson
 */
public interface PerfilDAO {

    Perfil salvar(Perfil perfil);

    void excluir(Perfil perfil) throws DAOException;

    Perfil buscarPorId(int id);

    List<Perfil> buscarTodos();

}
