package camera;

import vector.Vector;

public class Camera {
	/**
	 * Coordinates at which the center of the camera will be aimed. (kilometers, kilometers)
	 */
	private Vector position = new Vector();
	/**
	 * Camera center will be offset by this amount. (kilometers, kilometers)
	 */
	private Vector offset = new Vector();
	/**
	 * Zoom factor. (pixels/kilometers)
	 */
	private double pixelsPerKilometer = 0.1;
	
	
	public Camera() {
		
	}
	
	public Camera(Vector position) {
		
	}
	
	/**
	 * @return camera position (kilometers, kilometers)
	 */
	public Vector getPosition() {
		return position;
	}
	
	/**
	 * @param newPosition new camera position (kilometers, kilometers)
	 */
	public void setPosition(Vector newPosition) {
		position.set(newPosition.getX(), newPosition.getY());
	}
	
	/**
	 * @return camera offset distance (kilometers, kilometers)
	 */
	public Vector getOffset() { 
		return offset;
	}
	
	/**
	 * @param newOffset new camera offset distance (kilometers, kilometers)
	 */
	public void setOffset(Vector newOffset) { 
		offset.set(newOffset.getX(), newOffset.getY());
	}
	
	/**
	 * @return zoom factor (pixels/kilometer)
	 */
	public double getZoom() {
		return pixelsPerKilometer;
	}
	
	/**
	 * @param newPixelsPerKilometer new zoom factor (pixels/kilometer)
	 */
	public void setZoom(double newPixelsPerKilometer) { 
		pixelsPerKilometer = newPixelsPerKilometer;
	}
	
	
}
