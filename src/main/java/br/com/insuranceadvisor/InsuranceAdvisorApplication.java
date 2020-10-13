package br.com.insuranceadvisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class InsuranceAdvisorApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceAdvisorApplication.class);

	public static void main(String[] args) {
		try{
			LOGGER.info("Initializing InsuranceAdvisorApplication Application...");
			new SpringApplicationBuilder()
					.bannerMode(Banner.Mode.LOG)
					.sources(InsuranceAdvisorApplication.class)
					.run(args);
			LOGGER.info("InsuranceAdvisorApplication has completed startup");
			System.gc();
		} catch (Exception e) {
			LOGGER.error("Exception when starting InsuranceAdvisorApplication", e);
			System.exit(1);
		}
	}
}
