package com.javainuse.services;

import java.io.IOException;
import java.util.Optional;

import com.javainuse.daos.ImageRepository;
import com.javainuse.models.ImageModel;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageModelServicio extends ServicioGenerico<ImageModel, ImageRepository> {

    public ImageModel save(MultipartFile file) throws Exception {
        
 
      try {

        ImageModel img = new ImageModel(0l,file.getOriginalFilename(), file.getContentType(),
        file.getBytes());

      return  this.repository.save(img);

    } catch (Exception e) {

        throw new Exception(e.getMessage());
    }
}
public ImageModel findByName(String imageName) throws Exception {
    try {
  
      final Optional<ImageModel> retrievedImage =this.repository.findByName(imageName);		
      ImageModel img = retrievedImage.get();
      return img;     

  } catch (Exception e) {

      throw new Exception(e.getMessage());
  }
}
}