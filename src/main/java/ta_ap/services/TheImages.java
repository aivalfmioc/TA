package ta_ap.services;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TheImages {
    private ImageView images;
    public TheImages(String images){
        setImages(images);
    }

    public TheImages() {
    }

    public ImageView getImages(){
        return this.images;
    }
    public void setImages(String URL){
        Image anImage= new Image(URL);
        this.images=new ImageView(anImage);

  }

}
