package me.game.who;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GameProcess {
    private static final Logger log = LoggerFactory.getLogger(GameProcess.class);

    private List<Player> players;

    private int statusIndex = 0;
    private String[] status = {"wait", "start", "dealCard", "description", "vote", "end"};

    public GameProcess(List<Player> playerList){
        this.players = playerList;
    }

    public void start(){ }

    private void process(){
        dealCard();
        description();
        vote();
    }

    public void end(){ }

    /**
     * 发牌阶段,为每个 player 的 tag 赋值 todo
     */
    private void dealCard(){
        log.debug("发牌");
    }

    /**
     * 描述阶段
     */
    private void description(){
        log.debug("描述阶段开始");
        try {
            // todo 有其他方法吗
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("描述阶段结束");
    }

    private void vote(){
        int second = 60;
        long endTime = System.currentTimeMillis() + (second * 1000);
        while(System.currentTimeMillis() < endTime && true) {
            log.debug("投票时间倒计时中。。。");
        }
    }

    private void judge(){

    }

    private int nextState() {
        return this.statusIndex = (this.statusIndex + 1) % this.status.length;
    }
}
