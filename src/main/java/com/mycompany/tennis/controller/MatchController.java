package com.mycompany.tennis.controller;


import com.mycompany.tennis.core.dto.*;
import com.mycompany.tennis.core.service.MatchService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchController {

    private MatchService matchService;
    private Scanner scanner = new Scanner(System.in);

    public MatchController(){
        this.matchService = new MatchService();
    }

    public void ajoputerMatch(){
        System.out.println("Quel est l'Id de l'épreuve svp : ");
        long idEpreuve = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est l'Id du vainqueur svp : ");
        long idVainqueur = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est l'Id du finaliste svp : ");
        long idFinaliste = scanner.nextLong();
        scanner.nextLine();

        MatchDto matchDto = new MatchDto();
        matchDto.setEpreuveFullDto(new EpreuveFullDto());
        matchDto.getEpreuveFullDto().setId(idEpreuve);
        matchDto.setFinaliste(new JoueurDto());
        matchDto.getFinaliste().setId(idFinaliste);
        matchDto.setVainqueur(new JoueurDto());
        matchDto.getVainqueur().setId(idVainqueur);

        System.out.println("Quel est la valeur du 1er set svp : ");
        byte set1 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 2er set svp : ");
        byte set2 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 3er set svp : ");
        byte set3 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 4er set svp : ");
        byte set4 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 5er set svp : ");
        byte set5 = scanner.nextByte();
        scanner.nextLine();

        ScoreFullDto scoreFullDto = new ScoreFullDto();
        scoreFullDto.setSet1(set1);
        scoreFullDto.setSet2(set2);
        scoreFullDto.setSet3(set3);
        scoreFullDto.setSet4(set4);
        scoreFullDto.setSet5(set5);

        matchDto.setScoreFullDto(scoreFullDto);
        scoreFullDto.setMatchDto(matchDto);
        matchService.createMatch(matchDto);
    }
    public void tapisVert(){
        System.out.println("L'id du match dont vous voulez annuler  : ");
        long id = scanner.nextLong();
        matchService.tapisVert(id);
    }

    public void afficheDetailsMatch(){
        System.out.println("L'id du match dont vous voulez afficher les infos svp : ");
        long id = scanner.nextLong();
        MatchDto matchDto = matchService.getMatch(id);
        System.out.println("Il s'agit d'un match de "+matchDto.getEpreuveFullDto().getAnnee()+" qui s'est déroulé en "+matchDto.getEpreuveFullDto().getTournoi().getNom());
        System.out.println("Le nom et prénom du vainqueur sont : "+matchDto.getVainqueur().getNom()+ " "+matchDto.getVainqueur().getPrenom());
        System.out.println("Le nom et prénom du finaliste sont : "+matchDto.getFinaliste().getNom()+ " "+matchDto.getFinaliste().getPrenom());

        List<Byte> list = new ArrayList<>();
        list.add(matchDto.getScoreFullDto().getSet1());
        list.add(matchDto.getScoreFullDto().getSet2());
        list.add(matchDto.getScoreFullDto().getSet3());
        list.add(matchDto.getScoreFullDto().getSet4());
        list.add(matchDto.getScoreFullDto().getSet5());
        System.out.println("Score : ");

        for(Byte i : list){
            if(i != null){
                System.out.print(i +" ");
            }
        }
    }
    public void supprimerMatch(){

        System.out.println("L'id du match à supprimer svp : ");
        long id = scanner.nextLong();
        matchService.deleteMatch(id);
    }
}
