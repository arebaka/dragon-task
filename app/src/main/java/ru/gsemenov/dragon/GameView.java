package ru.gsemenov.dragon;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import ru.gsemenov.dragon.util.GameTimer;

public class GameView extends View  {

    protected GameEngine game = null;

    public GameView(Context context) {
        super(context);
    }

    /**
     * При первом событии изменения размера экрана запустится игра
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (game == null) {
            game = new GameEngine(getContext(), w, h);
        }
    }

    /**
     * Очередная отрисовка игры
     * Вызывается при запуске, а также после очередного invalidate
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        game.draw(canvas, false);
    }

    protected final GameTimer renderTimer = new GameTimer(10, () -> {
        // Выполнить один игровой тик
        game.tick();
        // Сообщить Android, что ему необходимо перерисовать наш GameView
        // Метод invalidate() провоцирует вызов onDraw()
        invalidate();
    });

    /**
     * Приостановить рендереринг игры
     */
    public void pause() {
        if (game == null) { return; }
    }

    /**
     * Продолжить рендеринг игры
     */
    public void resume() {
        if (game == null) { return; }
    }

    // Координаты начального касания пальцами для высчитывания смещения и скорости
    float dX, dY;

    /**
     * Управление драконом с помощью свайпов пальцами
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            default:
                return false;
        }
        return true;
    }

}
