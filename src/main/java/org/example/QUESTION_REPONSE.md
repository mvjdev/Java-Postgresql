### 1)
#### a. C’est quoi un variable d’environnement ?

##### Reponse:
   ```
Un variable d'environnement est :
       - Un stockage des informations sensibles 
       - Comme les identifiants de connexion à une base de données, 
       - Afin de ne pas les inclure directement dans le code source,
       - Ce qui pourrait présenter des risques de sécurité
       - Définies sur le système où elle s'execute.
       
```

#### b. A quel moment le variable est-il créé ?

##### Reponse:
```
Les variables d'environnement sont créées et gérées par le système d'exploitation.
Elles peuvent être définies à différents moments et de différentes manières :

    1. Au démarrage du système : (Ces variables sont souvent définies par le système d'exploitation lui-même pour 
    configurer des paramètres globaux)
    2. Lors de l'exécution de scripts ou de commandes : (Définir des variables d'environnement 
    lors de l'exécution de scripts ou de commandes dans un terminal.)
    3. Dans des fichiers de configuration système : ( Sur Linux, les variables peuvent être définies dans des fichiers 
    comme .bashrc, .bash_profile, ou d'autres fichiers de profil utilisateur.)
    4. Lors de l'exécution d'une application : (Par exemple, une application Java peut utiliser System.setEnv() 
    pour définir des variables d'environnement spécifiques à son exécution.)
    5. Par l'utilisateur : (souvent en utilisant des fichiers de configuration tels que .bashrc, .profile,)
    6. Lors de l'installation de logiciels : (Pour configurer leur comportement ou pour indiquer l'emplacement 
    de leurs fichiers de configuration.)
    
Ces variables peuvent être temporaires 
(valables uniquement pour la session en cours) 
ou permanentes, selon la manière dont elles sont définies et où elles sont déclarées.

```

#### c. Peut-on changer la valeur d’un variable d’environnement lorsque l’application est en marche ?

##### Reponse:

```
Oui, on peut changer la valeur d'un variable
Dans le langage Java, System.setEnv() modifie les variables d'environnement de l'application Java en cours d'exécution. 
Cependant, cela affecterait uniquement l'environnement de l'application Java 
et ne serait pas visible par d'autres processus ou applications.
```

