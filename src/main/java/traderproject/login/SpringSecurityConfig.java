package traderproject.login;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource authDataSource;

    //@Autowired
    public void setDataSource(DataSource dataSource){
        this.authDataSource = dataSource;
    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login")).and().authorizeRequests()
				.antMatchers("/stocks").authenticated().antMatchers("/stocks/*").authenticated().antMatchers("/act").authenticated().and().formLogin().defaultSuccessUrl("/stocks")
				.loginPage("/login").and().logout().permitAll();
		http.exceptionHandling().accessDeniedPage("/403");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		/****demo static*******/
		
		//auth.inMemoryAuthentication().withUser("manthos").password("12345").roles("USER");
		
		/****end static*******/
		
		auth.jdbcAuthentication().dataSource(authDataSource).usersByUsernameQuery("select username,password, enable_ac from Customers where username=?")
        .authoritiesByUsernameQuery("select username,password,enable_ac from Customers where username=?");
	}

}