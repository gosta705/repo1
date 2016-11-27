import java.io.File;
import java.util.List;


/**
 * Created by tanya on 27.11.2016.
 */
public class Profile {
    private final long id;
    private final String firstName;
    private final String lastName;

    private File profilePhoto;
    private List<File> photos;
    private List<Profile> friendList;
    private List<File> music;

    public Profile(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        id = GenerateId.genId();
    }

    public void setProfilePhoto(File photo){

    }

    public void addFriend(Profile profile){

    }

    public void deleteFriend(Profile profile){

    }

    public void addPhoto(File photo){

    }

    public void addMusic(File music){

    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public File getProfilePhoto(){
        return profilePhoto;
    }

    public List <File> getListPhotos(){
        return photos;
    }

    public List <Profile> getFriendList(){
        return friendList;
    }

    public List <File> getListMuisic(){
        return music;
    }

}
