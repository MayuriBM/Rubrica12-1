package es.salesianos.edu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

import de.agilecoders.wicket.core.Bootstrap;
import es.salesianos.edu.webpages.AuthorPage;
import es.salesianos.edu.webpages.HomePage;
//esto no vaaa
@Component
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class WicketWebApplication extends WebApplication{
	private static final Logger logger = LogManager.getLogger(WicketWebApplication.class.getName());

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(WicketWebApplication.class, args);

    }

    @Override
    public Class<HomePage> getHomePage() {
		return HomePage.class;
    }

    
    
    
    @Override
    protected void init() {
        super.init();
		Bootstrap.install(this);
		getResourceSettings().setResourcePollFrequency(Duration.ONE_SECOND);
        getComponentInstantiationListeners().add(
                new SpringComponentInjector(this, applicationContext));
		new AnnotatedMountScanner().scanPackage("es.salesianos.edu.webpages").mount(this);
		logger.info("initializated webpage");
    }

}
