import com.step.communication.channel.MessageChannel;
import com.step.communication.factory.UnoFactory;
import com.step.communication.server.MessageServer;
import com.step.uno.messages.Snapshot;
import com.step.uno.server.controller.GameMasterController;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class GameMasterControllerTest {

    StubFactory stub = new StubFactory();
    @Test
    public void rejectsConnectionsAfterAllPlayersJoin(){
        MessageChannel channel = mock(MessageChannel.class);
        MessageChannel lateChannel = mock(MessageChannel.class);
        GameMasterController controller = new GameMasterController(1,1,stub);
        controller.waitForConnections();
        controller.onNewConnection(channel);
        controller.onNewConnection(lateChannel);
        verify(lateChannel,times(1)).stop();
        verify(lateChannel,never()).send(any(Snapshot.class));
    }

    class StubFactory extends UnoFactory {
        public final MessageServer messageServer = mock(MessageServer.class);

        @Override
        public MessageServer createMessageServer() {
            return messageServer;
        }
    }
}