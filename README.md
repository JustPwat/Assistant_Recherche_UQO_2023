# Find_Phone_Numbers_On_LinkedIn

---- Guide d’installation ----


[ Télécharger Appium Desktop ]

- Ouvrir la page GitHub d'Appium Desktop - https://github.com/appium/appium-desktop/releases  
On y retrouve les différents paquets pour Windows, Mac, Linux, etc. 

- Cliquer sur la version de notre choix pour la télécharger et la sauvegarder sur notre machine. 
- Suivre les étapes pour installer Appium Server GUI sur notre machine 
Pour vérifier que l'installation et la configuration ont réussi, cliquer sur le bouton startServer. Cela démarrera le serveur Appium et nous verrons le message 'The server is running' dans la fenêtre d'Appium. 


[ Télécharger Java et configurer les variables d’environnement ]

- Télécharger la version 8 Update 361 -> Java™ SE Development Kit 8, Update 361 Release Notes (oracle.com) 
- Ouvrir le menu des variables d’environnement 
- Copier l’emplacement du dossier JDK et ajouter une nouvelle variable JAVA_HOME 
- Double-cliquer sur Path et créer une autre variable : %JAVA_HOME%\bin; %JAVA_HOME%\lib   
- Appliquer les changements en cliquant sur le bouton Ok. 

 

[ Télécharger Android Studio et les composants additionnels ]

- Télécharger et suivre les étapes d’installation pour Android Studio Download Android Studio & App Tools - Android Developers 
- Ouvrir Android Studio et aller dans Tools > SDK Manager 
- S’assurer d’avoir télécharger la version 11 d’Android  
- Aller sur l’onglet SDK Tools et sélectionner les composantes suivantes (d’autres composantes peuvent être rajouter par la suite) :  
Android SDK Build-Tools 34-rc(#) 
Android Emulator 
Android SDK Plaform-Tools 
Intel x86 Emulator Accelerator (HAXM installer) 

-Cliquer sur Apply pour télécharger le tout 

[ Configurer les variables d’environnements d’Android ]

- Ouvrir le menu des variables d’environnement 
- Créer deux variables en copiant l’emplacement des dossier Android SDK suivant (Exemple):  
ANDROID_HOME = C:\Users\NameOfUser\AppData\Local\Android\Sdk 
ANDROID_SWT = C:\Users\NameOfUser\AppData\Local\Android\Sdk\tools\lib\x86_64 

- Double-cliquer sur Path et créer une autre variable = ;%ANDROID_HOME%\platform-tools;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin  
- Appliquer les changements en cliquant sur le bouton Ok. 

 
