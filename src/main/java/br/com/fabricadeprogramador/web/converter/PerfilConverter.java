package br.com.fabricadeprogramador.web.converter;

import br.com.fabricadeprogramador.model.entidade.Perfil;
import br.com.fabricadeprogramador.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created by Cesar on 26/03/2016.
 */
@Component
public class PerfilConverter implements Converter {

    @Autowired
    private PerfilService perfilService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String idTela) {
        try {
            return perfilService.buscarPorId(Integer.parseInt(idTela));
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object objPerfil) {
        try {
            Perfil perfil = (Perfil) objPerfil;
            return perfil.getId().toString();
        }catch (Exception e) {
            return null;
        }

    }
}
