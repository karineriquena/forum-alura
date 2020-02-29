package br.com.alura.forum.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TopicoTest {

	@Test
	public void status_inicial_de_um_topico_deve_ser_nao_respondido() {
		
		// To
		Usuario autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Categoria categoria = new Categoria("Java iniciante");
		Curso curso = new Curso("Java", categoria );
		Topico topico = new Topico("Titulo", "Descricao", autor , curso );
		
		// Then
		assertEquals(StatusTopico.NAO_RESPONDIDO, topico.getStatus());
	}
	
	@Test
	public void estado_deve_ser_fechado_quando_fechar_um_topico() {
		// To
		Usuario autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Categoria categoria = new Categoria("Java iniciante");
		Curso curso = new Curso("Java", categoria );
		Topico topico = new Topico("Titulo", "Descricao", autor , curso );
		
		// When
		topico.fechar();
				
		// Then
		assertEquals(StatusTopico.FECHADO, topico.getStatus()); 		
	}
	
	@Test
	public void ao_adicionar_uma_resposta_a_lista_de_respostas_deve_ter_mais_uma_resposta() {
		// To
		Usuario autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Java Básico", categoria );
		Topico topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor , curso );
				
		// When
		new Resposta("Adicione o Java no PATH", topico, autor);
		
		// Then
		assertEquals(1, topico.getRespostas().size());
	}
	
	@Test(expected = IllegalStateException.class)
	public void deve_lancar_excecao_ao_marcar_como_solucionado_um_topico_sem_resposta() {
		// To
		Usuario autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Java Básico", categoria );
		Topico topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor , curso );
		
		// Then
		topico.marcarComoSolucionado();
	}
	
	@Test()
	public void marcar_como_solucionado_um_topico_com_resposta() {
		// To
		Usuario autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Java Básico", categoria );
		Topico topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor , curso );
		
		// When
		new Resposta("Adicione o Java no PATH", topico, autor);
		topico.marcarComoSolucionado();
		
		// Then
		assertEquals(StatusTopico.SOLUCIONADO, topico.getStatus()); 
	}

}
