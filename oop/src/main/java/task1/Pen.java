package task1;

public class Pen {
    private Color color;
    private Type type;

    @SuppressWarnings("WeakerAccess")
    public Pen(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + color.ordinal();
        hash = 31 * hash + type.ordinal();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Pen.class) {
            return false;
        }
        Pen other = (Pen) obj;
        return color.equals(other.color) && type.equals(other.type);
    }

    @Override
    public String toString() {
        return String.format("Pen{color=%s, type=%s}", color, type);
    }

    public enum Color {
        BLACK,
        BLUE,
        RED,
        GREEN
    }

    public enum Type {
        GEL,
        BALL_POINT,
        FEATHER
    }
}
