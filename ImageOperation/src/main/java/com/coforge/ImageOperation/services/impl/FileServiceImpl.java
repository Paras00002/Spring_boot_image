package com.coforge.ImageOperation.services.impl;

import com.coforge.ImageOperation.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
//       File Name Extract
         String name=file.getOriginalFilename();

//        path create upto file(FullPath)  File.separator->/
         String filePath=path+ File.separator+name;

//        create folder if not created
         File f=new File(path);
         if(!f.exists()){
             f.mkdir();
         }

//        file copy to fullpath
         Files.copy(file.getInputStream(), Paths.get(filePath));

         return  name;
    }
}
