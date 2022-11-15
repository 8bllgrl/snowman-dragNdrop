package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class AssetLoader {

    public static final String JINGLE_SOUND_EFFECT = "/sfx/jingle.wav";
    public static final String SNOWMAN_HEAD_IMAGE = "/img/sm_head.png";
    public static final String SNOWMAN_BODY_IMAGE = "/img/sm_body.png";

    public AssetLoader(){

    }
    public static BufferedImage GetImageReader(String fileName) {
        BufferedImage img = null;
        InputStream is = AssetLoader.class.getResourceAsStream(fileName);
        try {
            assert is != null;
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }
}
