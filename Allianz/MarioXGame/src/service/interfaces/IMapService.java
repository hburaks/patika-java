package service.interfaces;

import model.*;

import java.util.List;

public interface IMapService {
    public void putVillainsToMap(Map map, List<Villain> villainList);

    public void putCharacterToMap(Map map, MarioBaseCharacter character);

    public void printMap(Map map);

    public boolean moveRight(Map map, BaseCharacter baseCharacter);

    public boolean moveLeft(Map map, BaseCharacter baseCharacter);

    public void moveUp(Map map, BaseCharacter baseCharacter);

    public void moveDown(Map map, BaseCharacter baseCharacter);

    public void jumpLeft(Map map, BaseCharacter baseCharacter);

    public void jumpRight(Map map, BaseCharacter baseCharacter);

    public void moveCharacter(Map map, BaseCharacter baseCharacter, int x, int y);

    public boolean askToMoveCharacter(Map map, BaseCharacter baseCharacter);

    public boolean isGameFinished(Map map, BaseCharacter character);
}
