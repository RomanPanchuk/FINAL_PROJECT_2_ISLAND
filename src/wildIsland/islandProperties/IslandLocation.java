package wildIsland.islandProperties;

import wildIsland.service.Coordinate;

public class IslandLocation {
    private final int x;
    private final int y;

    public IslandLocation(Coordinate coordinates) {
        this.x = coordinates.getX();
        this.y = coordinates.getY();
    }
}
