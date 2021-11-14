
package com.mycompany.tennis;

import com.mycompany.tennis.controller.*;

public class UI {

    public  static  void  main(String[] args){
        /*joueur*/
        JoueurController joueurController = new JoueurController();
        joueurController.afficheDetailsJoueur();
        //joueurController.creerJoueur();
        //joueurController.supprimerJoueur();
        //joueurController.renomerJoueur();
        //joueurController.renomerSexeJoueur();
        //joueurController.afficheListJoueur();
        /*tournoi*/
        //TournoiController tournoiController = new TournoiController();
        //tournoiController.afficheDetailsTournoi();
        //tournoiController.creerTournoi();
       // tournoiController.supprimerTournoi();
        /*Score*/
        //ScoreController scoreController = new ScoreController();
       // scoreController.afficheDetailsScore();
        /*Epreuve*/
       // EpreuveController epreuveController =new EpreuveController();
        //epreuveController.afficheDetailsEpreuveWithTournoi();
        //epreuveController.afficheDetailsEpreuveSansTournoi();
        //epreuveController.afficheListEpreuve();
        /*Match*/
        //MatchController matchController = new MatchController();
        //matchController.ajoputerMatch();
        //matchController.afficheDetailsMatch();
        //matchController.tapisVert();
        //matchController.supprimerMatch();
        /*Score*/
        //ScoreController scoreController = new ScoreController();
        //scoreController.afficheDetailsScore();
    }
}
