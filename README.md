# LaFactory
LA Factory est une plateforme en ligne destinée à proposer des tutoriels de réalisation de modèles en papier : des origamis. La société est spécialisée dans la réalisation d’avions, mais propose aussi des animaux réels ou mystiques, et bien plus encore.
Dans un premier temps, il s’agira de proposer un outil pédagogique pour aider les visiteurs et passionnés à la réalisation de ces modèles. Il s’agit du périmètre défini dans ce document.
Dans un second temps, LA Factory organisera des cursus de formation pour concevoir et proposer de nouveaux modèles. Pour la réalisation de ce premier lot, il faudra prendre en compte l’évolutivité de la plateforme.

## Développement
L’outil devra proposer la possibilité de gérer les différents modèles, sur la base de catégories et de difficulté de réalisation. Toutes les informations sont modifiables par l’administrateur.
CATEGORIES
Elles permettent de regrouper plusieurs origamis dans une même catégorie. Ces catégories sont modifiables par l’administrateur, et peuvent contenir d’autres catégories.
• Avions
o Aircraft o Combat o Tourisme o ...
• Animaux
o Réels
▪ Chameau
▪ Ecureuil
▪ ...
MODELES D’ORIGAMIS
Chaque origami est dans une ou plusieurs catégorie(s).
INFORMATIONS GENERALES
Les informations générales de l’origami sont constituées de
• Nom
• Code unique
• Temps de réalisation
• Niveau (Occasionnel, Normal, Avancé, Expert)
• Nombre de feuilles A4 nécessaires
• Liste des étapes
• Note (1 à 5) – Moyenne des visiteurs
• Activé et disponible sur le site (pour désactiver un origami sans le supprimer)
NIVEAU
La fabrication d’un origami peut être difficile. Pour permettre à un public moins averti de s’intéresser et de s’investir dans ce domaine, les origamis ont un niveau associé : Occasionnel, Normal, Avancé ou Expert.
ETAPES
Les étapes de fabrication d’un origami sont spécifiques à chacun, et leur nombre peut varier. Ils devront être clair, précis et idéalement illustrés d’image(s). Une description accompagnera chaque étape.
Les étapes sont évidemment administrables, modifiables par l’administrateur, et doivent s’afficher dans un ordre précis (étape 1, étape 2, étape 3, ...). L’administrateur ou le technicien peuvent créer la dernière étape avant la première.
Une vidéo (lien YouTube) pourra éventuellement accompagner le tutoriel présenté.
HISTORIQUE DES VUES
Idéalement, un historique des vues sera disponible dans l’application. En plus des informations livrées par Google Analytics, les administrateurs pourront voir, pour chaque origami, l’historique des vues, triées par date (du plus récent au plus ancien). Un visiteur qui va sur la page d’un origami compte pour une vue.
MODULE VISITEUR
Les visiteurs auront accès aux fiches techniques des modèles via le site public. Ils pourront naviguer dans les catégories.
Un moteur de recherche sera idéalement proposé.
COMMENTAIRES
Les visiteurs pourront idéalement laisser des commentaires pour chaque origami. Dans ce cas, leur pseudonyme sera demandé, en plus de leur message.
Après chaque commentaire laissé, le visiteur peut attribuer, en plus du message, une note à l’origami, de 1 à 5.
BOITE A IDEE
Un outil de « boite à idée » sera proposé sur le site, leur permettant de proposer de nouvelles idées, de nouveaux modèles à apporter à la base de données. On demandera le nom, le prénom, l’adresse e-mail et la description de leur proposition.
Les administrateurs auront accès à ces idées sur l’interface d’administration. Elles pourront être archivées (elles ne seront plus visibles sur l’interface mais existeront toujours en base de données) par l’administrateur.
ACCES ET SECURITE
Il faudra que l’accès à l’ensemble des fonctionnalités soit sécurisé et authentifié, via un nom d’utilisateur et un mot de passe.
Un système d’identification sera proposé en fonction du profil connecté :
• Administrateur (accès à tout)
• Visiteur (accès libre au portail – pas de connexion nécessaire)
