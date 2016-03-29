package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.model.dao.PerfilDAO;
import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Perfil;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cesar on 14/03/2016.
 */
@Service
public class PerfilService {

    @Autowired
    @Qualifier(value = "perfilDAOJPA")
    PerfilDAO perfilDAO;

    public Perfil salvar(Perfil perfil) throws ServiceException {
        return perfilDAO.salvar(perfil);
    }

    public void excluir(Perfil perfil) throws ServiceException {
        try {
            perfilDAO.excluir(perfil);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Perfil buscarPorId(int id) {
        return perfilDAO.buscarPorId(id);
    }

    public List<Perfil> buscarTodos() {
        return perfilDAO.buscarTodos();
    }

}
