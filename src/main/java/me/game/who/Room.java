package me.game.who;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Room {

    Map<String, Session> room = new ConcurrentHashMap<>();

    public Session put(String sessionId, Session session) {
        return room.put(sessionId, session);
    }

    public Session get(String sessionId) {
        return room.get(sessionId);
    }

}
