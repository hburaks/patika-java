package service;

import model.*;
import service.interfaces.ILoadService;

import java.util.ArrayList;
import java.util.List;

public class LoadService implements ILoadService {

    @Override
    public List<Villain> loadVillains() {
        List<Villain> villainList = new ArrayList<>();

        Villain raptile = new Raptiles("Raptile", 1, true, 1, MoveTypeEnum.WALKER, new Coordinate(0, 0));
        Villain turtle = new Turtles("Turtle", 1, true, 2, MoveTypeEnum.WALKER, new Coordinate(0, 0));
        Villain flyingTurtle = new FlyingTurtle("Flying Turtle", 1, true, 1, MoveTypeEnum.FLYER, new Coordinate(0, 0));
        Villain fireRotatingChain = new FireRotatingChain("Fire Rotating", 1, false, 1, MoveTypeEnum.STANDER, new Coordinate(0, 0));

        villainList.add(raptile);
        villainList.add(turtle);
        villainList.add(flyingTurtle);
        villainList.add(fireRotatingChain);

        return villainList;
    }

    @Override
    public MarioBaseCharacter loadMario() {
        Coordinate marioCoordinate = new Coordinate(0, 0);
        return new Mario("Mario", 1, GrowthCycleEnum.LITTLE, 1, false, 3, marioCoordinate);
    }

    @Override
    public MarioBaseCharacter loadLuigi() {
        Coordinate marioCoordinate = new Coordinate(0, 0);
        return new Mario("Luigi", 1, GrowthCycleEnum.LITTLE, 1, false, 3, marioCoordinate);
    }

    @Override
    public Map loadMap() {
        return new AmazonMap("Amazon", 30, 5);
    }
}
