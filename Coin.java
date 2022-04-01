public abstract class Coin {
    /**
     * Javadoc
     */
    public abstract double getValue();

    /**
     * Javadoc
     */
    public abstract String getName();

    /**
     *
     * @return
     */
    public String getPluralName() {
        if(getName().equals("penny"))
            return "pennies";
        else
            return getName() + "s";
    }
}
