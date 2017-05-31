package ru.kpfu.config;

import org.jtwig.web.servlet.JtwigRenderer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.jtwig.spring.JtwigViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import java.util.Locale;

/**
 * Created by Anatoly on 28.02.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ru.kpfu")
public class Config extends WebMvcConfigurerAdapter {
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        JtwigViewResolver resolver = new JtwigViewResolver();
//        resolver.setRenderer(JtwigRenderer.defaultRenderer());
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/calculator");
        registry.addViewController("/calc").setViewName("calculator");
        registry.addViewController("/feedback").setViewName("index");
        registry.addViewController("/information").setViewName("index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        // registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("WEB-INF/locales/messages", "WEB-INF/locales/ValidationMessages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(0);
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(4800);
        return resolver;
    }
//    @Bean
//    public LocaleResolver localeResolverSession{
//        SessionLocaleResolver resolver = new SessionLocaleResolver();
//        resolver.setDefaultLocale(new Locale("en"));
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }
//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource(){
//        ReloadableResourceBundleMessageSource rrbms = new ReloadableResourceBundleMessageSource();
//        rrbms.setBasename("/locales/ValidationMessages");
//        rrbms.setDefaultEncoding("UTF-8");
//        return rrbms;
//    }
//    @Bean
//    @Interceptors(Config.class)
//    @AroundInvoke
//    public LocaleChangeInterceptor localeChangeInterceptor(){
//        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
//        interceptor.setParamName("lang");
//        return interceptor;
//    }
//    @Bean
//    public CookieLocaleResolver localeResolver(){
//        CookieLocaleResolver resolver = new CookieLocaleResolver();
//        resolver.setDefaultLocale(Locale.ENGLISH);
//        return resolver;
//    }
//    @Bean
//    public DefaultAnnotationHandlerMapping handlerMapping(){
//        DefaultAnnotationHandlerMapping mapping = new DefaultAnnotationHandlerMapping();
//        mapping.setInterceptors(localeChangeInterceptor());
//        return mapping;
//    }
}
