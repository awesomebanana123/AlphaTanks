package com.company;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
=======
import java.awt.*;
>>>>>>> refs/remotes/origin/master
import java.util.LinkedList;

/**
 * Created by akupp_000 on 5/8/2017.
 */
public class Bullet extends GameObject {
    //Add Handler object, loop through handler, check enum if it's a tank,
    // and getBounds of this class intersects a bounds of a tempObject in the loop.
    float gravity = -.3f;
    private Gun gun;
    int bulletWidth = 16;
    int bulletHeight = 16;

    Handler handler;

    public Bullet(float x, float y, ObjectId id, float velX, Gun gun, Handler handler ) {
		super(x, y, id);
		this.velX = velX;
        this.gun = gun;
        velY = (float) (10 * Math.sin(Math.toRadians(gun.getAngle())));
        this.handler = handler;
	}
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        velY += gravity;
        y -= velY ;
        if(hitTank()) {

            velX = 0;
            velY = 0;
            gravity = 0;
            handler.removeObject(this);
        }
	}

	public void render(Graphics g) {
<<<<<<< HEAD
		g.setColor(Color.ORANGE);
		g.fillRect((int) x, (int) y, 16, 16);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 16, 16);
	}
=======
            g.setColor(Color.BLUE);
            g.fillRect((int) x, (int) y, 1, 1);
            Graphics2D g2D = (Graphics2D) g;
            g2D.draw(getBounds());
            g2D.draw(getBoundsTop());
            g2D.draw(getBoundsRight());
            g2D.draw(getBoundsLeft());
>>>>>>> refs/remotes/origin/master


	}
	public String toString() {
		return null;
	}
    public Rectangle getBounds() {
        return new Rectangle((int) ((int)x + (bulletWidth/2)-((bulletWidth/2)/2)),(int) ((int)y + (bulletHeight/2)),(int)bulletWidth/2,(int)bulletHeight/2);
    }
    public Rectangle getBoundsTop() {
        return new Rectangle((int)((int)x+(bulletWidth/2)-((bulletWidth/2)/2)),(int)y,(int)bulletWidth/2, (int)bulletHeight/2);
    }
    public Rectangle getBoundsRight() {
        return new Rectangle((int) ((int)x+bulletWidth-5), (int)y+5,(int)5,(int)bulletHeight-10);
    }
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x,(int)y+5,(int)5,(int)bulletHeight-10);
    }
    public boolean hitTank(){
        for(GameObject tempObject : handler.object){
            if(tempObject.getID() == ObjectId.PlayerTank || tempObject.getID() == ObjectId.EnemyTank){
                Tank t = (Tank)tempObject;
                if(t.getBounds().intersects(getBounds())) {
                    t.setHealth(t.getHealth()-1);
                    System.out.println(t.getHealth());
                    return true;
                }
            }
        }
        return false;
    }

}
