package br.com.fabricadeprogramador.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {

	public static final String SALVO_SUCESSO = "Cadastro realizado com sucesso!";
	public static final String FALHA_SALVAR = "Nao pode cadastrar!";
	public static final String EXCLUIDO_SUCESSO = "Excluido com sucesso!";
	public static final String FALHA_EXCLUSAO = "Nao pode ser excluido!";

	public static void mensagemInfo(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg , null));
	}
	
	public static void mensagemErro(String msg ) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg , null));
	}
	
	public static void mensagemAviso(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, msg , null));
	}
}
