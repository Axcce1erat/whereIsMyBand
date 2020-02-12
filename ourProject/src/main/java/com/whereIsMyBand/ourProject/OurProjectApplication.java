package com.whereIsMyBand.ourProject;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.apache.catalina.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.stereotype.Controller;


import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
@SpringBootApplication
public class OurProjectApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(OurProjectApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	

	 @Bean
      public ServletWebServerFactory servletContainer() {
                TomcatServletWebServerFactory tomcatContainer = new TomcatServletWebServerFactory() {
                        @Override
                        protected void postProcessContext(Context context) {
                                SecurityConstraint constraint = new SecurityConstraint();
                                constraint.setUserConstraint("CONFIDENTIAL");
                                SecurityCollection securityCollection = new SecurityCollection();
                securityCollection.addPattern("/*");
                constraint.addCollection(securityCollection);
                context.addConstraint(constraint);
                        }
                };
                tomcatContainer.addAdditionalTomcatConnectors(redirectConnectorHttp());
                return tomcatContainer;
        }

        private Connector redirectConnectorHttp() {
                Connector redirectConnector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
                redirectConnector.setScheme("http");
                redirectConnector.setPort(8080);
                redirectConnector.setSecure(false);
                redirectConnector.setRedirectPort(8443);
                return redirectConnector;
        }


}
