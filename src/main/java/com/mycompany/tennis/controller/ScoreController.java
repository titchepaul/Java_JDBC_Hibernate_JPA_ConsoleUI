package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.ScoreFullDto;
import com.mycompany.tennis.core.entity.Score;
import com.mycompany.tennis.core.service.ScoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreController {

    Scanner scanner = new Scanner(System.in);
    ScoreService scoreService = null;

    public ScoreController(){
        scoreService = new ScoreService();
    }

    public void afficheDetailsScore(){
        System.out.println("l'ID du Score a afficher svp : ");
        Long id = scanner.nextLong();
        ScoreFullDto score = scoreService.getScore(id);

        List<Byte> list = new ArrayList<>();
        list.add(score.getSet1());
        list.add(score.getSet2());
        list.add(score.getSet3());
        list.add(score.getSet4());
        list.add(score.getSet5());
        System.out.println("Score : ");

        for(Byte i : list){
            if(i != null){
                System.out.print(i +" ");
            }
        }
        System.out.println();
        System.out.println("Il s'agit du tournoi : "+score.getMatchDto().getEpreuveFullDto().getTournoi().getNom());
        System.out.println("L'epreuve s'est déroulé en "+score.getMatchDto().getEpreuveFullDto().getAnnee() +" et il s'agissait d'une épreuve "+
                (score.getMatchDto().getEpreuveFullDto().getTypeEpreuve().charValue()=='H' ? "Homme" : "Femme"));
        //System.out.println("Score : "+score.getSet1()+ " "+score.getSet2()+" "+score.getSet3()+" "+score.getSet4()+" "+score.getSet5());
    }
    public void supprimerScore(){

        System.out.println("L'id du Score à supprimer svp : ");
        long id = scanner.nextLong();
        scoreService.deleteScore(id);
    }
}
