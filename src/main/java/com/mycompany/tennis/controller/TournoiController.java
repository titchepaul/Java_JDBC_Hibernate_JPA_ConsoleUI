package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.TournoiDto;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.entity.Tournoi;
import com.mycompany.tennis.core.service.JoueurService;
import com.mycompany.tennis.core.service.TournoiService;

import java.util.Scanner;

public class TournoiController {

    private TournoiService tournoiService;
    private Scanner scanner = new Scanner(System.in);

    public TournoiController(){
        this.tournoiService = new TournoiService();
    }
    public void creerTournoi(){
        System.out.println("Entrer le nom du tournoi svp : ");
        String nom = scanner.nextLine();
        System.out.println("Le code du tournoi svp :");
        String code = scanner.nextLine();

        TournoiDto tournoiDto = new TournoiDto();
        tournoiDto.setCode(code);
        tournoiDto.setNom(nom);
        tournoiService.createTournoi(tournoiDto);
    }
    public void afficheDetailsTournoi(){
        System.out.println("L'id du tournoi svp : ");
        long id = scanner.nextLong();
        TournoiDto tournoiDto = tournoiService.getById(id);
        System.out.println("ID du tournoi récupérer est : "+tournoiDto.getId()+" "+tournoiDto.getCode()+ " "+tournoiDto.getNom());
    }
    public void supprimerTournoi(){
        System.out.println("l'ID du tournoi à supprimer svp : ");
        long id = scanner.nextLong();
        tournoiService.deleteTournoi(id);
    }
}
