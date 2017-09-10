package GamePack01;

import java.awt.Graphics;
import java.awt.Image;

public class Explode {
	
	static Image[] imgs = new Image[8];
	
	int count;
	double x,y;
	
	
	//静态变量用静态程序块初始化
	static {
		for(int i =0;i<8;i++){
			imgs[i] = GameUtil.getImage("explode/" +(i+1)+".png");
			imgs[i].getWidth(null);
			
		}
	}
	
	public void draw(Graphics g){
		
		if(count<8){
		g.drawImage(imgs[count], (int)x, (int)y, null);
		count++;
	}
	}

	public Explode(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}
