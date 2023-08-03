package service;

import model.BaseCharacter;
import model.Map;
import model.MarioBaseCharacter;
import service.interfaces.IMarioBaseService;

public class MarioBaseService implements IMarioBaseService {
    @Override
    public void strengthenCharacter(MarioBaseCharacter marioBaseCharacter) {

    }

    @Override
    public void weakenCharacter(MarioBaseCharacter marioBaseCharacter) {

    }

    @Override
    public void decreaseHealth(MarioBaseCharacter marioBaseCharacter) {

    }

    @Override
    public boolean checkKill(Map map, BaseCharacter baseCharacter) {

        if (map.getMapPlacement()[baseCharacter.getCoordinate().getyAxis() - 1][baseCharacter.getCoordinate().getxAxis()] != null) {
            for (int i = 0; i < map.getVillains().size(); i++) {
                if (map.getVillains().get(i).getName().equals(map.getMapPlacement()[baseCharacter.getCoordinate().getyAxis() - 1][baseCharacter.getCoordinate().getxAxis()].getName())) {
                    System.out.println(map.getVillains().get(i).getName() + " killed!");
                    map.getVillains().remove(i);
                    map.getMapPlacement()[baseCharacter.getCoordinate().getyAxis() - 1][baseCharacter.getCoordinate().getxAxis()] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkDie(Map map, BaseCharacter baseCharacter, String direction) {
        if (direction.equals("Right")) {
            if (map.getMapPlacement()[baseCharacter.getCoordinate().getyAxis()][baseCharacter.getCoordinate().getxAxis() + 1] != null) {
                System.out.println(baseCharacter.getName() + " died!");
                return true;
            }
        } else if (direction.equals("Left")) {
            if (map.getMapPlacement()[baseCharacter.getCoordinate().getyAxis()][baseCharacter.getCoordinate().getxAxis() - 1] != null) {
                System.out.println(baseCharacter.getName() + " died!");
                return true;
            }
        }
        return false;
    }
}
