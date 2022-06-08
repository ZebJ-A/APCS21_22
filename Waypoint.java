public class Waypoint implements Comparable<Waypoint> {
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    public Waypoint(String t, String n, String s, double ts, double tk, int e) {
        type = t;
        name = n;
        state = s;
        toSpringer = ts;
        toKatahdin = tk;
        elevation = e;
    }
    /**
     * JAVADOC
     * @return
     */
    public String getType() {
        return type;
    }
    /**
     * JAVADOC
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * JAVADOC
     * @return
     */
    public String getState() {
        return state;
    }
    /**
     * JAVADOC
     * @return
     */
    public double getToSpringer() {
        return toSpringer;
    }
    /**
     * JAVADOC
     * @return
     */
    public double getToKatahdin() {
        return toKatahdin;
    }

    /**
     * JAVADOC
     * @return
     */
    public int getElevation() {
        return elevation;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "type = '" + type + '\'' +
                ", name = '" + name + '\'' +
                ", state = '" + state + '\'' +
                ", toSpringer = " + toSpringer +
                ", toKatahdin = " + toKatahdin +
                ", elevation = " + elevation +
                '}';
    }

    public int compareTo(Waypoint other) {
        Double d1 = this.toKatahdin;
        Double d2 = other.toKatahdin;
        return (int)(this.toKatahdin - other.toKatahdin);
    }
}
