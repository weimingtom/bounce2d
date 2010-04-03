package Bounce;

import Util.Vector2;

public abstract class PhysicsObject 
{		
	protected final String name;
	
	protected float mass;
	protected float inertia;
	protected float damp;
	protected float angDamp;
	protected float restitution;
		
	protected float radius;
	protected Vector2 cm;
	protected Vector2 cmold;
	protected Vector2 dcm;
	protected Vector2 dcmOld;
	protected Vector2 v;
	protected Vector2 vold;
	protected Vector2 f;
	protected float torque;
	protected float angVel;
	protected float angVelOld;
	protected float theta;
	protected float thetaold;
	
	protected boolean isStatic; // Immovable object
	protected boolean isGhost; // Not solid
	protected boolean isRotated; // Can the object rotate
	
	public PhysicsObject( String name, Vector2 cm, float mass )
	{			
		this.name = name;
		
		this.mass = mass;
		this.inertia = 1;
		this.damp = .0001f;
		this.angDamp = .0001f;
		this.restitution = 1;		
		
		this.radius = 0;	
		this.cm = new Vector2( cm );
		this.cmold = new Vector2( cm );
		this.dcm = new Vector2( 0, 0 );
		this.dcmOld = new Vector2( 0, 0 );
		this.v = new Vector2( 0, 0 );
		this.vold = new Vector2( 0, 0 );
		this.f = new Vector2( 0, 0 );		
		this.torque = 0;
	    this.angVel = 0;
	    this.angVelOld = 0;
	    this.theta = 0;  
	    this.thetaold = 0;	    	    
		

		if( this.mass == 0 )
		{
			isStatic = true;
		}
		else
		{
			isStatic = false;
		}
		if( this.mass < 0 )
		{
			isGhost = true;
		}
		else
		{
			isGhost = false;
		}
		isRotated = false;
	}
	
	public String getName()
	{
		return new String( name );
	}
	
	public Vector2 getPos()
	{
		return new Vector2( cm );
	}
	
	public void setPos( Vector2 p )
	{
		this.cm.set( p );
	}
	
	public void addForce( Vector2 f )
	{
		this.f.set( f );
	}
	
	public void setForce( Vector2 f )
	{
		this.f.set( f );
	}
	
	public void setSpeed( Vector2 speed )
	{
		this.v.set( speed );
	}
	
	public float getRotation()
	{
		return theta;
	}
	
	public void setRotation( float theta )
	{
		this.theta = theta;
	}
	
	public void setRestitution( float restitution )
	{
		this.restitution = restitution;
	}
	
	public void setDampening( float damp )
	{
		this.damp = damp;
	}
	
	public void setIsRoteted( Boolean isRotated )
	{
		this.isRotated = isRotated;
	}
}
