package me.game.who;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint(value = "/room")
public class SocketHandler {

    final static Logger logger = LoggerFactory.getLogger(SocketHandler.class);

    @Resource
    RoomsManager roomsManager;

    Map<String, Map<String, Session>> rooms = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) throws IOException {
        logger.info("{}连接成功", session.getId());

        String roomId = session.getPathParameters().get("roomId");
        String username = session.getPathParameters().get("username");

        roomsManager.enterOrCreateRoom(roomId, session);
        session.getBasicRemote().sendText(session.getId() + "连接成功");
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        logger.info("{}断开连接", session.getId());
        session.getBasicRemote().sendText("连接断开");
    }

    @OnError
    public void onError(Session session, Throwable throwable) throws IOException {
        logger.info("{}发生错误", session.getId());
        session.getBasicRemote().sendText("发生错误");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        logger.info("收到{}发来的消息: {}", session.getId(), message);
        session.getBasicRemote().sendText(message);
    }

}
