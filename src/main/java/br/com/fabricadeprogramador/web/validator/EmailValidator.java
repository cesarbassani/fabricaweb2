package br.com.fabricadeprogramador.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by Cesar on 23/03/2016.
 */
@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        String email = (String) value;

        if (email.indexOf("@") == - 1) {
            throw new ValidatorException(new FacesMessage("E-mail incorreto"));
        }

    }
}
