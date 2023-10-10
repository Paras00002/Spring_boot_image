package com.coforge.ImageOperation.services;


import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public interface FileService {
 String uploadImage(String path, MultipartFile file) throws IOException;

// path -> actual path where we want to upload , MultipartFile->data

 InputStream getResource(String path,String fileName) throws FileNotFoundException;

}
