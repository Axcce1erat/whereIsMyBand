package com.whereIsMyBand.demo;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.apache.catalina.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.sql.*;

import org.springframework.context.annotation.Bean;

@Controller
@SpringBootApplication
public class DemoApplication {

	static Connection con;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
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
