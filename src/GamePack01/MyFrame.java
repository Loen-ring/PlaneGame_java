package GamePack01;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

	private Image offScreenImage = null; //利用双缓冲技术消除闪烁
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(Constant.Window_WIDTH, Constant.Window_HEIGHT);
		}

		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public void launchFrame() {
		setSize(Constant.Window_WIDTH, Constant.Window_HEIGHT);
		setLocation(100, 100); //窗体位置：左上角为标志
		setVisible(true); //窗体是否可见：true

		new PaintThread().start();

		addWindowListener(new WindowAdapter() { //重写父类方法使窗口可以关闭
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	/*重画窗口的内部类*/
	class PaintThread extends Thread { //无需记忆 慢慢消化
		public void run() {
			while (true) {
				repaint(); //每隔40ms重画一次
				try {
					Thread.sleep(40); //1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}