package org.n52.kommonitor.importer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "io.swagger", "org.n52.kommonitor.importer", "org.n52.kommonitor.datamanagement" , "io.swagger.configuration"})
public class KommonitorImporterApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {		
		
<<<<<<< HEAD
=======
		// set special parameter directly which controls how to treat X and Y coordinates
		// for most use cases the setting must be "true"
>>>>>>> develop
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
