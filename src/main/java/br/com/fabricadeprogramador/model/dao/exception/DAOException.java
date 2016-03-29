package br.com.fabricadeprogramador.model.dao.exception;

/**
 * Created by Cesar on 14/03/2016.
 */
public class DAOException extends Exception {

    public DAOException(String msg, Exception causa) {
        super(msg, causa);
    }
}
