package br.com.fabricadeprogramador.web.controller;

import br.com.fabricadeprogramador.model.entidade.Usuario;
import br.com.fabricadeprogramador.service.UsuarioService;
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
public class UsuarioController {

    private Usuario usuario = new Usuario();

    @Autowired
    private UsuarioService usuarioService;

    private List<Usuario> usuarioList;

    public UsuarioController() {

    }

    @PostConstruct
    public void init() {
        setUsuarioList(usuarioService.buscarTodos());
    }

    public void salvar() {
        try {
            Usuario usuSalvo = usuarioService.salvar(usuario);
            if (usuario.getId() == null) {
                usuarioList.add(usuSalvo);
            }
            usuario = new Usuario();
            MensagemUtil.mensagemInfo(MensagemUtil.SALVO_SUCESSO);

        } catch (ServiceException e) {

            MensagemUtil.mensagemErro(MensagemUtil.FALHA_SALVAR);
            e.printStackTrace();
        }
    }

    public void cancelar() {
        this.usuario = new Usuario();
    }

    public void editar(Usuario usuario) {
        this.usuario = usuario;
    }

    public void excluir(Usuario usuario) {
        try {
            usuarioService.excluir(usuario);
            usuarioList.remove(usuario);

            MensagemUtil.mensagemInfo(MensagemUtil.EXCLUIDO_SUCESSO);

        } catch (ServiceException e) {

            MensagemUtil.mensagemErro(MensagemUtil.FALHA_EXCLUSAO);
            e.printStackTrace();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
}
