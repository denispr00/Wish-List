package owish;

/*@Configuration
@EnableTransactionManagement
@ComponentScan({"owish.core.config"})
@PropertySource(value = {"classpath:application.properties"})*/
//@Configuration
// @EnableAutoConfiguration
/*@EntityScan(basePackages = {"owish.model"})
@EnableJpaRepositories(basePackages = {"owish.core.dao"})
@EnableTransactionManagement*/
public class HibernateConfiguration {

	/*@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public SessionFactory getSessionFactory() {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException(
					"factory is not a hibernate factory");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}*/
	/*@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment
				.getRequiredProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(
				environment.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(
				environment.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(
				environment.getRequiredProperty("spring.datasource.password"));
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
			throws NamingException {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(
				new String[]{"owish.model"});
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.setJpaProperties(jpaProperties());
		return factoryBean;
	}
	
	
	 * Provider specific adapter.
	 
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		return hibernateJpaVendorAdapter;
	}
	
	
	 * Here you can specify any provider specific properties.
	 
	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect",
				environment.getRequiredProperty(
						"spring.jpa.properties.hibernate.dialect"));
		// properties.put("hibernate.hbm2ddl.auto",
		// environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql",
				environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql",
				environment.getRequiredProperty("hibernate.format_sql"));
		return properties;
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}*/
}
