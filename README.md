# My-android-app


Ce readme est disponible en deux langues: [Anglais](#english) et [Français](#français)
This readme has two languages : [English](#english) and [French](#français)

## Français:

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
![Webp net-resizeimage](https://user-images.githubusercontent.com/61503552/109715593-21fcca00-7ba4-11eb-9703-a0ae1cc4fc11.jpg)




## English:


***APPLICATION STRUCTURE***

The app contains 5 activities in total, the main one which has 4 buttons which takes you to different 4 different activities (cooking activity, temperature, fuel, speed) and a 5th button which launches an implicit intention (I chose the camera )

![screenshot_2021-03-02-21-16-17](https://user-images.githubusercontent.com/61503552/109715444-f24dc200-7ba3-11eb-9096-5deba8c08d06.jpg)



***"CONVERT" ACTIVITIES***

the 4 activities have a similar structure, I chose to implement the conversion with radio groups, you just need to enter the value and choose the unit you want to convert, it will automatically convert the selected unit to all other units.

![05b978fd-7697-4565-8a64-325e619be457](https://user-images.githubusercontent.com/61503552/109714705-080eb780-7ba3-11eb-88f8-6498737f8377.gif)



the best way to think about minimizing the amount of code needed is to choose a base unit (km / h for example) and create functions that convert to and from that base unit, so if the user selects one unit which is not the base unit, we convert the chosen unit to the base unit, then we convert to all other units using the base unit



***Persistence***

I used SharedPreferences to save the value entries of all units


***XML values and translation***
I put each text string in the string.xml, and everything translates fine


***Spinner***
For the Spinner, I chose to make a spinner that allows me to switch between different unit converters without going back to the main activity
![Webp net-resizeimage](https://user-images.githubusercontent.com/61503552/109715593-21fcca00-7ba4-11eb-9703-a0ae1cc4fc11.jpg)





