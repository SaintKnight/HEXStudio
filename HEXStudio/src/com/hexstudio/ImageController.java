package com.hexstudio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {
	@Autowired
	ServletContext servletContext;
//	@RequestMapping(value = "/imageController/{imagename}", method = RequestMethod.GET)
//	public byte[] helloWorld(@PathVariable String imagename)  {
//	  Image image = new Image();//obtain Image instance by id somehow from DAO/Hibernate
//	  image.
//	  return image.getData();
//	}
//	
	@ResponseBody
	@RequestMapping(value = "/imageController/{imagename:.+}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] testimage(@PathVariable String imagename) throws IOException {
		// Creating the directory to store file
		String rootPath = System.getProperty("catalina.home");
		File dir = new File(rootPath + File.separator + "tmpFiles");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String path = dir.getPath() + File.separator + imagename;
	    InputStream in = new FileInputStream(path);
	    byte[] r = IOUtils.toByteArray(in);
	    return r;
	}
}
