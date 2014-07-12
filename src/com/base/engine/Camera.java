package com.base.engine;

public class Camera
{
	public static final Vector3f yAxis = new Vector3f(0.f, 1.f, 0.f);
	
	private Vector3f pos;
	private Vector3f forward;
	private Vector3f up;
	
	public Camera()
	{
		this(new Vector3f(0.f, 0.f, 0.f), new Vector3f(0.f, 0.f, 1.f), new Vector3f(0.f, 1.f, 0.f));
	}
	
	public Camera(Vector3f pos, Vector3f forward, Vector3f up)
	{
		this.setForward(forward);
		this.setPos(pos);
		this.setUp(up);
		
		up.normalize();
		forward.normalize();
	}
	
	Vector2f centerPosition = new Vector2f(Window.getWidth()/2, Window.getHeight() / 2);
	boolean mouseLocked = false;
	
	public void input()
	{
		float sensitivity = 0.3f;
		float movAmt = (float)(10 * Time.getDelta());
		//float rotAmt = (float)(100 * Time.getDelta());
		
		if(Input.getKey(Input.KEY_ESCAPE))
		{
			Input.setCursor(true);
			mouseLocked = false;
		}
		
		if(Input.getMouse(0)) 
		{
			Input.setMousePosition(centerPosition);
			Input.setCursor(false);
			mouseLocked = true;
		}
		
		if(Input.getKey(Input.KEY_W))
		{
			move(getForward(), movAmt);
		}
		if(Input.getKey(Input.KEY_S))
		{
			move(getForward(), -movAmt);
		}
		if(Input.getKey(Input.KEY_A))
		{
			move(getLeft(), movAmt);
		}
		if(Input.getKey(Input.KEY_D))
		{
			move(getRight(), movAmt);
		}
		
		if(mouseLocked)
		{		
			Vector2f deltaPos = Input.getMousePosition().sub(centerPosition);
			
			boolean rotY = deltaPos.getX() != 0;
			boolean rotX = deltaPos.getY() != 0;
			
			if(rotY)
			{
				rotateY(deltaPos.getX() * sensitivity);
			}
			if(rotX)
			{
				rotateX(-deltaPos.getY() * sensitivity);
			}
			
			if(rotY || rotX)
			{
				Input.setMousePosition(new Vector2f(Window.getWidth() / 2, Window.getHeight() / 2));
			}
		}
	}
	
	public void move(Vector3f dir, float amt)
	{
		pos = pos.add(dir.mul(amt));
	}
	
	public void rotateX(float angle)
	{
		Vector3f Haxis = yAxis.cross(forward).normalize();
		
		forward = forward.rotate(angle, Haxis).normalize();
		
		up = forward.cross(Haxis).normalize();
	}
	
	public void rotateY(float angle)
	{
		Vector3f Haxis = yAxis.cross(forward).normalize();
		
		forward = forward.rotate(angle, yAxis).normalize();
		
		up = forward.cross(Haxis).normalize();
	}
	
	public Vector3f getLeft()
	{
		Vector3f left = forward.cross(up).normalize();
		
		return left;
	}

	public Vector3f getRight()
	{
		Vector3f right = up.cross(forward).normalize();
		
		return right;
	}
	
	public Vector3f getPos() {
		return pos;
	}

	public void setPos(Vector3f pos) {
		this.pos = pos;
	}

	public Vector3f getForward() {
		return forward;
	}

	public void setForward(Vector3f forward) {
		this.forward = forward;
	}

	public Vector3f getUp() {
		return up;
	}

	public void setUp(Vector3f up) {
		this.up = up;
	}
}
