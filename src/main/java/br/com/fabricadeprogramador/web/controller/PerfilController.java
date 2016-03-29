package br.com.fabricadeprogramador.web.controller;

import br.com.fabricadeprogramador.model.entidade.Perfil;
import br.com.fabricadeprogramador.service.PerfilService;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import br.com.fabricadeprogramador.web.util.MensagemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Cesar on 18/03/2016.
 */
@Controller
public class PerfilController {

    private Perfil perfil = new Perfil();

    @Autowired
    private PerfilService perfilService;

    private List<Perfil> perfilList;

    public PerfilController() {

    }

    @PostConstruct
    public void init() {
        setPerfilList(perfilService.buscarTodos());
    }

    public void salvar() {
        try {
            Perfil usuSalvo = perfilService.salvar(perfil);
            if (perfil.getId() == null) {
                perfilList.add(usuSalvo);
            }
            perfil = new Perfil();
            MensagemUtil.mensagemInfo(MensagemUtil.SALVO_SUCESSO);

        } catch (ServiceException e) {

            MensagemUtil.mensagemErro(MensagemUtil.FALHA_SALVAR);
            e.printStackTrace();
        }
    }

    public void editar(Perfil perfil) {
        this.perfil = perfil;
    }

    public void excluir(Perfil perfil) {
        try {
            perfilService.excluir(perfil);
            perfilList.remove(perfil);

            MensagemUtil.mensagemInfo(MensagemUtil.EXCLUIDO_SUCESSO);

        } catch (ServiceException e) {

            MensagemUtil.mensagemErro(MensagemUtil.FALHA_EXCLUSAO);
            e.printStackTrace();
        }
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
    }
}
