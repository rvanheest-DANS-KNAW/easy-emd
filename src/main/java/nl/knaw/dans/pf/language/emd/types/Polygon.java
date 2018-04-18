package nl.knaw.dans.pf.language.emd.types;

import java.util.List;

public class Polygon extends Spatial.Locator {

    private static final long serialVersionUID = 7316626274747251053L;

    private String place;
    private PolygonPart exterior;
    private List<PolygonPart> interior;

    public Polygon() {
        super();
    }

    public Polygon(String scheme, PolygonPart exterior, List<PolygonPart> interior) {
        super(scheme);
        this.exterior = exterior;
        this.interior = interior;
    }

    public Polygon(String scheme, String place, PolygonPart exterior, List<PolygonPart> interior) {
        super(scheme);
        this.place = place;
        this.exterior = exterior;
        this.interior = interior;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public PolygonPart getExterior() {
        return this.exterior;
    }

    public void setExterior(PolygonPart exterior) {
        this.exterior = exterior;
    }

    public List<PolygonPart> getInterior() {
        return this.interior;
    }

    public void setInterior(List<PolygonPart> interior) {
        this.interior = interior;
    }

    @Override
    public String toString() {
        return String.format("(exterior=%s, interior=%s)", this.exterior, this.interior);
    }

    public boolean isComplete() {
        return this.exterior != null && this.interior != null && this.exterior.isComplete() && isComplete(this.interior);
    }

    private boolean isComplete(List<PolygonPart> pps) {
        for (PolygonPart pp : pps) {
            if (!pp.isComplete())
                return false;
        }
        return true;
    }
}
