package render.renderObjects;

import java.util.ArrayList;
import java.util.HashMap;

public class RenderObjectContainer {
	
	private ArrayList<RenderObject> renderObjects = new ArrayList<RenderObject>();
	
	private HashMap<Integer, RenderObject> renderObjectsByID = new HashMap<Integer, RenderObject>();

	
	public RenderObjectContainer() {
		
	}
	
	public void addRenderObject(RenderObject renderObject) {
		renderObjects.add(renderObject);
		renderObjectsByID.put(renderObject.getID(), renderObject);
	}
	
	public RenderObject getRenderObjectByIndex(int index) {
		return renderObjects.get(index);
	}
	
	public RenderObject getRenderObjectByID(int ID) {
		return renderObjectsByID.get(ID);
	}
	
	public int getNumberOfRenderObjects() {
		return renderObjects.size();
	}
	
}
