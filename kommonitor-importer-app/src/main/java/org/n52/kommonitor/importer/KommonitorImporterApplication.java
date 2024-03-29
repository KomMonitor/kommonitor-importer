package org.n52.kommonitor.importer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "io.swagger", "org.n52.kommonitor.importer", "org.n52.kommonitor.datamanagement" , "io.swagger.configuration"})
public class KommonitorImporterApplication implements CommandLineRunner {

	public static void main(String[] args) {		
		
		// set special parameter directly which controls how to treat X and Y coordinates
		// for most use cases the setting must be "true"
		System.setProperty("org.geotools.referencing.forceXY", "true");
		
		SpringApplication.run(KommonitorImporterApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new KommonitorImporterApplication.ExitException();
		}
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}
}
