package fr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TextureAtlas {

    public HashMap<String, BufferedImage> textures = new HashMap<>();

    private HashMap<String, String> names = new HashMap<>();


    public TextureAtlas() throws IOException {

        names.put("WALL", "/wallPlaceholder.png");
        names.put("START", "/STARTPlaceHolder.png");
        names.put("END", "/ENDPlaceholder.png");
        names.put("ENEMY", "/ennemyPlaceholder.png");
        names.put("PLAYER", "/playerPlaceHolder.png");

        try {

            for (Map.Entry<String, String> entry : names.entrySet()) {
                String key = entry.getKey();
                String path = entry.getValue();

                URL resource = getClass().getResource(path);
                System.out.println(resource);
                if (resource == null) {
                    throw new IOException("Image not found: " + path);
                }
                BufferedImage image = ImageIO.read(resource);

                textures.put(key, image);

            }
        } catch (IOException | NullPointerException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
