package org.tenbit.reduc.entity;

import org.lwjgl.util.vector.Vector2f;
import org.tenbit.reduc.Layer;
import org.tenbit.reduc.Reduc;

public class Entity {

	public int original_width;
	public int original_height;
	
	private float ratio = 1f;
	public float width ;
	public float height ;
	
	public float rotation = 0;
	protected float rotationSpeed = 0;
	
	protected float tick;
	private float frozenTickCounter=0;
	private float freezeDuration = 0;
	private float freezeSpeed = 0;
	private float freezingPercentage = 0;
	
	protected boolean frozen = false;
	protected boolean freezing = false;
	
	protected Layer layer = null;
	
	public Vector2f speed = new Vector2f();
	public Vector2f position = new Vector2f();

	public void spawn(Vector2f position,Vector2f speed,Layer layer )
	{
		this.position.x = position.x;
		this.position.y = position.y;
		
		this.speed.y = speed.y;
		this.speed.x = speed.x;
		
		this.layer = layer;
		this.layer.add(this);
	}
	
	public void spawn(Vector2f position,Vector2f speed, float rotationSpeed,Layer layer  )
	{
		spawn(position,speed,layer);
		this.rotationSpeed = rotationSpeed;
	}
	
	public void unSpawn()
	{
		layer.remove(this);
	}
	
	public void draw() {
		
	}
	
	protected Vector2f interpolate(Vector2f old_position,Vector2f speed)
	{
		old_position.x = old_position.x + tick * speed.x;
		old_position.y = old_position.y + tick * speed.y;
		
		return old_position;
	}
	
	public void update()
	{
		interpolate(position,speed);
		this.rotation += rotationSpeed * tick ;
		if (this.position.x - this.width > (Reduc.SCREEN_WIDTH / 2) || this.position.x + this.width < - (Reduc.SCREEN_WIDTH / 2))
		{
			unSpawn();
			//if (Logger.isLogActivate) Logger.log(this.getClass().getName()+" died");
			return;
		}
	}
	
	// This part has been added
	public void updateTick()
	{
		if (freezing)
		{

			if (frozen)
			{
				// You may wonder why I multiply by 10.
				// It is because on very "fast" computer, fps
				// may be so high and tick so small that
				// frozenTickCounter get no updated and
				// unfreeze never happen
				frozenTickCounter += tick  * 10;

				if (frozenTickCounter > freezeDuration)
				{
					frozen = false;
					frozenTickCounter = 0;
					// Have to start to defroze
					freezeSpeed = -freezeSpeed;
				}
				else
				{
					tick = 0;
				}
			}
			else
			{
				// Update tick according to freeze Speed
				// Note this can be the froze or defroze process...
				freezingPercentage += Reduc.tick * freezeSpeed;
				tick = Reduc.tick - freezingPercentage * Reduc.tick;
				if (tick < 0 )
				{
					this.frozen = true;		
					this.unSpawn();
					//this.spawn(this.position,this.speed,Reduc.bullets);
					//this.life = 50;

				}
				if (tick > Reduc.tick)
				{
					freezingPercentage = 0;
					this.freezing = false;

				}
			}
		}
		else
			tick = Reduc.tick;

	}

	public void freeze(float freezeDuration, float freezeSpeed)
	{
		this.freezeDuration = freezeDuration;
		this.freezeSpeed = freezeSpeed;
		this.freezing = true ;
	}

	public Layer getLayer() {
		return layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}
}
