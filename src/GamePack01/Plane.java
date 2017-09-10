package GamePack01;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
	
	
	private boolean live = true;
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	
	
	
	
	public Plane(String imagepath, double x, double y) {
		super();
		this.img = GameUtil.getImage(imagepath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x;
		this.y = y;
		this.speed = 15;
	}
	
	boolean right,left,up,down;
	
	//加方向 即按键后飞机向着该方向运动
	public void Direct_add(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: 
			left =true;
			break;
		case KeyEvent.VK_UP: 
			up =true;
			break;
		case KeyEvent.VK_RIGHT: 
			right =true;
			break;
		case KeyEvent.VK_DOWN: 
			down =true;
			break;
		default:
				break;
		}	
	}
	
	//减方向
	public void Direct_minus(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: 
			left =false;
			break;
		case KeyEvent.VK_UP: 
			up =false;
			break;
		case KeyEvent.VK_RIGHT: 
			right =false;
			break;
		case KeyEvent.VK_DOWN: 
			down =false;
			break;
		default:
				break;
		}	
	}
	
	
	
	//move代表按键后飞机的运动方式
	public void move(){
		if(left){x -=speed;}
		if(right){x +=speed;}
		if(up){y -=speed;}
		if(down){y +=speed;}
				}

	
	public void draw(Graphics g){
		g.drawImage(img, (int)x, (int)y, null);
		move();
	}
	

}
