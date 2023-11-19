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
#### 2)
#### a. C'est quoi une annotation en Java

##### Reponse:

```
a) En Java, une annotation est une instruction spéciale ajoutée au code 
pour donner des indications au compilateur ou à d'autres outils sans affecter directement le code.
```

#### b) Comment peut-on créer une annotation personnalisée en Java ? Illustrez en créant une annotation personnalisée appelée @MyFirstAnnotation.

##### Reponse:

```
b) Pour créer une annotation personnalisée (@MyFirstAnnotation), utilisez @interface.

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyFirstAnnotation {
    String value() default "default value";
    int number() default 0;
}
```

#### c) Que signifie l’annotation @Override ?

##### Reponse:

```
c) L'annotation @Override dit au compilateur 
qu'une méthode dans une classe enfant remplace une méthode héritée 
de sa classe parente, évitant ainsi les erreurs de typographie.
```