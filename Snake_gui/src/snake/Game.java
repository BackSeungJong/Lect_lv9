package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

class Panel extends MyUtil {

	private Rect[][] map;

	private int dir = 3;
	private int size;
	private Rect[] snake;

	private JButton[] key = new JButton[4];
	private JButton reset;

	private int count = 0;

	public Panel() {
		setLayout(null);
		setBounds(0, 0, 1000, 800);
		setBackground(new Color(223, 216, 202));

		key();
		map();
		snake();
		setFocusable(true);
		addKeyListener(this);
	}

	private void key() {

		String[] text = { "←", "↓", "→", "↑" };

		// 방향키
		int x = 1000 - 250;
		int y = 800 - 300;
		for (int i = 0; i < key.length; i++) {
			key[i] = new JButton();
			key[i].setBounds(x, y, 50, 50);
//			key[i].addKeyListener(this);
			key[i].setText(text[i]);
			add(key[i]);

			x += 50;
			if (i == key.length - 1 - 1) {
				y -= 50;
				x = 1000 - 250 + 50;
			}
		}

		// 리셋 버튼
		reset = new JButton();
		reset.setBounds(1000 - 250, 800 - 225 - 10, 150, 35);
		reset.setText("RESET");
		reset.addMouseListener(this);
		add(reset);
	}

	private void map() {
		int size = 30;
		int x = 50;
		int y = 50;

		map = new Rect[20][20];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Rect(x, y, size, size);
				x += size;
			}
			x = 50;
			y += size;
		}
	}

	private void snake() {
		size = 4;
		snake = new Rect[4];
		for (int i = 0; i < size; i++) {
			snake[i] = new Rect(map[10][i + 5].getX(), map[10][i + 5].getY(), map[10][i + 5].getWidth(),
					map[10][i + 5].getHeight());
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		update();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				g.drawRect(map[i][j].getX(), map[i][j].getY(), map[i][j].getWidth(), map[i][j].getHeight());
			}
		}
//		if (count == 3) {
//			Rect rec = item();
//			count = 0;
//
//			g.setColor(new Color(18, 92, 19));
//			g.fillRect(rec.getX(), rec.getY(), rec.getWidth(), rec.getHeight());
//		}
		for (int i = 0; i < snake.length; i++) {
			if (i == snake.length - 1) {
				g.setColor(new Color(73, 255, 0));
				g.fillRect(snake[i].getX(), snake[i].getY(), snake[i].getWidth(), snake[i].getHeight());
			} else {
				g.setColor(new Color(62, 124, 23));
				g.fillRect(snake[i].getX(), snake[i].getY(), snake[i].getWidth(), snake[i].getHeight());
			}
		}
		repaint();

		try {
			Thread.sleep(700);
			count++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Rect item() {
		// TODO Auto-generated method stub
		Random ran = new Random();

		int x = 0;
		int y = 0;
		while (true) {
			boolean check = true;
			x = ran.nextInt(map.length);
			y = ran.nextInt(map.length);

			for (int i = 0; i < snake.length; i++) {
				if (map[x][y].getX() == snake[i].getX() && map[x][y].getY() == snake[i].getY()) {
					check = false;
				}
			}
			if (check) {
				break;
			}
		}

		return map[x][y];
	}

	// snake의 좌표를 갱신
	private void update() {
		// 좌
		if (dir == 1) {
//			System.out.println(snake[size - 1].getX() - 30);
//			System.out.println(map[0][0].getX() - 30);
			if (snake[size - 1].getX() - 30 > map[0][0].getX() - 30) {
				System.out.println("←");
				for (int i = 0; i < snake.length - 1; i++) {
					snake[i].setX(snake[i + 1].getX());
					snake[i].setY(snake[i + 1].getY());
				}
				snake[size - 1].setX(snake[size - 1].getX() - 30);
			} else {
				System.out.println("죽음");
			}
		}
		// 하
		else if (dir == 2) {
//			System.out.println(snake[size - 1].getY() + 30);
//			System.out.println(map[19][19].getY() + 30);
			if (snake[size - 1].getY() + 30 < map[19][19].getY() + 30) {
				System.out.println("↓");
				for (int i = 0; i < snake.length - 1; i++) {
					snake[i].setX(snake[i + 1].getX());
					snake[i].setY(snake[i + 1].getY());
				}
				snake[size - 1].setY(snake[size - 1].getY() + 30);
			} else {
				System.out.println("죽음");
			}
		}
		// 우
		else if (dir == 3) {
//			System.out.println(snake[size - 1].getX() + 30);
//			System.out.println(map[19][19].getX() + 30);
			if (snake[size - 1].getX() + 30 < map[19][19].getX() + 30) {
				System.out.println("→");
				for (int i = 0; i < snake.length - 1; i++) {
					snake[i].setX(snake[i + 1].getX());
					snake[i].setY(snake[i + 1].getY());
				}
				snake[size - 1].setX(snake[size - 1].getX() + 30);
			} else {
				System.out.println("죽음");
			}
		}
		// 상
		else if (dir == 4) {
//			System.out.println(snake[size - 1].getY() - 30);
//			System.out.println(map[0][0].getY());
			if (snake[size - 1].getY() - 30 > map[0][0].getY() - 30) {
				System.out.println("↑");
				for (int i = 0; i < snake.length - 1; i++) {
					snake[i].setX(snake[i + 1].getX());
					snake[i].setY(snake[i + 1].getY());
				}
				snake[size - 1].setY(snake[size - 1].getY() - 30);
			} else {
				System.out.println("죽음");
			}
		}
//		System.out.println("move");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 좌
		if (dir != 3 && e.getKeyCode() == e.VK_LEFT) {
			System.out.println("left");
			this.dir = 1;
		}
		// 하
		if (dir != 4 && e.getKeyCode() == e.VK_DOWN) {
			System.out.println("down");
			this.dir = 2;
		}
		// 우
		if (dir != 1 && e.getKeyCode() == e.VK_RIGHT) {
			System.out.println("right");
			this.dir = 3;
		}
		// 상
		if (dir != 2 && e.getKeyCode() == e.VK_UP) {
			System.out.println("up");
			this.dir = 4;
		}
		if (e.getKeyCode() == e.VK_ENTER) {
			System.out.println("리셋");
		}
	}
}

public class Game extends JFrame {
	public Game() {
		super("Snake Game");
		setLayout(null);
		setBounds(300, 100, 1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(new Panel());

		setVisible(true);
		revalidate();
	}
}
