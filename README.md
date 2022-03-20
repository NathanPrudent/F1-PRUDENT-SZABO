# Application Décathlon

Projet réalisé avec l'environnement Android Studio à destination des appareils mobiles Android.  
Nous avons utilisé le langage Kotlin pour réaliser l'application.

L'application permet de faire découvrir les épreuves du décathlon, une discipline de l'athlétisme appartenant à la catégorie des épreuves combinées.

Elle se décompose en trois fragments contenues dans une activité :
- Un fragment qui contient une présentation d'accueil
- Un fragment qui affiche la liste des dix épreuves du décathlon
- Un fragment qui détail les caractéristiques d'une épreuve sélectionnée



## Classes et bibliothèques utilisées

**Ktor et Kotlin Serialization**  
Permet de récupérer un fichier json en ligne, contenant la liste des épreuves et leurs caractéristiques, à l'aide d'une requête Http puis d'utiliser, les données qu'il contient.


**ViewModel and LiveData**  
Permet de stocker la liste d'épreuves récupérée afin qu'elle ne soit pas perdue lors de l'arrêt de l'activité (rotation de l'appareil par exemple).  
Permet aussi d'être averti lors de modifications sur les données stockées.


**Coil**  
Permet d'afficher les images des différentes épreuves dans l'application.
