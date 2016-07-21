package com.ileossa.hwo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.ileossa.hwo.exceptions.EmptyFile;
import com.ileossa.hwo.exceptions.FailToUploadException;
import com.ileossa.hwo.model.DocumentModel;
import com.ileossa.hwo.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by ileossa on 12/07/16.
 */
@RestController
@RequestMapping("/documents")
public class DocumentController {

    private static final Logger log = LoggerFactory.getLogger(DocumentController.class);

    public static final String ROOT = "upload-dir";

    private final ResourceLoader resourceLoader;

    @Autowired
    DocumentRepository documentRepository;



    @Autowired
    public DocumentController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    /**
     * Permet de récupérer un fichier qui à été préalablement charger sur le serveur
     * l'url d'accès est de type
     *      home-work-organiser.com/documents/fileName.extention
     * @param filename
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {

        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Permet de charger sur le serveur un fichier, une limite de 10Mo est appliqué sur le fichier, si il dépasse le téléchargement est refusé
     * @param file
     * @param classe
     * @return
     * @throws EmptyFile
     * @throws FailToUploadException
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentModel handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam(value = "groupId") String classe) throws EmptyFile, FailToUploadException {
        classe = classe.toUpperCase();
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

    /**
     * Permet de récupérer la liste des fichier chargé par un classe
     * @param group
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<DocumentModel> getListFileWith(@RequestParam("groupId")String group){
        group = group.toUpperCase();
        return documentRepository.findByClasse(group);
    }



    @RequestMapping(method = RequestMethod.GET, value="/debug")
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
