package com.ryanrafael.workshopmongo.configuracao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ryanrafael.workshopmongo.dominio.Publicar;
import com.ryanrafael.workshopmongo.dominio.Usuario;
import com.ryanrafael.workshopmongo.dto.AutorDTO;
import com.ryanrafael.workshopmongo.dto.ComentarioDTO;
import com.ryanrafael.workshopmongo.repositorio.RepositorioPublicar;
import com.ryanrafael.workshopmongo.repositorio.RepositorioUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner{

	@Autowired
	private RepositorioUsuario usuarioRepositorio;
	
	@Autowired
	private RepositorioPublicar publicarRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		usuarioRepositorio.deleteAll();
		publicarRepositorio.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
		
		Publicar pub1 = new Publicar(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(maria));
		Publicar pub2 = new Publicar(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));
		
		ComentarioDTO c1 = new ComentarioDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AutorDTO(alex));
		ComentarioDTO c2 = new ComentarioDTO("Aproveite", sdf.parse("22/03/2018"), new AutorDTO(bob));
		ComentarioDTO c3 = new ComentarioDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AutorDTO(alex));
		
		pub1.getComentario().addAll(Arrays.asList(c1, c2));
		pub2.getComentario().addAll(Arrays.asList(c3));
		
		publicarRepositorio.saveAll(Arrays.asList(pub1, pub2));
		
		maria.getPublicar().addAll(Arrays.asList(pub1, pub2));
		
		usuarioRepositorio.save(maria);
	}
	

}
