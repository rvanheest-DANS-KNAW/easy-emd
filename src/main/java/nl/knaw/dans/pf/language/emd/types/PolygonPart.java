package nl.knaw.dans.pf.language.emd.types;

import java.util.List;

public class PolygonPart {

    private String place;
    private List<PolygonPoint> points;

    public PolygonPart() {}

    public PolygonPart(String place, List<PolygonPoint> points) {
        this.place = place;
        this.points = points;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<PolygonPoint> getPoints() {
        return this.points;
    }

    public void setPoints(List<PolygonPoint> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return String.format("(place=%s, points=%s)", this.place, this.points);
    }

    public boolean isComplete() {
        return this.place != null && this.points != null && isComplete(this.points);
    }

    private boolean isComplete(List<PolygonPoint> pps) {
        for (PolygonPoint pp : pps) {
            if (!pp.isComplete())
                return false;
        }
        return true;
    }
}
