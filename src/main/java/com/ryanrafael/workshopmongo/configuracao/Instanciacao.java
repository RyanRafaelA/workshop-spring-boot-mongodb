package com.ryanrafael.workshopmongo.configuracao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ryanrafael.workshopmongo.dominio.Usuario;
import com.ryanrafael.workshopmongo.repositorio.RepositorioUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner{

	@Autowired
	private RepositorioUsuario usuarioRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		usuarioRepositorio.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
	}
	

}
