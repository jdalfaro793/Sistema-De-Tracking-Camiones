package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.repository.ILocalidad;

@SpringBootApplication
public class TpFinalBetaApplication implements CommandLineRunner{

	@Autowired
	ILocalidad localidadImp;
	@Autowired
	Localidad localidad;
	
	public static void main(String[] args) {
		SpringApplication.run(TpFinalBetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//localidad.setNombre("Jujuy");
		//localidadImp.save(localidad);
	}

}
