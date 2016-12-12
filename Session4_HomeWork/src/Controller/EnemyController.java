package Controller;

import Model.Model;
import View.View;

import static Util.loadImage.loadImage;

/**
 * Created by laptopTCC on 12/11/2016.
 */
public class EnemyController extends Controller {
    public EnemyController(Model model, View view){
        super(model, view);
    }

    public static EnemyController createEnemy(int x, int y){
        EnemyController enemyController = new EnemyController(
                new Model(x,y,50,80),
                new View(loadImage("resources/plane1.png"))
        );
        return enemyController;
    }
}
