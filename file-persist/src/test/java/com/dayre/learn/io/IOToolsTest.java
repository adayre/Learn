package com.dayre.learn.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOToolsTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(IOToolsTest.class);
	private Path tempdir;
	private Path pathfile;
	
	@Before
	public void setUp() throws Exception {
		tempdir = Files.createTempDirectory("toto");
		pathfile = Files.createFile(tempdir.resolve("./testfile"));
		LOGGER.info("Dossier temporaire: {}, Fichier temporaire: {}", tempdir.toString(), pathfile.toString());
	}

	@After
	public void tearDown() throws Exception {
		Files.delete(pathfile);
		Files.delete(tempdir);
		
	}

	@Test
	public void isFileAlreadyCreatedtest() {
		IOTools.createFile(pathfile);
		assertTrue(Files.exists(pathfile));
	}
	
	@Test
	public void isFileCreatedtest() throws IOException {
		Path newfile = tempdir.resolve("./testfile2");
		IOTools.createFile(newfile);
		assertTrue(Files.exists(newfile));
		Files.delete(newfile);
	}
	
	@Test
	public void failedCreationTest() {
		Path newfile = Paths.get("F:\\Dev\\workspace\\learn");
		IOTools.createFile(newfile);
		assertFalse(Files.exists(newfile));
	}
	

}
