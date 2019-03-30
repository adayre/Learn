package com.dayre.learn;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.dayre.learn.io.IOTools;


public class App 
{
	
    public static void main( String[] args )
    {
    	
        List<Path> pathList = Arrays.asList("bla.txt",
        		"FileTest.txt",
        		"AnotherFile.txt").stream().map(Paths::get).collect(Collectors.toList());
    	
    	IOTools.createZipFile(pathList, "./zipTest.doc");

    }
}
