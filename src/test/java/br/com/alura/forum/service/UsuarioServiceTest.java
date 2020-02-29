package br.com.alura.forum.service;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.alura.forum.dao.UsuarioDao;
import br.com.alura.forum.model.Usuario;

public class UsuarioServiceTest {

	@Test(expected = UsernameNotFoundException.class)
	public void deve_lancar_excecao_ao_buscar_usuario_com_email_inexistente () {
		UsuarioDao dao = Mockito.mock(UsuarioDao.class);
		UsuarioService service = new UsuarioService(dao);

		service.loadUserByUsername("karine_limp@hotmail.com");
	}
	
	@Test()
	public void deve_retornar_o_usuario_do_email_passado_como_parametro() {
		UsuarioDao dao = Mockito.mock(UsuarioDao.class);
		Usuario usuario = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Mockito.when(dao.buscarPorEmail("karine_limp@hotmail.com")).thenReturn(usuario);
		
		UsuarioService service = new UsuarioService(dao);
		
		UserDetails usuarioRetornado = service.loadUserByUsername("karine_limp@hotmail.com");
		
		assertEquals("karine_limp@hotmail.com", usuarioRetornado.getUsername());
	}

}
