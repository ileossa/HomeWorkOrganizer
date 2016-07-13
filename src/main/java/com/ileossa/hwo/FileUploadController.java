package com.ileossa.hwo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import com.ileossa.hwo.exceptions.EmptyFile;
import com.ileossa.hwo.exceptions.FailToUploadException;
import com.ileossa.hwo.model.DocumentModel;
import com.ileossa.hwo.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by ileossa on 12/07/16.
 */
@RestController
@RequestMapping("/form")
public class FileUploadController {

    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    public static final String ROOT = "upload-dir";

    private final ResourceLoader resourceLoader;

    @Autowired
    DocumentRepository documentRepository;



    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }



    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {

        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentModel handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam(value = "group") String classe) throws EmptyFile, FailToUploadException {

        DocumentModel documentModel;
        if (!file.isEmpty()) {
            try {
                Files.copy(file.getInputStream(), Paths.get(ROOT, file.getOriginalFilename()));
                // insert BDD
                 documentModel = new DocumentModel(classe,file.getOriginalFilename(), Paths.get(ROOT, file.getOriginalFilename()).toString() ,true);
                documentRepository.save(documentModel);
            } catch (IOException |RuntimeException e) {
                throw new FailToUploadException();
            }
        } else {
            throw  new EmptyFile();
        }
        return documentModel;
    }



    @RequestMapping(method = RequestMethod.GET)
    public File[] listFiles(){

        File directory = new File(ROOT);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
        return fList;
    }



    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
            }
        }
    }
}
