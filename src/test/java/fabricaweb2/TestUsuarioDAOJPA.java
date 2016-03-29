
package fabricaweb2;
import br.com.fabricadeprogramador.model.dao.exception.DAOException;
import br.com.fabricadeprogramador.model.entidade.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fabricadeprogramador.model.dao.UsuarioDAO;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager")
public class TestUsuarioDAOJPA {
	
	//Obtendo uma instancia de UsuarioDAO por meio de injecao de dependencia
	@Autowired
	@Qualifier("usuarioDAOJPA")
	private UsuarioDAO usuarioDAO;

	@Test
	public void testSalvar() {
		
		// Criando uma nova Instancia de usuário para ser salvo
		Usuario usu = new Usuario();
		usu.setNome("ze");
		usu.setLogin("ze");
		usu.setSenha("101");
		usu.setEmail("fsdjf@fklsjdf");
		usu.setAtivo(true);
		// Salvando

		usu = usuarioDAO.salvar(usu);
		Assert.assertNotNull(usu.getId());
	}

	//@Test
	public void testBuscarPorId() {
		Usuario usuario = new Usuario();
		usuario.setNome("Cesar");
		usuario.setLogin("bassani");
		usuario.setSenha("123");
		//usuario.setAtivo(true);

		Usuario usuSalvo = usuarioDAO.salvar(usuario);

		Integer idSalvo = usuSalvo.getId();

		Usuario usuBuscado = usuarioDAO.buscarPorId(idSalvo);

		Assert.assertEquals(usuSalvo, usuBuscado);
	}

	//@Test
	public void testExcluir() throws DAOException {
		Usuario usu = new Usuario();
		usu.setNome("teste");
		usu.setLogin("teste");
		usu.setSenha("teste");

		Usuario usuSalvo = usuarioDAO.salvar(usu);

		usuarioDAO.excluir(usuSalvo);

		Usuario usuExcluido = usuarioDAO.buscarPorId(usuSalvo.getId());

		Assert.assertEquals(usuExcluido, null);
	}

	//@Test
	public void testBuscarTodos() {

		Usuario usu = new Usuario();
		usu.setNome("teste");
		usu.setLogin("teste");
		usu.setSenha("teste");

		Usuario usuSalvo = usuarioDAO.salvar(usu);

		List<Usuario> usuarios = usuarioDAO.buscarTodos();

		Assert.assertTrue(usuarios.size() > 0);


	}
}
