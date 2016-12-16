package Controllers.managers;

import Models.Model;

/**
 * Created by laptopTCC on 12/14/2016.
 */
public interface Body { //pure abstract: chỉ chứa hàm ảo --> đổi thành interface
    Model getModel();
    void onContact(Body other);
   // void attack(Body other);
}
