package drawingboard직접구현;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

class Mypanel extends MyUtil {
	private int x = 0;
	private int y = 0;
	private int xx = 0;
	private int yy = 0;
	private int l1 = 0;
	private int l2 = 0;

	private JButton close = new JButton();

	private boolean c = false;

	public Mypanel() {
		setLayout(null);
		setBounds(0, 0, 700, 700);
		setBackground(Color.white);
		setFocusable(true);

		// 버튼 초기화 메서드
		setClose();

		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	private void setClose() {
		// TODO Auto-generated method stub
		close.setBounds(550, 600, 100, 50);
		close.setText("close");
		close.addMouseListener(this);
		add(close);
	}

	// 버튼클릭시
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton tmp = (JButton) e.getSource();
		if (tmp.equals(close)) {
			System.out.println("if in");
		}
		System.out.println("if out");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		c = true;
		xx = 0;
		yy = 0;
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		xx = e.getX();
		yy = e.getY();
		l1 = Math.abs(xx - x);
		l2 = Math.abs(yy - y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		c = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (c && e.isShiftDown() == true && yy != 0 && xx != 0) {
			System.out.println("쉬프트");
			l1 = Math.abs(xx - x);
			l2 = Math.abs(yy - y);

			if (l1 > l2) {
				l2 = l1;
			} else {
				l1 = l2;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// System.out.println(c);
		if (yy != 0 && xx != 0) {
			if (xx - x < 0 && yy - y < 0) {
				g.drawRect(xx, yy, l1, l2);
			} else if (xx - x < 0 && yy - y >= 0) {
				g.drawRect(xx, y, l1, l2);
			} else if (xx - x >= 0 && yy - y < 0) {
				g.drawRect(x, yy, l1, l2);
			} else {
				g.drawRect(x, y, l1, l2);
			}
		}
		repaint();
	}
}

class Myframe extends JFrame {
	public Myframe() {
		super("그림판");
		setLayout(null);
		setBounds(500, 200, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(new Mypanel());
		
		setVisible(true);
		revalidate();
	}
}

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myframe m = new Myframe();
	}
}
