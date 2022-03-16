import com.amr.project.model.dto.MessageDto;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SpringBootTest
public class WebSocketTest {

    private final static String URL = "ws://localhost:8888/websocket";

    private WebSocketStompClient webSocketStompClient;
    private ClientSessionHandler handler;
    private StompSession session;

    @Test
    public void testWebSocketConnection() throws ExecutionException, InterruptedException {
        webSocketStompClient = new WebSocketStompClient(new SockJsClient(
                List.of(new WebSocketTransport(new StandardWebSocketClient()))));
        webSocketStompClient.setMessageConverter(new MappingJackson2MessageConverter());
        handler = new ClientSessionHandler();
        session = webSocketStompClient.connect(URL, handler).get();
        Assert.assertTrue(session.isConnected());
    }

    public static class ClientSessionHandler extends StompSessionHandlerAdapter {
        @Override
        public @NotNull Type getPayloadType(@NotNull StompHeaders headers) {
            return MessageDto.class;
        }

        @Override
        public void handleFrame(@NotNull StompHeaders headers, Object payload) {
            System.out.println("Message is " + ((MessageDto) payload).getTextMessage());
        }
    }
}