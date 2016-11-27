import java.io.File;

/**
 * Created by tanya on 28.11.2016.
 */
public class Post {
    private final String text;
    private final File file;
    private final int id;

    public Post(String text, File file){
        this.text = text;
        this.file = file;
    }

}
