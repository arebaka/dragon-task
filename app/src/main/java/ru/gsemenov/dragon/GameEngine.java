package ru.gsemenov.dragon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

import ru.gsemenov.dragon.entity.FireBall;
import ru.gsemenov.dragon.entity.FlyingEntity;
import ru.gsemenov.dragon.interfaces.IGame;
import ru.gsemenov.dragon.util.GameTimer;
import ru.gsemenov.dragon.util.SoundPlayer;
import ru.gsemenov.dragon.util.WaitAndRunTask;

public class GameEngine implements IGame {

    /**
     * Генератор случайных чисел
     * <p>
     * Сгенерированный уровень будет полностью зависеть от числа seed,
     * который вы передадите в конструктор
     */
    public final Random rnd = new Random(400);

    /**
     * Размеры игрового поля (Width - ширина, Height - высота)
     */
    public int W, H;

    /**
     * Таймер создания огненных шаров
     * <p>
     * Каждые 700 мс с вероятностью запускает новый огненный шар на случайной координате
     */
    protected final GameTimer spawnTimer = new GameTimer(700, () -> {

    });

    /**
     * Текущее пройденное расстояние и максимальное расстояние за все игры
     */
    public int distance = 0, maxDistance = 0;

    /**
     * Игровые сущности
     */
    public FlyingEntity dragon = null;
    public final FireBall[] fireBalls = new FireBall[8];

    /**
     * Таймер анимации
     * <p>
     * Каждые 250 мс обновляет кадр дракона
     */
    protected final GameTimer animationTimer = new GameTimer(250, () -> {

    });

    /**
     * Игровые ресурсы (шрифты, звуки и пр.)
     */
    protected SoundPlayer backgroundMusic;
    protected SoundPlayer blastSound;
    protected Paint fontPaint;
    private boolean isPaused = false;

    /**
     * Задача по перезапуску игры после проигрыша
     * <p>
     * Вызывается при проигрыше, ждет промежуток времени и выполняет код внутри
     */
    protected final WaitAndRunTask restartTask = new WaitAndRunTask(1000, () -> {
        startGame();
    });

    /**
     * Конструктор игры
     *
     * @param context активности, в которой создана наша игра
     * @param W       ширина игрового поля
     * @param H       высота игрового поля
     */
    public GameEngine(Context context, int W, int H) {
        this.W = W;
        this.H = H;
        initResources(context);
    }

    /**
     * Вспомогательный метод для инициализации необходимых игре ресурсов (мобы, звуки, текстуры и пр.)
     * @param context, из которого будут браться необходимые ресурсы из папки res
     */
    void initResources(Context context) {

    }

    /**
     * Что должно произойти за один игровой такт
     */
    void tick() {

    }

    /**
     * Что должно произойти при столкновении
     */
    public void crash() {

    }

    /**
     * Нарисовать игровое поле на холсте
     *
     * @param canvas           холст
     * @param drawInRectangles если установлен true, то вместо текстур необходимо использовать прямоугольники
     */
    public void draw(Canvas canvas, boolean drawInRectangles) {

    }


    /**
     * Запустить игру
     */
    public void startGame() {
        isPaused = false;
    }

    /**
     * Восстановить игру после паузы, если она была восстановлена
     */
    public void resumeGame() {
        if (!isPaused) {
            return;
        }
        isPaused = false;
    }

    /**
     * Приостановить игру
     */
    public void pauseGame() {
        if (isPaused) {
            return;
        }
        isPaused = true;
    }

    /**
     * Остановить игру
     */
    public void stopGame() {

    }

}
