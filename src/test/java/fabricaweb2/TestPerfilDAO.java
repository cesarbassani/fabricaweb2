package fabricaweb2;

import br.com.fabricadeprogramador.model.dao.PerfilDAO;
import br.com.fabricadeprogramador.model.entidade.Perfil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by Cesar on 26/03/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager")
public class TestPerfilDAO {

    @Autowired
    @Qualifier(value = "perfilDAOJPA")
    private PerfilDAO perfilDAO;

    @Test
    public void salvarPerfil() {

        Perfil perfil = new Perfil();
        perfil.setDescricao("PUBLIC");

        Perfil perfilSalvo = perfilDAO.salvar(perfil);

        Assert.assertNotNull(perfilSalvo.getId());
    }

}
