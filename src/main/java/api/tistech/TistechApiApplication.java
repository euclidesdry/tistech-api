package api.tistech;

import api.tistech.config.DefaultProfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;
import org.springframework.web.WebApplicationInitializer;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class TistechApiApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	private static final Logger log = LoggerFactory.getLogger(TistechApiApplication.class);

	@SuppressWarnings("unused")
	@Autowired
	private Environment env;

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(TistechApiApplication.class);

		DefaultProfileUtil.addDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
				"Application '{}' is running! Access URLs:\n\t" +
				"Local: \t\thttp://127.0.0.1:{}\n\t" +
				"External: \thttp://{}:{}\n----------------------------------------------------------",
			env.getProperty("spring.application.name"),
			env.getProperty("server.port"),
			InetAddress.getLocalHost().getHostAddress(),
			env.getProperty("server.port"));
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TistechApiApplication.class);
	}

}
