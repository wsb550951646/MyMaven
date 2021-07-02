package sweng.utils;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/615:05
 */
public class SortOrder {

    private String name;
    private boolean asc;

    private SortOrder(String name, boolean asc) {
        this.name = name;
        this.asc = asc;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAsc() {
        return this.asc;
    }

    public static SortOrder asc(String name) {
        return new SortOrder(name, true);
    }

    public static SortOrder desc(String name) {
        return new SortOrder(name, false);
    }
}
