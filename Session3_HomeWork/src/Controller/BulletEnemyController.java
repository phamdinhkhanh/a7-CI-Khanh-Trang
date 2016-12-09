package Controller;
import Model.Model;
import View.View;
public class BulletEnemyController extends Controller{
    public BulletEnemyController (Model model, View view) {
        super(model,view);
    }
    public void run() {
        this.model.move(0,+7);
    }
}
