package GamePack01;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;



/**
 * 游戏编写中的常用工具类（比如：加载图片等）
 * @author wangyulong
 *
 */

public class GameUtil {
	
	private GameUtil() {
	} //工具类通常将构造器私有化 ，以便封装
	
	
	public static Image getImage(String path) {
			URL u = GameUtil.class.getClassLoader().getResource(path);
			BufferedImage img = null;
			
			try {
				img = ImageIO.read(u);
			} catch (IOException e) {
			// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return img;
			
		}
	
	

}
