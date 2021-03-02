# My-android-app

***STRUCTURE DE L'APPLICATION***
L'application contient 5 activités au total, la principale qui a 4 boutons qui vous emmène à différentes 4 activités différentes (activité de cuisson, température, carburant, vitesse) et un 5ème bouton qui lance une intention implicente (j'ai choisi la caméra)

![screenshot_2021-03-02-21-16-17](https://user-images.githubusercontent.com/61503552/109715444-f24dc200-7ba3-11eb-9096-5deba8c08d06.jpg)



***ACTIVITÉS «CONVERTIR»***
les 4 activités ont une structure similaire, j'ai choisi d'implémenter la conversion avec des groupes radio, il vous suffit d'entrer la valeur et de choisir l'unité que vous souhaitez convertir, elle convertira automatiquement l'unité sélectionnée en toutes les autres unités.

![05b978fd-7697-4565-8a64-325e619be457](https://user-images.githubusercontent.com/61503552/109714705-080eb780-7ba3-11eb-88f8-6498737f8377.gif)



la meilleure façon de penser pour minimiser la quantité de code nécessaire est de choisir une unité de base (km / h par exemple) et de créer des fonctions qui convertissent vers et à partir de cette unité de base, donc si l'utilisateur sélectionne une unité qui n'est pas la base unité, nous convertissons l'unité choisie en unité de base, puis nous convertissons en toutes les autres unités en utilisant l'unité de base



***Persitance***

J'ai utilisé SharedPreferences pour enregistrer les entrées de valeur de toutes les unités


***Valeurs XML et traduction***
J'ai mis chaque chaîne de texte dans le string.xml, et tout se traduit bien


***Spinner***
Pour le Spinner, j'ai choisi de faire un spinner qui me permet de basculer entre différents convertisseurs d'unités sans revenir à l'activité principale
