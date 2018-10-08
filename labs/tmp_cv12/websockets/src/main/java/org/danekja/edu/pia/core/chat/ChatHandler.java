package org.danekja.edu.pia.core.chat;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Date: 6.12.16
 *
 * @author Jakub Danek
 */
public class ChatHandler extends TextWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(ChatHandler.class);

    private Map<String, WebSocketSession> openSessions;

    public ChatHandler() {
        this.openSessions = new HashMap<>();
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("Received message {} from [{}]", message.getPayload(), session.getId());

        for (WebSocketSession webSocketSession : openSessions.values()) {
            logger.debug("Sending message {} to {}", message.getPayload(), webSocketSession.getId());

            webSocketSession.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.debug("New user connected with id {}", session.getId());
        this.openSessions.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.debug("User with id {} disconnected", session.getId());
        this.openSessions.remove(session.getId());
    }
}
