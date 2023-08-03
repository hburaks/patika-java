package service;

import model.*;
import service.interfaces.ILoadService;

import java.util.ArrayList;
import java.util.List;

public class LoadService implements ILoadService {

    @Override
    public List<Villain> loadVillains() {
        List<Villain> villainList = new ArrayList<>();

        Villain reptile = new Raptiles("Reptile", 1, true, 1, MoveTypeEnum.WALKER, new Coordinate(0, 0));
        Villain turtle = new Turtles("Turtle", 1, true, 2, MoveTypeEnum.WALKER, new Coordinate(0, 0));
        Villain flyingTurtle = new FlyingTurtle("Flying Turtle", 1, true, 1, MoveTypeEnum.FLYER, new Coordinate(0, 0));
        Villain fireRotatingChain = new FireRotatingChain("Fire Rotating", 1, false, 1, MoveTypeEnum.STANDER, new Coordinate(0, 0));
        Villain reptile2 = new Raptiles("Reptile", 1, true, 1, MoveTypeEnum.WALKER, new Coordinate(0, 0));
        Villain turtle2 = new Turtles("Turtle", 1, true, 2, MoveTypeEnum.WALKER, new Coordinate(0, 0));
        Villain flyingTurtle2 = new FlyingTurtle("Flying Turtle", 1, true, 1, MoveTypeEnum.FLYER, new Coordinate(0, 0));
        Villain fireRotatingChain2 = new FireRotatingChain("Fire Rotating", 1, false, 1, MoveTypeEnum.STANDER, new Coordinate(0, 0));

        villainList.add(reptile);
        villainList.add(turtle);
        villainList.add(flyingTurtle);
        villainList.add(fireRotatingChain);
        villainList.add(reptile2);
        villainList.add(turtle2);
        villainList.add(flyingTurtle2);
        villainList.add(fireRotatingChain2);

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
        return new AmazonMap("Amazon", 15, 3);
    }


}
