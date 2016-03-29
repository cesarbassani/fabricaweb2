package fabricaweb2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.fabricadeprogramador.model.entidade.Usuario;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDataSource {

	public static void main(String[] args) {
		testeEntityManager();
	}

	public static void testDataSource() {
		// Carregando o contexto do Spring
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/springbeans.xml");

		// Acessando o objeto BasicDataSource criado dentro do contexto do
		// Spring
		BasicDataSource basicDataSource = (BasicDataSource) ctx
				.getBean("dataSource");

		// Imprimindo dados do objeto BasicDataSource criado no contexto do
		// Spring
		System.out.println(basicDataSource.getDriverClassName());
		System.out.println(basicDataSource.getUrl());
		System.out.println(basicDataSource.getUsername());
		System.out.println(basicDataSource.getPassword());

		// O Objeto de Carregamento de Recursos ClassPathXmlApplicationContext
		// deve ser fechado após seu uso.
		ctx.close();
	}

	public static void testeEntityManager() {

		// Carregando o contexto do Spring
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/springbeans.xml");

		// Acessando o objeto EntityManagerFactory criado dentro do contexto do
		// Spring
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) ctx
				.getBean("entityManagerFactory");

		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		Usuario usu = new Usuario();
		usu.setNome("Jão da Silva");
		usu.setLogin("jao");
		usu.setSenha("123");

		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		entityManager.persist(usu);
		transacao.commit();

	}
}
