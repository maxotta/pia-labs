package org.danekja.edu.pia.core.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 6.12.16
 *
 * @author Jakub Danek
 */
public class ChatHandler extends TextWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(ChatHandler.class);

    /**
     * WebSocketSession represents single web-socket connection.
     */
    private Map<String, WebSocketSession> openSessions;

    public ChatHandler() {
        this.openSessions = new HashMap<>();
    }

    /**
     * This method is called when a message comes via web-socket.
     *
     * @param session the particular connection through which the message came
     * @param message the received message
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("Received message {} from [{}]", message.getPayload(), session.getId());

        for (WebSocketSession webSocketSession : openSessions.values()) {
            logger.debug("Sending message {} to {}", message.getPayload(), webSocketSession.getId());

            webSocketSession.sendMessage(message);
        }
    }

    /**
     * This method is called when new client connects to the server.
     *
     * @param session object representing the open connection, keep it if you need it
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.debug("New user connected with id {}", session.getId());
        this.openSessions.put(session.getId(), session);
    }

    /**
     * Method called when a connection is closed
     *
     * @param session object representing the closed connection
     * @param status result status
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.debug("User with id {} disconnected", session.getId());
        this.openSessions.remove(session.getId());
    }
}
