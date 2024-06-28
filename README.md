# Event App

### Prérequis

* JDK Java 17 ou plus récent
* Node 18 ou plus récent
* Docker et Docker Compose

### Lancer les tests back-end

1. Assurez-vous que Docker est lancé, car les tests d'intégration utilisent un conteneur Postgres pour la base de
   données,

2. Exécutez la commande suivante dans un terminal, à la racine du projet:

```
./mvnw test
```

### Lancer les tests frontend

1. Installez les dépendances:

```
cd /frontend
npm install
```

2. Lancez les tests

```
npm run test:unit
```

### Lancer le front-end et le back-end

1. Lancez un build du front-end:

```
cd /frontend
npm run build
```

2. Lancez le back-end:

```
./mvnw spring-boot:run
```

3. Visitez http://localhost sur votre navigateur.

Points à considérer:

<ul>
  <li>Un docker-compose (Postgres et Nginx) sera lancé par Spring-boot. Vous pouvez consultez la configuration dans le fichier compose.yaml.</li>
  <li>Vous trouverez la configuration Nginx dans le fichier nginx/default.conf</li>
  <li>La configuration Nginx utilise host.docker.internal pour appeler la machine host depuis le conteneur Nginx. Ceci fonctionne sous Windows/MacOs mais il semble que ce ne soit pas le cas sous Linux.</li>
</ul>

Consultez
cet [article]("https://medium.com/@TimvanBaarsen/how-to-connect-to-the-docker-host-from-inside-a-docker-container-112b4c71bc66")
si vous êtes sous Linux.

### Documentation OpenAPI / Swagger

Le json contenant la documentation swagger est disponible à cette adresse:

http://localhost/api/api-docs

Une documentation swagger interactive est également disponible:

http://localhost/api/swagger-ui/index.html

### Discussion

<ul>
    <li>Ça faisait un moment que je n'avais pas touché à VueJS, et j'ai découvert ViteJS. J'ai beaucoup aimé les améliorations depuis la version 2 de Vue, mais j'ai du lire pas mal de doc :-).</li>
    <li>Je trouve super pratique de développer en Vue.js en utilisant la commande npm run dev, qui lance le serveur vite. Pour l'instant, cela demande de simuler les réponces du back-end, mais j'aimerais savoir s'il existe un moyen d'utiliser un vrai back-end pendant le développement du front-end.</li>
    <li>Je comprends que le choix de Java / Spring Boot n'est peut-être pas le plus intuitif pour plusieurs dev, mais c'est le framework que j'ai utilisé au cours des deux dernières années, et j'estime qu'il m'a ammené à relever mon jeu de développeur d'un cran. J'étais également motivé par le fait de monter un projet Spring Boot from scratch. J'ai essayé pour la première fois l'intégration de Spring Boot / Docker compose, et je trouve ça pas mal.</li>
    <li>Les tests d'intégration utilise une vrai BD postgres. Cela aurait été beaucoup plus simple d'utiliser une BD H2, mais j'avais envie d'essayer l'option de tester avec Docker, puisque le fait d'utiliser des BD H2 peuvent parfois entrainer des inconcruités.</li>
    <li>Il n'y a pas de gestion de migration BD dans le projet, c'est assumé :-)</li>
</ul>

### Questions / Commentaires

N'hésitez pas à m'écrire à francislafort@gmail.com pour toute question, ou si j'ai oublié quelque chose.
Au plaisir!



