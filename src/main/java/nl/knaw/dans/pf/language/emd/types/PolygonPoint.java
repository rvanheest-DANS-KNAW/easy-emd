package nl.knaw.dans.pf.language.emd.types;

import java.io.Serializable;

public class PolygonPoint implements Serializable {

    private static final long serialVersionUID = -4108876677692958853L;

    private String x;
    private String y;

    public PolygonPoint() {}

    public PolygonPoint(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return this.x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return this.y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(x=%s, y=%s)", this.x, this.y);
    }

    public boolean isComplete() {
        return this.x != null && this.y != null;
    }
}
