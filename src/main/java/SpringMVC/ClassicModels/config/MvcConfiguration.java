package SpringMVC.ClassicModels.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springDAO.CustomerDao;
import springDAO.CustomerDaoImpl;
import springDAO.EmployeeDao;
import springDAO.EmployeeDaoImpl;
import springDAO.OfficeDao;
import springDAO.OfficeDaoImpl;
import springDAO.OrderDao;
import springDAO.OrderDaoImpl;
import springDAO.OrderDetailDao;
import springDAO.OrderDetailDaoImpl;
import springDAO.PaymentsDao;
import springDAO.PaymentsDaoImpl;
import springDAO.ProductDao;
import springDAO.ProductDaoImpl;
import springDAO.ProductLinesDao;
import springDAO.ProductLinesDaoImpl;

@Configuration
@ComponentScan(basePackages="SpringMVC.ClassicModels")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.1");
        dataSource.setUsername("user");
        dataSource.setPassword("password");
         
        return dataSource;
    }

    @Bean
    public EmployeeDao getEmployeeDAO() {
    	return new EmployeeDaoImpl(getDataSource());
    }
    @Bean
    public CustomerDao getCustomerDAO() {
    	return new CustomerDaoImpl(getDataSource());
    }
    @Bean
    public ProductLinesDao getProductLinesDAO() {
    	return new ProductLinesDaoImpl(getDataSource());
    }
    @Bean
    public PaymentsDao getPaymentsDAO() {
    	return new PaymentsDaoImpl(getDataSource());
    }
    @Bean
    public OfficeDao getOfficeDAO() {
    	return new OfficeDaoImpl(getDataSource());
    }
    @Bean
    public ProductDao getProductDAO() {
    	return new ProductDaoImpl(getDataSource());
    }
    @Bean
    public OrderDao getOrderDAO() {
    	return new OrderDaoImpl(getDataSource());
    }
    @Bean
    public OrderDetailDao getOrderDetailDAO() {
    	return new OrderDetailDaoImpl(getDataSource());
    }

}
