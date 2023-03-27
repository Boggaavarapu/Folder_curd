package com.springapllication.Application1.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import com.springapllication.Application1.Model.Folder;
import com.springapllication.Application1.Repository.DFolderRepository;


@Service
public class Services {

	@Autowired
	private DFolderRepository Frepo;

	public List<Folder> getallFolders(){
		return Frepo.findAll();
	}

}
