package com.samsolutions.myapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

/**
 * * Spring MVC Configuration.
 * * Implements {@link WebMvcConfigurerAdapter}, which provides convenient callbacks that allow us to customize aspects of the Spring Web MVC framework.
 * * These callbacks allow us to register custom interceptors, message converters, argument resovlers, a validator, resource handling, and other things.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.samsolutions.myapp")
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * ViewResolver configuration required to work with views.
	 */
	@Bean
	ViewResolver viewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		//resolver.setPrefix("");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	/**
	 * Messages to support internationalization/localization.
	 */
	@Bean
	public MessageSource messageSource()
	{
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	/**
	 * Configuration required to work with languages(locales).
	 */
	@Bean
	public LocaleResolver localeResolver()
	{
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("myLocaleCookie");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}

	/**
	 * Add interceptors
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("mylocale");
		registry.addInterceptor(interceptor);
	}

	/**
	 * Handler class for adding a new resource to the configuration.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/css/**")
				.addResourceLocations("/css/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/img/**")
				.addResourceLocations("/img/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/js/**")
				.addResourceLocations("/js/")
				.setCachePeriod(31556926);
	}



}

