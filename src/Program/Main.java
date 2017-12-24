package Program;

import java.util.ArrayList;
import java.util.List;

import OutPut.DrawPanel;
import Value.data;

public class Main {

	public static data[] point;
	public static int total;
	public static int grid;
	public static int quantity;
	public static double maxx;
	public static double maxy;
	static double gridhigh;
	static double gridwidth;
	static int[][] group;
	static int[][] isgroup;
	static List<Integer> px;
	static List<Integer> py;
	
	public static void main()
	{
		//*****計算每格大小*****//
		gridsize();

		group = new int[grid][grid];
		isgroup = new int[grid][grid];
		px = new ArrayList<Integer>();
		py = new ArrayList<Integer>();
		
		
		//*****計算每格資料點數量*****//
		for(int m=0;m<total;m++)
		{
			int x = (int)(point[m].x/gridwidth);
			int y = (int)(point[m].y/gridhigh);
			if(x == grid)
			{
				x = x-1;
			}
			if(y == grid)
			{
				y = y-1;
			}
			group[x][y] = group[x][y]+1;
		}
		
		//*****合併群組*****//
		int count=1;
		for(int y=0;y<grid;y++)
		{
			for(int x=0;x<grid;x++)
			{
				eight(x,y,count);
				for(int i=0;i<px.size();i++)
				{
					eight(px.get(i),py.get(i),count);
				}
				px.clear();
				py.clear();
				count++;
			}
		}
		
		//*****將資料點放入格子內*****//
		for(int m=0;m<total;m++)
		{
			int x = (int)(point[m].x/gridwidth);
			int y = (int)(point[m].y/gridhigh);
			if(x == grid)
			{
				x = x-1;
			}
			if(y == grid)
			{
				y = y-1;
			}
			if(isgroup[x][y] != 0)
			{
				point[m].group = isgroup[x][y];
			}
			else
			{
				point[m].group = -1;
			}
		}
		
		DrawPanel.drawgroup();
	}
	public static void eight(int x,int y,int g)
	{
		if(x-1 > -1)//左
		{
			grouping(x-1,y,g);
		}
		if(x-1 >-1 && y-1 > -1)//左上
		{
			grouping(x-1,y-1,g);
		}
		if(x-1 >-1 && y+1 > grid)//左下
		{
			grouping(x-1,y+1,g);
		}
		if(y-1 > -1)//上
		{
			grouping(x,y-1,g);
		}
		if(x+1 < grid && y-1 > -1)//右上
		{
			grouping(x+1,y-1,g);
		}
		if(x+1 < grid)//右
		{
			grouping(x+1,y,g);
		}
		if(x+1 < grid && y+1 < grid)//右下
		{
			grouping(x+1,y+1,g);
		}
		if(y+1 < grid)//下
		{
			grouping(x,y+1,g);
		}
	}
	
	public static void grouping(int x,int y,int g)
	{
		if(group[x][y] >= quantity && isgroup[x][y] == 0)
		{
			px.add(x);
			py.add(y);
			isgroup[x][y] = g;
		}
	}
	
	//*****計算網格大小*****//
	public static void gridsize()
	{
		gridwidth = maxx/grid;
		gridhigh = maxy/grid;
	}
}
