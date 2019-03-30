package com.dayre.learn.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOTools {

	private static final Logger LOGGER = LoggerFactory.getLogger(IOTools.class);

	private IOTools() {
	};

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

	public static void createZipFile(List<Path> files, String zipname) {

		String fileName = getExtensionFile(zipname);
		try (OutputStream fos = new FileOutputStream(fileName)) {
			try (OutputStream bos = new BufferedOutputStream(fos)) {
				try (ZipOutputStream zos = new ZipOutputStream(bos)) {
					for (Path path : files) {
						zos.putNextEntry(new ZipEntry(path.toString()));
						zos.closeEntry();
					}
				}
			}
		} catch (IOException e) {
			LOGGER.error("ERREUR", e);
		}
	}

	private static String getExtensionFile(String zipname) {

		final String requiredString = ".zip";
		if (!FilenameUtils.getExtension(zipname).equals(requiredString)) {
			zipname = FilenameUtils.getFullPath(zipname)+FilenameUtils.getBaseName(zipname)+requiredString;
		}
		return zipname;

	}

}
