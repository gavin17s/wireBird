package com.gsoo.wbHelpers;

/**
 * Created by gavinsu on 16/06/16.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

    public static Texture texture, logoTexture;
    public static TextureRegion logo, wbLogo, bg, grass, bird, birdDown,
            birdUp, capUp, capDown, bar, playButtonUp, playButtonDown;
    public static Animation birdAnimation;
    public static Sound dead, flap, coin;
    public static BitmapFont font, shadow;
    private static Preferences prefs;

    public static void load() {

        logoTexture = new Texture(Gdx.files.internal("data/logo.png"));
        logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        logo = new TextureRegion(logoTexture, 0, 0, 512, 114);

        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        playButtonUp = new TextureRegion(texture, 0, 332, 116, 64);
        playButtonDown = new TextureRegion(texture, 116, 332, 116, 64);
        playButtonUp.flip(false, true);
        playButtonDown.flip(false, true);

        wbLogo = new TextureRegion(texture, 0, 220, 540, 96);
        wbLogo.flip(false, true);

        bg = new TextureRegion(texture, 0, 0, 544, 172);
        bg.flip(false, true);

        grass = new TextureRegion(texture, 0, 172, 572, 44);
        grass.flip(false, true);

        birdDown = new TextureRegion(texture, 544, 0, 68, 48);
        birdDown.flip(false, true);

        bird = new TextureRegion(texture, 612, 0, 68, 48);
        bird.flip(false, true);

        birdUp = new TextureRegion(texture, 680, 0, 68, 48);
        birdUp.flip(false, true);

        TextureRegion[] birds = { birdDown, bird, birdUp };
        birdAnimation = new Animation(0.06f, birds);
        birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        capUp = new TextureRegion(texture, 768, 0, 96, 56);
        capDown = new TextureRegion(capUp);
        capDown.flip(false, true);

        bar = new TextureRegion(texture, 544, 64, 88, 12);
        bar.flip(false, true);

        dead = Gdx.audio.newSound(Gdx.files.internal("data/dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("data/flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));

        font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        font.getData().setScale(.25f, -.25f);
        shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
        shadow.getData().setScale(.25f, -.25f);

        prefs = Gdx.app.getPreferences("ZombieBird");

        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }
    }

    public static void setHighScore(int val) {
        prefs.putInteger("highScore", val);
        prefs.flush();
    }

    public static int getHighScore() {
        return prefs.getInteger("highScore");
    }

    public static void dispose() {
        texture.dispose();
        dead.dispose();
        flap.dispose();
        coin.dispose();
        font.dispose();
        shadow.dispose();
    }
}