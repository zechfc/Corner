import java.util.ArrayList;

public class MajorList {
    private static MajorList majorList;
    private static ArrayList<Major> majors;

    private MajorList(){
        majors = new ArrayList<Major>();
    }

    public static MajorList getInstance(){
        if (majorList == null){
            majorList = new MajorList();
        }
        return majorList;
    }

    public Major getMajor(String major){
        return new Major(null, null, null, null, null);
    }

    public void setMajor(){
        
    }
}
