package br.com.alura.loja;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import br.com.alura.loja.modelo.Projeto;
import junit.framework.Assert;

public class ProjetoTest {
	
	private HttpServer server;

	@Before
	public void startaServidor() {
		server = Servidor.inicializaServidor();
	}
	
	@After
	public void derrubaServidor() {
		server.stop();
	}
	
	@Test
	public void testaBuscarProjetoEsperado() throws IOException {		
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3000");
		String conteudo = target.path("/projetos").request().get(String.class);
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		Assert.assertEquals("1", projeto.getId());
		
	}

}
