import com.step.communication.channel.MessageChannel;
import com.step.communication.channel.MessageChannelListener;
import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.controller.GameClientController;
import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.GameSnapshot;
import com.step.uno.messages.Introduction;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameClientControllerTest {
    StubFactory stub = new StubFactory();
    PlayerView view = mock(PlayerView.class);

    @Test
    public void sendsIntroductionAfterJoiningGame() {
        GameClientController controller = new GameClientController(stub, view);
        controller.join("serverAddress");
        verify(stub.channel,times(1)).send(any(Introduction.class));
    }
    @Test
    public void informsUserWhenConnectionIsLost(){
        GameClientController controller = new GameClientController(stub,view);
        controller.join("serverAddress");
        controller.onConnectionClosed(stub.channel);
        verify(view,times(1)).showDisconnected();
    }
    @Test
    public void displaysGameSnapshotAsItArrives(){
        GameClientController controller = new GameClientController(stub,view);
        controller.join("serverAddress");
        GameSnapshot snapshot = new GameSnapshot();
        controller.onMessage(stub.channel, snapshot);
        verify(view,times(1)).update(snapshot);
    }

    class StubFactory extends CommunicationFactory {
        public final MessageChannel channel = mock(MessageChannel.class);

        @Override
        public MessageChannel connectTo(String serverAddress, MessageChannelListener observer) {
            return channel;
        }
    }
}

