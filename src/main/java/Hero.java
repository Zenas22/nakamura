import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String mJina;
    private int mMiaka;
    private String mStrength;
    private String mWeakness;
    private int mId;
    private static List<Hero> heroes = new ArrayList<Hero>();

    public String getmJina() {
        return mJina;
    }

    public int getmMiaka() {
        return mMiaka;
    }

    public String getmStrength() {
        return mStrength;
    }

    public String getmWeakness() {
        return mWeakness;
    }

    public int getmId() {
        return mId;
    }

    public static List<Hero> getHeroes() {
        return heroes;
    }

    public static void clear() {
        heroes.clear();
    }

    public static Hero find(int id) {
        return heroes.get(id - 1);
    }

    public Hero(String jina, int miaka, String strength, String weakness) {
        mJina = jina;
        mMiaka = miaka;
        mStrength = strength;
        mWeakness = weakness;
        heroes.add(this);
        mId = heroes.size();
    }
}