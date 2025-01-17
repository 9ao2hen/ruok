package com.mervyn.ruok.module.infra.websocket;

import com.mervyn.ruok.framework.common.enums.UserTypeEnum;
import com.mervyn.ruok.framework.websocket.core.listener.WebSocketMessageListener;
import com.mervyn.ruok.framework.websocket.core.sender.WebSocketMessageSender;
import com.mervyn.ruok.framework.websocket.core.util.WebSocketFrameworkUtils;
import com.mervyn.ruok.module.infra.websocket.message.DemoReceiveMessage;
import com.mervyn.ruok.module.infra.websocket.message.DemoSendMessage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

/**
 * WebSocket 示例：单发消息
 *
 * @author mervyn
 */
@Component
public class DemoWebSocketMessageListener implements WebSocketMessageListener<DemoSendMessage> {

    @Resource
    private WebSocketMessageSender webSocketMessageSender;

    @Override
    public void onMessage(WebSocketSession session, DemoSendMessage message) {
        Long fromUserId = WebSocketFrameworkUtils.getLoginUserId(session);
        // 情况一：单发
        if (message.getToUserId() != null) {
            DemoReceiveMessage toMessage = new DemoReceiveMessage().setFromUserId(fromUserId)
                    .setText(message.getText()).setSingle(true);
            webSocketMessageSender.sendObject(UserTypeEnum.ADMIN.getValue(), message.getToUserId(), // 给指定用户
                    "demo-message-receive", toMessage);
            return;
        }
        // 情况二：群发
        DemoReceiveMessage toMessage = new DemoReceiveMessage().setFromUserId(fromUserId)
                .setText(message.getText()).setSingle(false);
        webSocketMessageSender.sendObject(UserTypeEnum.ADMIN.getValue(), // 给所有用户
                "demo-message-receive", toMessage);
    }

    @Override
    public String getType() {
        return "demo-message-send";
    }

}
