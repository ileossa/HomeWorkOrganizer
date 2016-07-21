package com.ileossa.hwo;

import com.ileossa.hwo.controller.DocumentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.util.FileSystemUtils;


/**
 * @author ileossa
 *
 */


/**
 * Main permettant de lancer toute l'application.
 * Pour executer faire clique droit, puis executer.
 * Regarder dans la console(qui doit s'afficher) les différents LOGs indiquant le démarrage de l'application
 * Si le message application launched apparait vous pouvez allez sur l'url définis est le port spécifié,
 * par défaut locahost:8080
 *
 * Pour pouvoir changer la configation
 * dans la dossier ressources/application.yml, contient les diverses informations permettant de changer le nom de l'application, définirs les prioritées des LOGs (warning, debug, error, info)
 * les logs qui apparaissent dans la consoles sont stocké aussi dans le dossier LOGS à la racine du projet, ils peuvent être utilisé par divers outils de tracking d'anomalies et de suivis d'incident.
 *
 * Reglage des règles de l'upload de fichier
 *  il limite de 10 Mo par fichier à été définies, avec les règles suivantes
 *                  multipart:
 *                            max-file-size: 10Mb
 *                            max-request-size: 10Mb
 *
 * Des profils on été aussi configuré pour facilité la maintenance, sur la ligne 1 de application.yml, on peut voir les parametres
 *                          spring:
 *                               profiles:
 *                                    active: dev
 *Pour active l'un des profile changer la valeur dev par  test/prod/dev
 *
 *
 * ARCHITECTURE DE L'APPLICATION
 * configuration/
 *      DatabaseConfig          :   permet d'initialiser les connecteur à la base de donnée au lancement de l'application utilisé uniquement si le profil "prod" est activé dans ressources/application.yml
 *
 * controller/
 *      ActuController          :   entrée sur le service pour pouvoir accéder, mofidier, créer, supprimer une actilité suivant des paramètres ou des filtres
 *      DiscussionController    :   entrée sur le service pour pouvoir accéder, mofidier, créer, supprimer une discution entre deux utilisateurs suivant des paramètres ou des filtres
 *      DocumentController      :   entrée sur le service pour pouvoir charger ou télécharger un document sur le serveur pour le mettre à disposition uniquement de ça classe
 *      EventController         :   entrée sur le service pour pouvoir accéder, mofidier, créer, supprimer un evenement suivant des paramètres ou des filtres
 *      ForumCOntroller         :   entrée sur le service pour pouvoir accéder, mofidier, créer, supprimer un forum suivant des paramètres ou des filtres
 *      HomeController          :   entrée sur le service qui affiche un simple message de bienvenus au utilisateur du service
 *      ResponseController      :   entrée sur le service pour pouvoir accéder, mofidier, créer, supprimer une reponse suivant divers critères
 *      UserController          :   entrée sur le service pour pouvoir accéder, mofidier, créer, supprimer un utilisateur du service suivant des paramètres ou des filtres
 *
 *  exceptions/
 *      ActuNotFoundException   :   permet de gérer les erreurs du controller ActuController
 *      DiscussionNotFoundException : permet de gérer les erreurs du controller DiscussionController
 *      EmptyFile               :   permet de gérer les erreurs du controller DocumentController
 *      EventNotFoundException  :   permet de gérer les erreurs du controller EventController
 *      FailToUploadException   :   permet de gérer les erreurs du controller DocumentController
 *      UserCreateExecption     :   permet de gérer les erreurs du controller UserController
 *      UserNotFoundException   :   permet de gérer les erreurs du controller UserController
 *
 *  model/
 *      ActuModel               :   définition de l'object et ainsi que de table en base de donnée
 *      DiscussionModel         :   définition de l'object et ainsi que de table en base de donnée
 *      DocumentModel           :   définition de l'object et ainsi que de table en base de donnée
 *      EventModel              :   définition de l'object et ainsi que de table en base de donnée
 *      ForumModel              :   définition de l'object et ainsi que de table en base de donnée
 *      ResponseModel           :   définition de l'object et ainsi que de table en base de donnée
 *      UserEnum                :   définition de l'object et ainsi que de table en base de donnée
 *      UserModel               :   définition de l'object et ainsi que de table en base de donnée
 *
 * repository/
 *      ActuRepository          :   définition du prototype pour récupérer la List des Actualitées en base de donnée( cf: controller/ActuController)
 *      DiscusionRepository     :   définition du protoype pour récupérer la liste des discutions suivant leur id (cf: controller/DiscussionController)
 *      DocumentRepository      :   définition du protoype pour récupérer la liste des documents uploader suivant les filtres définis dans la requete (cf: controller/DocumentController)
 *      EventRepository         :   définition du protoype pour récupérer la liste des évènements par classe (cf : controller/EventController)
 *      ForumRepository         :   définition du protoype pour récupérer la liste des forums suivant les critères (cf : controller/ForumController)
 *      ResponseRepository      :   définition du protoype pour récupérer la liste des réponses au discution suivant le critere l'identifiant de la discution  (cf : controller/ReponseController)
 *      UserRepository          :   définition du protoype pour récupérer la liste des utilisateurs par leur email ou pseudo ou leur appartenance à un classe. (cf: controller/UserController)
 *
 *
 *
 * Vous pouvez gérer les dépendances de l'application grâce à Maven (vers 3) est les dépots près configuré de spring-boot, vous pouvez rajouter aussi n'import qu'elle package  se trouvant sur maven-central, ou bien personnel.
 *
 *
 *
 */
@SpringBootApplication
public class LauncherApp {

	private static final Logger log = LoggerFactory.getLogger(LauncherApp.class);

	public static void main(String[] args) {
		SpringApplication.run(LauncherApp.class);
	}


    /**
     * La commande est executé au lancement de l'application est efface le contenus du dossier upload-dir
     * @return
     */
    @Bean
    CommandLineRunner init() {
        return (args) -> {
            FileSystemUtils.deleteRecursively(new File(DocumentController.ROOT));

            Files.createDirectory(Paths.get(DocumentController.ROOT));


        };
    }



}
