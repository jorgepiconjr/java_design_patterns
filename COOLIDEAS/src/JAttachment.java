import java.io.File;

public class JAttachment extends JContent{

    private File file;

    public JAttachment(String title, String descripcion, File file){
        super(title,descripcion);
        if (file == null){
            throw new NullPointerException();
        }
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        if (file == null){
            throw new NullPointerException();
        }
        this.file = file;
    }
    public String toString(){
        return "Attachment" + ": " + getTitle() + "\n" + getDescription();
    }
}
