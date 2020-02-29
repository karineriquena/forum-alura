package br.com.alura.forum.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TopicoTest {

	@Test
	public void status_inicial_de_um_topico_deve_ser_nao_respondido() {
		
		// Dado
		Usuario autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Categoria categoria = new Categoria("Java iniciante");
		Curso curso = new Curso("Java", categoria );
		Topico topico = new Topico("Titulo", "Descricao", autor , curso );
		
		// Então
		assertEquals(StatusTopico.NAO_RESPONDIDO, topico.getStatus());
	}
	
	@Test
	public void estado_deve_ser_fechado_quando_fechar_um_topico() {
		// Dado
		Usuario autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Categoria categoria = new Categoria("Java iniciante");
		Curso curso = new Curso("Java", categoria );
		Topico topico = new Topico("Titulo", "Descricao", autor , curso );
		
		// Quando
		topico.fechar();
				
		// Então
		assertEquals(StatusTopico.FECHADO, topico.getStatus()); 		
	}
	
	@Test
	public void ao_adicionar_uma_resposta_a_lista_de_respostas_deve_ter_mais_uma_resposta() {
		// Dado
		Usuario autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Java Básico", categoria );
		Topico topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor , curso );
				
		// Quando
		new Resposta("Adicione o Java no PATH", topico, autor);
		
		// Então
		assertEquals(1, topico.getRespostas().size());
	}
	
	@Test(expected = IllegalStateException.class)
	public void deve_lancar_excecao_ao_marcar_como_solucionado_um_topico_sem_resposta() {
		// Dado
		Usuario autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Java Básico", categoria );
		Topico topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor , curso );
		
		// Quando
		topico.marcarComoSolucionado();
	}
	
	@Test()
	public void marcar_como_solucionado_um_topico_com_resposta() {
		// Dado
		Usuario autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Java Básico", categoria );
		Topico topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor , curso );
		
		// Quando
		new Resposta("Adicione o Java no PATH", topico, autor);
		topico.marcarComoSolucionado();
		
		// Então
		assertEquals(StatusTopico.SOLUCIONADO, topico.getStatus()); 
	}

}
