package projet.lafactory.config;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan({ "projet.lafactory.controller" })
@EnableWebMvc
//@EnableJpaRepositories("fr.tetris.dao")
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

	@PostConstruct
	public void init() {
		requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}

//	@Bean
//	public UrlBasedViewResolver viewResolver() {
//		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
//
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/views/");
//		viewResolver.setSuffix(".jsp");
//
//		return viewResolver;
//	}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");

		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();

		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.setEnableSpringELCompiler(true);

		return templateEngine;
	}

	@Bean
	public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}
	
	


	//@Bean
	//public BasicDataSource dataSource() {
		//BasicDataSource dataSource = new BasicDataSource();

		//dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//dataSource.setUrl("jdbc:mysql://localhost:3306/tetris");
		//dataSource.setUsername("root");
//		dataSource.setPassword("");
	//	dataSource.setMaxTotal(10);

		//return dataSource;
	//}

	//@Bean
	//public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
		//LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		//JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

//		emf.setDataSource(dataSource);
//		emf.setPackagesToScan("projet.lafactory.model");
	//	emf.setJpaVendorAdapter(vendorAdapter);
		//emf.setJpaProperties(this.hibernateProperties());

		//re/turn emf;
	//}

	//private Properties hibernateProperties() {
//		Properties properties = new Properties();

		//properties.setProperty("hibernate.hbm2ddl.auto", "update");
		//properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		//properties.setProperty("hibernate.show_sql", "true");
//		properties.setProperty("hibernate.format_sql", "false");

//		return properties;
	//}

	//@Bean
	//public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		//JpaTransactionManager transactionManager = new JpaTransactionManager();

		//transactionManager.setEntityManagerFactory(emf);
		//return transactionManager;
	//}
}