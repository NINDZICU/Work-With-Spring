package ru.kpfu.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * Created by Anatoly on 01.03.2017.
 */
public class WebInitializer extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext cfg = new AnnotationConfigWebApplicationContext();
        cfg.register(Config.class);
        return cfg;
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
