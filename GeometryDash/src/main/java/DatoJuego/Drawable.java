package DatoJuego;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;



/**
 * A class that represents some type of Drawable object like a shape or sprite.
 * This code was originally based on code from Marston Connell's MCLib:
 * https://github.com/TheMarstonConnell/MCLib/blob/master/src/xyz/marstonconnell/graphics/engine/drawing/Drawable.java
 * @author Colin Toft
 *
 */
public class Drawable implements KeyListener, MouseListener {

	protected BufferedImage currentImage;
	
	protected double x, y, width, height;
	
	protected Panel parentPanel = null;
	
	private boolean started = false;
	
	protected Color backgroundColor = new Color(0, 0, 0, 0); // Transparent background by default
	
	/** Whether the image needs to be updated every frame. */
	private boolean dynamic = true;
	
	private boolean visible = true;
	
	public Drawable(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Drawable(double x, double y, double size) {
		this(x, y, size, size);
	}
	
	/** Creates a new Drawable with the dimensions of its parent. */
	public Drawable() {
		this(0, 0, 1, 1);
	}
	
	/** Sets whether the image needs to be updated every frame. */
	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getCenterX() {
		return x + width * 0.5;
	}
	
	public double getCenterY() {
		return y + height * 0.5;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void moveLeft(double delta) {
		setX(x - delta);
	}

	public void moveRight(double delta) {
		setX(x + delta);
	}

	public void moveUp(double delta) {
		setY(y - delta);
	}

	public void moveDown(double delta) {
		setY(y + delta);
	}
	
	public void show() {
		visible = true;
	}
	
	public void hide() {
		visible = false;
	}
	
	public boolean isVisible() {
		return visible;
	}

	
	public void setImage(String name) {
		setImage(Util.loadImageFromFile(getClass(), name));
	}

	
	public void setImage(BufferedImage image) {
		currentImage = image;
		setDynamic(false);
	}
	
	public Image getImage() {
		if (parentPanel == null) {
			System.out.println("Drawable.getImage(): No panel defined, cannot create image.");
			return null;
		}
		
		if (dynamic) {
			Graphics2D g = currentImage.createGraphics();
			if (backgroundColor.getAlpha() > 0) {
				g.setColor(backgroundColor);
				g.fillRect(0, 0, currentImage.getWidth(), currentImage.getHeight());
			}
			draw(g);
		}
		
		return currentImage;
	}
	
	protected void togglePaused() {
		parentPanel.togglePaused();
	}
	
	protected void pauseGame() {
		parentPanel.pauseGame();
	}
	
	protected void resumeGame() {
		parentPanel.resumeGame();
	}
	
	protected boolean isPaused() {
		return parentPanel.isPaused();
	}
	
	
	public void start() {}
	
	
	public void draw(Graphics g) {}
	
	
	public void drawImage(Graphics g) {
		if (parentPanel == null) {
			System.out.println("Drawable.getImage(): No panel defined, cannot create image.");
			return;
		}
		
		if (dynamic) {
			if (backgroundColor.getAlpha() > 0) {
				g.setColor(backgroundColor);
				g.fillRect(0, 0, pixelWidth(), pixelHeight());
			}
			draw(g);
		} else {
			if (Math.abs(currentImage.getWidth(null) - pixelWidth()) <= 1 && Math.abs(currentImage.getHeight(null) - pixelHeight()) <= 1) {
				g.drawImage(currentImage, 0, 0, null);
			} else {
				g.drawImage(currentImage, 0, 0, pixelWidth(), pixelHeight(), null);
			}
		}
	}
	
	public void update(double dt) {}
	
	public void dispose() {
		currentImage = null;
	}
	
	public void setParentPanel(Panel p) {
		parentPanel = p;
		generateImage();
		if (!started) {
			started = true;
			start();
		}
	}
	
	public boolean hasParentPanel() {
		return parentPanel != null;
	}
	
	public Game getGame() {
		if (parentPanel != null) {
			return parentPanel.getGame();
		} else {
			return null;
		}
	}
	
	
	protected void generateImage() {
		currentImage = Util.getEmptyImage(pixelWidth(), pixelHeight());
		Graphics2D g = currentImage.createGraphics();
		if (!dynamic) {
    		if (backgroundColor.getAlpha() > 0) {
        		g.setColor(backgroundColor);
        		g.fillRect(0, 0, currentImage.getWidth(), currentImage.getHeight());
    		}
    		draw(g);
		}
	}
	
	public int pixelX() {
		return pixelX(0);
	}
	
	public int pixelY() {
		return pixelY(0);
	}
	
	
	public int pixelX(int leftInset) {
		if (parentPanel == null) {
			System.out.println("Drawable.pixelX(): No panel defined for object " + this + ", cannot calculate pixel X.");
		}
		return (int) Math.round(x * parentPanel.pixelWidth()) + leftInset;
	}
	
	public int pixelY(int topInset) {
		if (parentPanel == null) {
			System.out.println("Drawable.pixelY(): No panel defined for object " + this + ", cannot calculate pixel Y.");
		}
		return (int) Math.round(y * parentPanel.pixelHeight()) + topInset;
	}
	
	
	public int pixelWidth() {
		if (parentPanel == null) {
			System.out.println("Drawable.pixelWidth(): No panel defined, cannot calculate pixel width.");
		}
		return (int) Math.round(width * (parentPanel.pixelWidth()));
	}
	
	
	public int pixelHeight() {
		if (parentPanel == null) {
			System.out.println("Drawable.pixelHeight(): No panel defined, cannot calculate pixel height.");
		}
		return (int) Math.round(height * parentPanel.pixelHeight());
	}
	
	/**
	 * Converts a horizontal value from screen coordinates (pixels) to a fraction of the panel width (0 to 1)
	 * @param pixelX The original x coordinate, in pixels
	 * @return The same coordinate, but as a fraction of the panel width (0 is on the very left of the panel, 1 is on the very right)
	 */
	public double pixelToParentWidthFraction(int pixelX) {
		return (double) pixelX / parentPanel.pixelWidth();
	}
	
	/**
	 * Converts a vertical value from screen coordinates (pixels) to a fraction of the parent height (0 to 1)
	 * @param pixelY The original y coordinate, in pixels
	 * @return The same coordinate, but as a fraction of the panel height (0 is at the very top of the panel, 1 is at the very bottom)
	 */
	public double pixelToParentHeightFraction(int pixelY) {
		return (double) pixelY / parentPanel.pixelHeight();
	}
	
	public double parentWidthFractionToParentHeightFraction(double x) {
		return x * pixelWidth() / pixelHeight();
	}
	
	public double parentHeightFractionToParentWidthFraction(double y) {
		return y * pixelHeight() / pixelWidth();
	}
	
	public void setBackground(Color c) {
		backgroundColor = c;
	}
	
	public boolean isPointInFrame(double x, double y) {
		return x >= this.x && x <= (this.x + this.width) && y >= this.y && y <= (this.y + this.height);
	}
	
	/** This method is called whenever this drawable is clicked.
	 * @param x The x coordinate of the click based on the width of this drawable (0 is the left of this object, 1 is the right)
	 * @param y The y coordinate of the click based on the height of this drawable (0 is the top of this object, 1 is the bottom)
	 * @param button The button pressed, as returned from {@link MouseEvent#getButton()} */
	public void onMousePressed(double x, double y, int button) {}
	
	/** This method is called whenever a click on this drawable is released.
	 * @param x The x coordinate of the click based on the width of this drawable (0 is the left of this object, 1 is the right)
	 * @param y The y coordinate of the click based on the height of this drawable (0 is the top of this object, 1 is the bottom)
	 * @param button The button pressed, as returned from {@link MouseEvent#getButton()} */
	public void onMouseReleased(double x, double y, int button) {}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	
	public void mouseReleased(MouseEvent e) {}

	
	public void mouseEntered(MouseEvent e) {}

	
	public void mouseExited(MouseEvent e) {}

	
	public void keyTyped(KeyEvent e) {}

	
	public void keyPressed(KeyEvent e) {}

	
	public void keyReleased(KeyEvent e) {}
	
	public void onPause() {}
	
	public void onResume() {}
}