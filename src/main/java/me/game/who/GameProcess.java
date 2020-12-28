package me.game.who;

import java.util.List;

public class GameProcess {
    private List<Player> players;

    public GameProcess(List<Player> playerList){
        this.players = playerList;
    }

    public void start(){ }

    private void process(){
        dealCard();

    }

    public void end(){ }

    /**
     * 发牌 todo
     */
    private void dealCard(){

    }

    private void vote(){
        int second = 60;
        long endTime = System.currentTimeMillis() + (second * 1000);
        while(System.currentTimeMillis() < endTime && true) {

        }
    }
}
