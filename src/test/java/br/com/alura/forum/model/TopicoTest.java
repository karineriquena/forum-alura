package br.com.alura.forum.model;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class TopicoTest {
	
	Usuario autor;
	Categoria categoria;
	Curso curso;
	Topico topico;
	
	@Before
	public void before() {
		autor = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		categoria = new Categoria("Java iniciante");
		curso = new Curso("Java", categoria );
		topico = new Topico("Titulo", "Descricao", autor , curso );
	}

	@Test
	public void status_inicial_de_um_topico_deve_ser_nao_respondido() {
		assertEquals(StatusTopico.NAO_RESPONDIDO, topico.getStatus());
	}
	
	@Test
	public void estado_deve_ser_fechado_quando_fechar_um_topico() {
		topico.fechar();
		assertEquals(StatusTopico.FECHADO, topico.getStatus()); 		
	}
	
	@Test
	public void ao_adicionar_uma_resposta_a_lista_de_respostas_deve_ter_mais_uma_resposta() {
		new Resposta("Adicione o Java no PATH", topico, autor);
		assertEquals(1, topico.getRespostas().size());
	}
	
	@Test(expected = IllegalStateException.class)
	public void deve_lancar_excecao_ao_marcar_como_solucionado_um_topico_sem_resposta() {
		topico.marcarComoSolucionado();
	}
	
	@Test()
	public void marcar_como_solucionado_um_topico_com_resposta() {
		new Resposta("Adicione o Java no PATH", topico, autor);
		topico.marcarComoSolucionado();
		assertEquals(StatusTopico.SOLUCIONADO, topico.getStatus()); 
	}

}
