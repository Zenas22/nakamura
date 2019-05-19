import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String mSquadName;
    private int mSize;
    private String mCause;
    private static List<Squad> squads = new ArrayList<>();
    private int mId;

    public String getmSquadName() {
        return mSquadName;
    }

    public int getmSize() {
        return mSize;
    }

    public String getmCause() {
        return mCause;
    }

    public static List<Squad> getSquads() {
        return squads;
    }

    public int getmId() {
        return mId;
    }

    public static void clear() {
        squads.clear();
    }

    public static Squad find(int id){
        return squads.get(id-1);
    }

    public Squad(String squadName, int size, String cause){
        mSquadName = squadName;
        mSize = size;
        mCause = cause;
        squads.add(this);
        mId = squads.size();
    }

}