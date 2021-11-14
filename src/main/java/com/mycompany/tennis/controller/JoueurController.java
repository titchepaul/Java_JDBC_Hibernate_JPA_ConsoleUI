package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.service.JoueurService;

import java.util.Scanner;

public class JoueurController {

    private JoueurService joueurService;
    private Scanner scanner = new Scanner(System.in);

    public JoueurController(){
        this.joueurService = new JoueurService();
    }
    public  void afficheDetailsJoueur(){
        System.out.println("L'id du joueur svp : ");
        long id = scanner.nextLong();
        Joueur joueur = joueurService.getJoueur(id);
        System.out.println("le jour récupéré s'appelle : "+joueur.getNom()+ " "+joueur.getPrenom());
    }
    public void creerJoueur(){
        System.out.println(" le nom du joueur svp : ");
        String nom = scanner.nextLine();
        System.out.println("Le prenom du joueur svp : ");
        String prenom = scanner.nextLine();
        System.out.println("le sexe du joueur svp : ");
        Character sexe = scanner.nextLine().charAt(0);

        Joueur joueur = new Joueur();
        joueur.setNom(nom);
        joueur.setPrenom(prenom);
        joueur.setSexe(sexe);
        joueurService.createJoueur(joueur);
    }
    public void supprimerJoueur(){
        System.out.println("L'id du joueur à supprimer svp : ");
        long id = scanner.nextLong();
        joueurService.deleteJoueur(id);
    }
    public void renomerJoueur(){
        System.out.println("L'id du joueur à modifié svp : ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Le nouveau nom du joueur svp : ");
        String nom = scanner.nextLine();
        joueurService.renomerJoueur(id,nom);
    }
    public void renomerSexeJoueur(){
        System.out.println("L'id du joueur dont on veut modifier le sexe svp : ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Le nouveau sexe du Joueur svp: ");
        Character sexe = scanner.nextLine().charAt(0);
        joueurService.renomerSexeJoueur(id,sexe);
    }
    public void afficheListJoueur(){
        System.out.println("Donnez le sexe du Joueur en question svp (H) pour hommes et (F) pour femmes : ");
        char sexe = scanner.nextLine().charAt(0);
        /*for(JoueurDto j : joueurService.getListJoueurs(sexe)){
            System.out.println(j.getNom()+ " "+j.getPrenom());
        }*/
        //api stream java
        joueurService.getListJoueurs(sexe).stream().forEach(
                j -> {
                    System.out.println(j.getNom()+ " "+j.getPrenom());
                }
        );
    }
}
