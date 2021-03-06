import java.awt.*;
import java.awt.event.*; 
import com.jogamp.opengl.util.FPSAnimator;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.*;
import com.jogamp.opengl.util.gl2.GLUT;

public class Hero extends GameObject {

  Hero (double x, double y, double z,
		int degrees, 
		double bounding_cir_rad,
		int display_list,
		the_game playing_field,
		GLAutoDrawable drawable)

    {
	super (x, y, z, degrees, bounding_cir_rad, display_list, playing_field, drawable);

	GL2 gl = drawable.getGL().getGL2();
	GLUT glut = my_playing_field.glut;

	gl.glNewList(my_display_list, GL2.GL_COMPILE);
	glut.glutSolidCone( bounding_cir_rad, 25.0, 8, 4 );
	gl.glEndList();
    }

  void draw_self (GLAutoDrawable drawable) {

      GL2 gl = drawable.getGL().getGL2();

      gl.glPushMatrix();
      gl.glTranslated(x, 0.0, z );
      gl.glRotated(-90.0,  1.0,0.0,0.0);
      gl.glCallList(my_display_list);
      gl.glPopMatrix();
  }

}