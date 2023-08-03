package service;

import Helper.Helper;
import model.BaseCharacter;
import model.Map;
import model.MarioBaseCharacter;
import model.Villain;
import service.interfaces.IMapService;
import service.interfaces.IMarioBaseService;

import java.util.List;
import java.util.Scanner;

public class MapService implements IMapService {
    IMarioBaseService marioBaseService = new MarioBaseService();

    @Override
    public void putVillainsToMap(Map map, List<Villain> villainList) {
        map.getVillains().addAll(villainList);
        boolean[] villainPositions = Helper.createRandomPositions(map.getXLength() - 3, villainList.size());
        int j = 0;
        for (int i = 0; i < villainPositions.length; i++) {
            if (villainPositions[i]) {
                villainList.get(j).getCoordinate().setxAxis(i + 3);
                map.getMapPlacement()[villainList.get(j).getCoordinate().getyAxis()][villainList.get(j).getCoordinate().getxAxis()] = villainList.get(j);
                j++;
            }
        }
    }

    @Override
    public void putCharacterToMap(Map map, MarioBaseCharacter character) {
        map.getMapPlacement()[0][0] = character;
        character.getCoordinate().setxAxis(0);
        character.getCoordinate().setyAxis(0);
    }

    @Override
    public void printMap(Map map) {
        for (int y = map.getYLength() - 1; y >= 0; y--) {
            for (int x = 0; x < map.getXLength(); x++) {
                if (map.getMapPlacement()[y][x] != null && map.getMapPlacement()[y][x].getName() != null) {
                    if (map.getMapPlacement()[y][x].getName().length() < 15) {
                        int spaceCountToAdd = 15 - map.getMapPlacement()[y][x].getName().length();
                        if (spaceCountToAdd % 2 == 1) {
                            map.getMapPlacement()[y][x].setName(map.getMapPlacement()[y][x].getName() + " ");
                        }
                        for (int i = 0; i < spaceCountToAdd / 2; i++) {
                            map.getMapPlacement()[y][x].setName(" " + map.getMapPlacement()[y][x].getName() + " ");
                        }
                    }
                    System.out.print(map.getMapPlacement()[y][x].getName());
                } else {
                    System.out.print(".             .");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < map.getXLength() * 15; i++) {
            System.out.print("\\");
        }
        System.out.println();
    }

    @Override
    public boolean moveRight(Map map, BaseCharacter baseCharacter) {
        if (!marioBaseService.checkDie(map, baseCharacter, "Right")) {
            moveCharacter(map, baseCharacter, 1, 0);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean moveLeft(Map map, BaseCharacter baseCharacter) {
        if (!marioBaseService.checkDie(map, baseCharacter, "Left")) {
            moveCharacter(map, baseCharacter, -1, 0);
            return true;
        }
        ;
        return false;
    }

    @Override
    public void moveUp(Map map, BaseCharacter baseCharacter) {
        moveCharacter(map, baseCharacter, -1, 0);
    }

    @Override
    public void moveDown(Map map, BaseCharacter baseCharacter) {
        moveCharacter(map, baseCharacter, 0, -1);
    }

    @Override
    public void jumpLeft(Map map, BaseCharacter baseCharacter) {
        moveCharacter(map, baseCharacter, -1, 1);
        marioBaseService.checkKill(map, baseCharacter);
        moveDown(map, baseCharacter);
    }

    @Override
    public void jumpRight(Map map, BaseCharacter baseCharacter) {
        moveCharacter(map, baseCharacter, +1, 1);
        marioBaseService.checkKill(map, baseCharacter);
        moveDown(map, baseCharacter);
    }

    @Override
    public void moveCharacter(Map map, BaseCharacter baseCharacter, int x, int y) {
        if (map.getXLength() > baseCharacter.getCoordinate().getxAxis() + x &&
                0 <= baseCharacter.getCoordinate().getxAxis() + x &&
                map.getYLength() > baseCharacter.getCoordinate().getyAxis() + y &&
                0 <= baseCharacter.getCoordinate().getyAxis() + y) {
            int currentXCoordinate = baseCharacter.getCoordinate().getxAxis();
            int currentYCoordinate = baseCharacter.getCoordinate().getyAxis();

            int nextXCoordinate = currentXCoordinate + x;
            int nextYCoordinate = currentYCoordinate + y;

            baseCharacter.getCoordinate().setxAxis(nextXCoordinate);
            baseCharacter.getCoordinate().setyAxis(nextYCoordinate);

            map.getMapPlacement()[currentYCoordinate][currentXCoordinate] = null;
            map.getMapPlacement()[nextYCoordinate][nextXCoordinate] = baseCharacter;
            printMap(map);
        }
    }

    @Override
    public boolean askToMoveCharacter(Map map, BaseCharacter baseCharacter) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Jump Right = R, Jump Left = L, Left = l, Right = r. Select Your Move:");
        String move = inp.nextLine().trim();
        if (move.equals("r")) {
            return moveRight(map, baseCharacter);
        } else if (move.equals("l")) {
            return moveLeft(map, baseCharacter);
        } else if (move.equals("L")) {
            jumpLeft(map, baseCharacter);
            return true;
        } else if (move.equals("R")) {
            jumpRight(map, baseCharacter);
            return true;
        } else {
            return true;
        }

    }

    @Override
    public boolean isGameFinished(Map map, BaseCharacter character) {
        if (character.getCoordinate().getxAxis() >= map.getXLength() - 1) {
            System.out.println("Mission passed.");
            return true;
        }
        return false;
    }
}