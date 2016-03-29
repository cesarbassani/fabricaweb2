package br.com.fabricadeprogramador.service.exception;

import br.com.fabricadeprogramador.model.dao.exception.DAOException;

/**
 * Created by Cesar on 15/03/2016.
 */
public class ServiceException extends Exception {

    public ServiceException(String msg) {

        super(msg);
    }

    public ServiceException(DAOException e) {
        super(e);
    }
}
