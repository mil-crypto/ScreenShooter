import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Uploader extends Thread{
    private BufferedImage image;
    private DbxClientV2 client;
    public Uploader(DbxClientV2 client, BufferedImage image){
        this.image=image;
        this.client=client;
    }

    @Override
    public void run() {
        try {
            // TODO: convert "image" to inputstream
            //using ByteArrayInputStream and
            //ByteArrayOutputStream
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", os);
            InputStream in = new ByteArrayInputStream(os.toByteArray());
            //TODO: picture2.jpg like: 20210608_172735.png


            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String picture=dateFormat.format( new Date() );
            System.out.println(picture+".png");
            client.files().uploadBuilder("/"+picture+".png")
                    .uploadAndFinish(in);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
