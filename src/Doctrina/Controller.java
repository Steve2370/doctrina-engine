package Doctrina;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public abstract class Controller implements KeyListener {

    private final HashMap<Integer, Boolean> pressedKeys;


    public Controller() {
        pressedKeys = new HashMap<>();
    }

    protected void bindKey(int keyCode) {
        pressedKeys.put(keyCode, false);
    }

    protected void unbindKey(int keyCode) {
        pressedKeys.remove(keyCode);
    }

    protected void clearKey() {
        pressedKeys.clear();
    }

    public boolean isKeyPressed(int keyCode) {
        return pressedKeys.containsKey(keyCode) && pressedKeys.get(keyCode);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (pressedKeys.containsKey(keyCode)) {
            pressedKeys.put(keyCode, true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (pressedKeys.containsKey(keyCode)) {
            pressedKeys.put(keyCode, false);
        }
    }
}