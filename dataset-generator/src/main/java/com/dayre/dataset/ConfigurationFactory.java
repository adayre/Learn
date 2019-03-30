package com.dayre.dataset;

import java.io.IOException;
import java.nio.file.Path;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class ConfigurationFactory {

	
	private ConfigurationFactory() {
		
	}
	
	public static Configuration getConfiguration(Path templateFolder) throws IOException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);


		FileTemplateLoader ftl = new FileTemplateLoader(templateFolder.toFile());
		ClassTemplateLoader ctl = new ClassTemplateLoader(Configuration.class, "/templates/");
		MultiTemplateLoader mtl = new MultiTemplateLoader(new TemplateLoader[] { ftl, ctl });
		cfg.setDefaultEncoding("UTF-8");

		// Sets how errors will appear.
		// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
		cfg.setLogTemplateExceptions(false);
		// Wrap unchecked exceptions thrown during template processing into TemplateException-s.
		cfg.setWrapUncheckedExceptions(true);
		
		cfg.setTemplateLoader(mtl);
		return cfg;
	}
	
	public static Configuration getConfiguration()  {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);

		ClassTemplateLoader ctl = new ClassTemplateLoader(Configuration.class, "/templates/");
		cfg.setDefaultEncoding("UTF-8");

		// Sets how errors will appear.
		// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
		cfg.setLogTemplateExceptions(false);
		// Wrap unchecked exceptions thrown during template processing into TemplateException-s.
		cfg.setWrapUncheckedExceptions(true);
		
		cfg.setTemplateLoader(ctl);
		return cfg;
	}
}
