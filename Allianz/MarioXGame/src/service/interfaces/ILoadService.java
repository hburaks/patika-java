package service.interfaces;

import model.Map;
import model.MarioBaseCharacter;
import model.Villain;

import java.util.List;

public interface ILoadService {
    public List<Villain> loadVillains();
    public MarioBaseCharacter loadMario();
    public MarioBaseCharacter loadLuigi();
    public Map loadMap();

}
