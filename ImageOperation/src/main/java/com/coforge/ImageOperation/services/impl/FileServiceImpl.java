package com.coforge.ImageOperation.services.impl;

import com.coforge.ImageOperation.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
//       File Name Extract
         String name=file.getOriginalFilename();

         //abc.png

        //path create upto file(FullPath)  File.separator->/
       //random name generate for file
        String randomId= UUID.randomUUID().toString();
        String filename1=randomId.concat(name.substring(name.lastIndexOf(".")));

        String filePath=path+ File.separator+filename1;



//        create folder if not created
         File f=new File(path);
         if(!f.exists()){
             f.mkdir();
         }

//        file copy to fullpath
         Files.copy(file.getInputStream(), Paths.get(filePath));

         return  name;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath=path+File.separator+fileName;
        InputStream is= new FileInputStream(fullPath);
        return is;
    }
}
