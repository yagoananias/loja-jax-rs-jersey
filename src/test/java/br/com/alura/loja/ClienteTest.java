package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

import junit.framework.Assert;

public class ClienteTest {
	
	@Test
	public void testaConexao() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://run.mocky.io");
		String conteudo = target.path("/v3/987fc2f2-b801-4281-a886-80a15fc8e77a").request().get(String.class);
		System.out.println(conteudo);
		Assert.assertTrue(conteudo.contains("message"));
		
	}

}
