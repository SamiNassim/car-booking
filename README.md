# Car booking tool

Un outil de location de voitures que j'ai créé grace à une formation que je suis en train de suivre sur internet. </br>
Il y a plusieurs bugs que je corrigerai au fur et à mesure de mon avancé dans la formation :

- Un utilisateur peut choisir un numéro de véhicule qui ne lui est pas proposé ou qui n'existe pas, ce qui crée une location avec un objet Car null.
- Si un utilisateur loue un véhicule électrique (Tesla dans cet outil), elle sera toujours affichée dans la liste des véhicules électriques disponible (Choix 5). </br>C'est dû au fait qu'il existe un array différent pour les véhicules électriques. </br>Une possible correction serait de mettre tous les véhicules dans le même array et créer une méthode qui renvoie uniquement les véhicules électriques avec le choix numéro 5.
- Et probablement plein d'autres encore... 🥲