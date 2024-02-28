import java.util.ArrayList;
import java.util.HashMap;

public class MajorMap {
    public MajorMap(Major major, ArrayList<Class> concentration, ArrayList<Class> liberalArts, ArrayList<Class> carolinaCore, ArrayList<Class> other, HashMap<Class, grade> classesTaken){
        major = null;
        concentration = null;
        liberalArts = null;
        carolinaCore = null;
        other = null; //these are electives basically
        classesTaken = null;
    }

    public MajorMap whatIf(Major major){
       // MajorMap newMajorMap = new MajorMap(major, null, null, null, null, null);
       // return newMajorMap;
       return null;
    }
}
