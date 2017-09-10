package GamePack01;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends GameObject{
	
	double degree;
	
	


	public Bullet(){
	   degree = Math.PI*2*Math.random();
		x=Constant.Window_WIDTH/2;
		 y=Constant.Window_HEIGHT/2;
		width =6;
	     height =6;
	     speed = 5;
	}
	
	
	


	public void draw(Graphics g){
		
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int) x, (int) y, (int) width, (int) height);
		g.setColor(c);
		
		
		x +=speed*Math.cos(degree);
		y +=speed*Math.sin(degree);
		/*
		物体反射原理：当x方向上碰到边线，代表着所飞行物体碰到y轴，
		 * 此时变换后方向为180-原来方向；
		 * 同理当y方向上碰到边线则意味着碰到两个x轴，
		 * 变换方向为（-原来方向）
		 * */
		
		if(x <width||x>Constant.Window_WIDTH-width){
			//碰到左右两边，左边即当前x（横向移动值）已经小于子弹自身宽度，右边即当前x大于窗体宽度-子弹宽度
			degree = Math.PI - degree;
			}
		
		if(y <30+height||y>Constant.Window_HEIGHT-height){
			//30即标题栏高度
			//碰到上下两边，上边即当前y（纵向移动值）已经小于自身高度+标题栏高度，下边即当前高度大于窗体高度-子弹高度
			degree = -degree;
			}
		
		
		
		
		
		
	}
	

}
