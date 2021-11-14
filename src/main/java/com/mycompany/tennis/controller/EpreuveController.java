package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.EpreuveFullDto;
import com.mycompany.tennis.core.dto.EpreuveLightDto;
import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.entity.Epreuve;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.service.EpreuveService;

import java.util.Scanner;

public class EpreuveController {

    private Scanner scanner = new Scanner(System.in);
    private EpreuveService epreuveService = null;

    public EpreuveController(){
        this.epreuveService = new EpreuveService();
    }

    public  void afficheDetailsEpreuveWithTournoi(){
        System.out.println("L'id de l'epreuve svp : ");
        long id = scanner.nextLong();
       EpreuveFullDto epreuve = epreuveService.getByIdWithTournoi(id);
       System.out.println("L'épreuve sélectionnée se déroule en : "+epreuve.getAnnee()+" et il s'agit du tournoi "+epreuve.getTournoi().getNom());

       for(JoueurDto joueurDto : epreuve.getParticipants()){
           System.out.println(joueurDto.getNom()+ " "+joueurDto.getPrenom());
       }
    }
    public  void afficheDetailsEpreuveSansTournoi(){
        System.out.println("L'id de l'epreuve svp : ");
        long id = scanner.nextLong();
        EpreuveLightDto epreuve = epreuveService.getByIdSansTournoi(id);
        System.out.println("L'épreuve sélectionnée se déroule en : "+epreuve.getAnnee());
    }
    public void afficheListEpreuve(){
        System.out.println("Donnez le code du tournoi svp : ");
        String code = scanner.nextLine();
        //for normal
        /*for(EpreuveFullDto epreuveFullDto : epreuveService.getListEpreuve(code)){
            System.out.println(epreuveFullDto.getId()+ " "+epreuveFullDto.getAnnee()+" "+epreuveFullDto.getTypeEpreuve());
        }*/
        //api stream java
        epreuveService.getListEpreuve(code).stream().forEach(
                e -> {
                    System.out.println(e.getId()+ " "+e.getAnnee()+" "+e.getTypeEpreuve()+ " "+e.getTournoi().getNom());
                }
        );
    }
}
