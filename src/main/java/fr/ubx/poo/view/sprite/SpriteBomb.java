package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.Bombs;
import fr.ubx.poo.view.image.ImageFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;


public class SpriteBomb extends SpriteGameObject{
    private final ColorAdjust effect = new ColorAdjust();

    public SpriteBomb(Pane layer, Bombs bomb) {
        super(layer, null, bomb);
        updateImage();
    }

    @Override
    public void updateImage() {
        Bombs bombs = (Bombs) go;
        setImage(ImageFactory.getInstance().getBombs(bombs.getStateBomb()));
    }
}
