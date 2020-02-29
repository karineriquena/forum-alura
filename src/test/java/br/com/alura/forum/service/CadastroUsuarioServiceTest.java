package br.com.alura.forum.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.alura.forum.dao.PerfilDao;
import br.com.alura.forum.dao.UsuarioDao;
import br.com.alura.forum.model.Usuario;

public class CadastroUsuarioServiceTest {

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_excecao_ao_tentar_incluir_usuario_existente() {
		UsuarioDao usuarioDao = Mockito.mock(UsuarioDao.class);
		Usuario usuario = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		Mockito.when(usuarioDao.buscarPorEmail("karine_limp@hotmail.com")).thenReturn(usuario);
		PerfilDao perfilDao = Mockito.mock(PerfilDao.class);
		Md5Service md5Service = Mockito.mock(Md5Service.class);
		Usuario novoUsuario = new Usuario("Karine2", "karine_limp@hotmail.com", "abc123");
		
		CadastroUsuarioService service = new CadastroUsuarioService(usuarioDao, perfilDao, md5Service);
		service.cadastrarNovoUsuario(novoUsuario);
	}
	
	@Test()
	public void deve_salvar_um_usuario_no_banco_de_dados() {
		UsuarioDao usuarioDao = Mockito.mock(UsuarioDao.class);
		PerfilDao perfilDao = Mockito.mock(PerfilDao.class);
		Md5Service md5Service = Mockito.mock(Md5Service.class);
		CadastroUsuarioService service = new CadastroUsuarioService(usuarioDao, perfilDao, md5Service);
		Usuario novoUsuario = new Usuario("Karine", "karine_limp@hotmail.com", "abc123");
		
		service.cadastrarNovoUsuario(novoUsuario);
		Mockito.verify(usuarioDao, Mockito.times(1)).salvar(novoUsuario);
	}

}
