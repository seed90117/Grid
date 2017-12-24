package OutPut;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import InterFace.View;
import Program.Main;

public class DrawPanel {

	static Graphics g;
	public static double size;
	
	public static void drawpanel()
	{
		//*****JPanel��e��*****//
		g = View.show.getGraphics();
				
		//*****�M�ŵe��*****//
		g.setColor(Color.white);
								
		//*****�M�Žd��*****//
		g.fillRect(0, 0, View.show.getWidth(), View.show.getHeight());
				
		//*****�]�w�C��*****//
		g.setColor(Color.black);
				
		//*****�e���W���I*****//
		for(int i = 0; i < Main.total; i++)
		{
			int x = (int)((Main.point[i].x)*size);
			int y = (int)((Main.point[i].y)*size);
			g.fillRect(x, y, 1, 1);
		}
	}
	

	public static void drawgroup()
	{
		Color c;
		Set<Color> st = new HashSet<Color>();
		List<Color> lt = new ArrayList<Color>();
		//*****�M�ŵe��*****//
		g.setColor(Color.white);
		
		//*****�M�Žd��*****//
		g.fillRect(0, 0, View.show.getWidth(), View.show.getHeight());
		
		//*****�]�w�������C��*****//
		for(int i=0;i<Main.total;i++)
		{
			c = makeRandomColor();
			while(st.add(c) == false)
			{
				c = makeRandomColor();
			}
			lt.add(c);
		}
		
		//*****�e�I*****//
		for(int j = 0; j < Main.total; j++)
		{
			if(Main.point[j].group != -1)
			{
				g.setColor(lt.get(Main.point[j].group));
				int x = (int)(Main.point[j].x*size);
				int y = (int)(Main.point[j].y*size);
				g.fillRect(x, y, 1, 1);
			}
		}
	}
	
	public static Color makeRandomColor() {
		Random rd = new Random();
	    int red = rd.nextInt(256);
	    int green = rd.nextInt(256);
	    int blue = rd.nextInt(256);
	    return new Color(red, green, blue);
	}
}
