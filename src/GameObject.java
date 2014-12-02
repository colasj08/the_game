import java.awt.*;
import java.awt.event.*; 
import com.jogamp.opengl.util.FPSAnimator;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.*;
import com.jogamp.opengl.util.gl2.GLUT;

public abstract class GameObject {

    public double x,y,z;		// position
    public int degrees;			// Degree measure of direction 
    public double xdir,zdir;		// Vector measure of direction 
    public double bounding_cir_rad;	// Radius of bounding circle -- to detect collision
    public int my_display_list;
    the_game my_playing_field;

    GameObject (double x, double y, double z,
		int degrees, 
		double bounding_cir_rad,
		int display_list,
		the_game playing_field,
		GLAutoDrawable drawable)  {
	this.x = x;
	this.y = y;
	this.z = z;
	this.degrees = degrees;
	xdir    = Math.cos(((double)degrees)*Math.PI/180.0);
	zdir    = Math.sin(((double)degrees)*Math.PI/180.0);
	this.bounding_cir_rad = bounding_cir_rad;
	my_display_list = display_list;
	my_playing_field = playing_field;
    }

    void turn(int degrees_rotation) {
	degrees = (degrees + degrees_rotation) % 360;
	xdir    = Math.cos(((double)degrees)*Math.PI/180.0);
	zdir    = Math.sin(((double)degrees)*Math.PI/180.0);
    }

    void move(double speed) {		// Pass in negative speed for backward motion
	x = x + speed * xdir;
	z = z + speed * zdir;
    }

    abstract void draw_self (GLAutoDrawable drawable); 
  
}
