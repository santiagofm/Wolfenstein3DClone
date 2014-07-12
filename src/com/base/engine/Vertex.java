package com.base.engine;

public class Vertex
{
	public static final int SIZE = 8; //cantidad de numeros en clase
	
	private Vector3f pos;
	private Vector2f texCoord;
	private Vector3f normal;
	
	public Vertex(Vector3f pos)
	{
		this(pos, new Vector2f(0.f, 0.f));
	}
	
	public Vertex(Vector3f pos, Vector2f texCoord)
	{
		this(pos, texCoord, new Vector3f(0.f, 0.f, 0.f));
	}

	public Vertex(Vector3f pos, Vector2f texCoord, Vector3f normal)
	{
		this.setPos(pos);
		this.setTexCoord(texCoord);
		this.setNormal(normal);
	}
	
	public Vector3f getPos() {
		return pos;
	}

	public void setPos(Vector3f pos) {
		this.pos = pos;
	}

	public Vector2f getTexCoord() {
		return texCoord;
	}

	public void setTexCoord(Vector2f texCoord) {
		this.texCoord = texCoord;
	}

	public Vector3f getNormal() {
		return normal;
	}

	public void setNormal(Vector3f normal) {
		this.normal = normal;
	}
}
