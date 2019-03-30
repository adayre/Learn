package com.dayre.learn.io;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOTools {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IOTools.class);
	
	private IOTools() {};

	public static void createFile(Path path) {

		LOGGER.debug("on est entré dans la méthode");
		try {
			Files.createFile(path);
			LOGGER.info("le fichier a été créé");
		} catch (FileAlreadyExistsException e) {
			LOGGER.warn("le fichier existe déjà");
		} catch (IOException e) {
			LOGGER.error("le fichier n'a pas pu être créé", e);
		}
		LOGGER.trace("c'est fini");

	}

}
