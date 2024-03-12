import java.util.ArrayList;

public class MajorList {
    private static MajorList majorList;
    private static ArrayList<Major> majors;

    private MajorList() {
        majors = new ArrayList<Major>();
    }

    public static MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
        }
        return majorList;
    }

    public Major getMajor(String major){
        for (Major newmajor:majors){
            if(major.equals(newmajor.getMajor())){
                return newmajor;
            }
            
        }

        return null;
    }

    /**
     *
     * @param major String to change major name to
     * @return String containing major name
     */
    public String setMajor(String major){
        // iterate list, when major is found, set major
        return major;
    }
}
