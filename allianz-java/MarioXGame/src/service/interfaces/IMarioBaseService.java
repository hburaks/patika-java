package service.interfaces;

import model.BaseCharacter;
import model.Map;
import model.MarioBaseCharacter;


public interface IMarioBaseService {
    public void strengthenCharacter(MarioBaseCharacter marioBaseCharacter);

    public void weakenCharacter(MarioBaseCharacter marioBaseCharacter);

    public void decreaseHealth(MarioBaseCharacter marioBaseCharacter);

    public boolean checkKill(Map map, BaseCharacter baseCharacter);

    public boolean checkDie(Map map, BaseCharacter baseCharacter, String direction);
}
