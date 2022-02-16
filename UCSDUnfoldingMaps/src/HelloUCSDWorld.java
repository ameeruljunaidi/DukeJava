import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

/**
 * Hello World!
 * 
 * This is the basic stub to start creating interactive maps.
 */
public class HelloUCSDWorld extends PApplet {
	private static final long serialVersionUID = 1L;

	UnfoldingMap map;

	public void setup() {
		size(800, 600, OPENGL);

		map = new UnfoldingMap(this, new Microsoft.RoadProvider());
		map.zoomAndPanTo(14, new Location(32.881, -117.238)); // UCSD

		MapUtils.createDefaultEventDispatcher(this, map);

		Location valLoc = new Location(32.881, -117.238); // Create a location object
		SimplePointMarker markerVal = new SimplePointMarker(valLoc); // Pass it on to a SimplePoint object
		map.addMarker(markerVal); // Add it to the map object
	}

	public void draw() {
		background(0);
		map.draw();
	}

}
