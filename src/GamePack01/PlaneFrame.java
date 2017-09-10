package GamePack01;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
/**
 * 用于构建一个窗口；
 * 在游戏类的编写中注意封装，其中的许多类都可以在以后的编写中直接使用
 * @author wangyulong
 *
 */
public class PlaneFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/background.jpg");
	Image over = GameUtil.getImage("images/over.png");
	Plane p = new Plane("images/plane.png", 50, 50);
	ArrayList Bulletlist = new ArrayList();
	Explode bang;

	Date startTime = new Date();
	Date endTime = new Date();

	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		if (p.isLive()) {
			p.draw(g);
		}
		for (int j = 0; j < Bulletlist.size(); j++) {
			Bullet B = (Bullet) Bulletlist.get(j);
			B.draw(g);
			boolean pang = B.getRect().intersects(p.getRect());
			if (pang) {
				p.setLive(false);

				if (bang == null) {
					bang = new Explode(p.x, p.y);
					endTime = new Date();
				}
				bang.draw(g);
				break;
			}
		}
		if (!p.isLive()) {
			g.drawImage(over, (int) p.x, (int) p.y, null);
			printInfo(g, "Game Over", 150, 200, 80, Color.GREEN);
			int period = (int) ((endTime.getTime() - startTime.getTime()) / 1000);
			printInfo(g, "坚持时间：   " + period + "秒", 150, 250, 50, Color.orange);
		}

	}

	//重写launchFrame方法，添加键盘监听功能
	public void launchFrame() {
		super.launchFrame();
		addKeyListener(new Keymonitor());
		//生成一堆子弹
		for (int i = 0; i < 66; i++) {
			Bullet b = new Bullet();
			Bulletlist.add(b);
		}
		startTime = new Date();

	}

	/**
	 * 方法printinfo用于在窗口打印信息
	 * @param g
	 * @param str
	 * @param size
	 */
	public void printInfo(Graphics g, String str, int x, int y, int size, Color color) {
		Color c = g.getColor();
		g.setColor(color);

		Font F = new Font("楷体", Font.BOLD, size);
		g.setFont(F);
		g.drawString(str, x, y);
		g.setColor(c);
	}

	//使用内部类实现键盘监听
	class Keymonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			p.Direct_add(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.Direct_minus(e);
		}

	}

	public static void main(String[] args) {
		new PlaneFrame().launchFrame();

	}
}
