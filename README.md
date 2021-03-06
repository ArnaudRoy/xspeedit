# xspeedit
speedit - projet test - voyages-sncf.com

--------
*source :*
>XspeedIt
>========
>
>XspeedIt est une société d'import / export ayant robotisé toute sa chaîne d'emballage de colis.  
>Elle souhaite trouver un algorithme permettant à ses robots d'optimiser le nombre de cartons d'emballage utilisés.
>
>Les articles à emballer sont de taille variable, représentée par un entier compris entre 1 et 9.  
>Chaque carton a une capacité de contenance de 10.  
>Ainsi, un carton peut par exemple contenir un article de taille 3, un article de taille 1, et un article de taille 6.
>
>La chaîne d'articles à emballer est représentée par une suite de chiffres, chacun représentant un article par sa taille.  
>Après traitement par le robot d'emballage, la chaîne est séparée par des "/" pour représenter les articles contenus dans un carton.
>
>*Exemple*  
>```python
>Chaîne d'articles en entrée : 163841689525773  
>Chaîne d'articles emballés  : 163/8/41/6/8/9/52/5/7/73
>```
>
>L'algorithme actuel du robot d'emballage est très basique.  
>Il prend les articles les uns après les autres, et les mets dans un carton.  
>Si la taille totale dépasse la contenance du carton, le robot met l'article dans le carton suivant.
>
>Objectif
>--------
>
>Implémenter un algorithme qui permettrait de maximiser le nombre d'articles par carton, en utilisant un langage pouvant être exécuté sur une JVM 1.7 minimum ou en node.js.  
>L'ordre des cartons et des articles n'a pas d'importance.
>
>*Exemple*  
>```python
>Articles      : 163841689525773  
>Robot actuel  : 163/8/41/6/8/9/52/5/7/73 => 10 cartons utilisés  
>Robot optimisé: 163/82/46/19/8/55/73/7   => 8  cartons utilisés
>```

*Compléments :*
>Dans l’exercice tel qu’il est présenté, la problématique du flux de colis n’était pas soulevée. 
>C’est un sujet qu’on aborde habituellement en entretien ( d’où l’absence de donnée sur le maximum de cartons en attente dans l’énoncé ).
>
>Son implémentation est plus complexe, mais je ne suis pas contre une tentative, sur un maximum de 10 cartons dans l’espace de stockage
>Les colis peuvent être déplacés de carton en carton tant que les cartons sont disponibles dans l’espace de stockage 
>
>On va partir sur une livraison au moment ou le seuil de 10 cartons est atteint, qui embarque la totalité des 10 cartons en algorithme naïf
>Des propositions d’optimisation sur le nombre de livraisons effectuées ou le taux de remplissage d’une livraison en nombre de colis peuvent être envisagées