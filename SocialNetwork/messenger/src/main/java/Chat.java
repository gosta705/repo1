import java.util.List;

/**
 * Created by tanya on 27.11.2016.
 */
public interface Chat {
    void sendMessage(String message);

    void addParticipant(Profile participant);

    void removeParticipant(Profile participant);

    List<Profile> getParticipantList();

    List<String> getMessageList();

}
