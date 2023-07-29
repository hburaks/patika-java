package service.interfaces;

import model.Map;
import model.Villain;

import java.util.List;

public interface IMapService {
        public void putVillainsToMap(Map map, List<Villain> villainList);
        public void printMap(Map map);

}
