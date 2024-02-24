import java.util.ArrayList;

public class MajorList {
    private static ArrayList<major> majorList;

    private static MajorList(){

    }

    public Major getInstance() {
        Major m = new Major()
        return m;
    }

    public Major getMajor(String major){
        for(int i = 0; i < majorList.size(); i++){
            if(major == majorList[i]){
                return major;
            }
            return "major not found";
        }
    }

    public void setMajor(String major){
        Major m = new Major(major);
        return m;
    }
}
