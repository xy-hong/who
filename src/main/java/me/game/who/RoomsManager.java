package me.game.who;

import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RoomsManager {

    Map<String, Room> rooms = new ConcurrentHashMap<>();

    /**
     * 用户进入房间，如果房间不存在则创建并进入
     * @param roomId
     * @param session
     */
    public void enterOrCreateRoom(String roomId, Session session){
        Room room = rooms.get(roomId);
        if (room == null){
            room = new Room();
            room.put(session.getId(), session);
        }else {
            room.put(session.getId(), session);
        }
    }

    // todo
    public void exitRoom(String roomId) {

    }
}
