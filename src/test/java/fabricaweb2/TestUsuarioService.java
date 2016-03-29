package fabricaweb2;

import br.com.fabricadeprogramador.model.dao.UsuarioDAO;
import br.com.fabricadeprogramador.model.entidade.Usuario;
import br.com.fabricadeprogramador.service.UsuarioService;
import br.com.fabricadeprogramador.service.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Cesar on 18/03/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestUsuarioService {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    @Qualifier(value = "usuarioDAOJPA")
    UsuarioDAO usuarioDAO;

    @Transactional
    @Test(expected = ServiceException.class)
    public void testNaoDeveSalvar() throws ServiceException {

        Usuario usuario = new Usuario();
        usuario.setNome("Bianca");
        usuario.setLogin("diacopulos");
        usuario.setSenha("123");

        usuarioDAO.salvar(usuario);

        Usuario usuSalvo;

        usuarioService.salvar(usuario);

    }

    @Transactional
    @Test
    public void testDeveSalvar() throws ServiceException {
        Usuario usuario = new Usuario();
        usuario.setNome("novoUsuariojshdashsdk");
        usuario.setLogin("novoUsu");
        usuario.setSenha("123");

        usuarioService.salvar(usuario);

    }
}
