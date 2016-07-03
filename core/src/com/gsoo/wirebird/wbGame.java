package com.gsoo.wirebird;

import com.badlogic.gdx.Game;
import com.gsoo.screens.SplashScreen;
import com.gsoo.wbHelpers.AssetLoader;

public class wbGame extends Game {

    @Override
    public void create() {
        AssetLoader.load();
        setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}