package org.khshrd.app.configuration;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;


@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter{

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	
		registry.addViewController("/admin/").setViewName("/admin/dashboard");
		registry.addViewController("/admin/dashboard").setViewName("/admin/dashboard");
		registry.addViewController("/admin/user-cu").setViewName("/admin/user-cu");
		registry.addViewController("/admin/user-list").setViewName("/admin/user-list");
		registry.addViewController("/admin/role-cu").setViewName("/admin/role-cu");
		registry.addViewController("/admin/role-list").setViewName("/admin/role-list");
		
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
		
		registry.addResourceHandler("file/**").addResourceLocations("file/opt/FILES_MANAGEMENT/images/");
	}
	//1
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("kh"));
        resolver.setCookieName("Spring_Local");
        resolver.setCookieMaxAge(4800);
        return resolver;
    }

    //2 to set parameter e.g ?lang=kh
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    //3 to call localeChangeInterceptor to work
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(localeChangeInterceptor());

    }

    //4
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/i18n/message");
        messageSource.setCacheSeconds(0);
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

	
}
