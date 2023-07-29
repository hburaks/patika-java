package service;

import Helper.Helper;
import model.Map;
import model.Villain;
import service.interfaces.IMapService;

import java.util.List;

public class MapService implements IMapService {
    @Override
    public void putVillainsToMap(Map map, List<Villain> villainList) {
        boolean[] villainPositions = Helper.createRandomPositions(map.getxLength(), villainList.size());
        int j = 0;
        for (int i = 0; i < villainPositions.length; i++) {
            if (villainPositions[i] == true) {
                villainList.get(j).getCoordinate().setxAxis(i);
                map.getMapPlacement()[villainList.get(j).getCoordinate().getyAxis()][villainList.get(j).getCoordinate().getxAxis()] = villainList.get(j);
                j++;
            }

        }
    }

    @Override
    public void printMap(Map map) {
        for (int y = map.getyLength() - 1; y >= 0; y--) {
            for (int x = 0; x < map.getxLength(); x++) {
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
                    System.out.print("---------------");
                }
            }
            System.out.println();
        }
    }
}