package com.dayre.learn;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dayre.learn.io.IOTools;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	
    public static void main( String[] args )
    {
    	
    	Path path = Paths.get("D:\\Dev\\workspace\\learn\\toto.gitignore");
    	IOTools.createFile(path);
    	LOGGER.error("blabla");
    }
}
