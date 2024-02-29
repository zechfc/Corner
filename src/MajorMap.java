import java.util.ArrayList;
import java.util.HashMap;

public class MajorMap {
    public MajorMap(Major major, ArrayList<Course> concentration, ArrayList<Course> liberalArts, ArrayList<Course> carolinaCore, ArrayList<Course> other, HashMap<Course, grade> classesTaken){
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
