/* 「ジャンケンゲーム」 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Jankengame extends Applet implements ActionListener {
	Image[] frame, compG;
	Button start, gu, tyoki, pa;
	
	//アプレットの初期化
	public void init() {
		//背景
		setBackground(new Color(255, 255, 255));
		
		//フレーム
		frame = new Image[3];
		frame[0]  = getImage(getDocumentBase(), "../img/frame_normal.png");	//通常
		frame[1]  = getImage(getDocumentBase(), "../img/frame_win.png");	//勝ち
		frame[2]  = getImage(getDocumentBase(), "../img/frame_lose.png");	//負け
		
		//コンピュータの手
		compG = new Image[4];
		compG[0] = getImage(getDocumentBase(), "../img/gu.png");		//グー
		compG[1] = getImage(getDocumentBase(), "../img/pa.png");		//パー
		compG[2] = getImage(getDocumentBase(), "../img/tyoki.png");		//チョキ
		compG[3] = getImage(getDocumentBase(), "../img/random.gif");	//ランダム
		
		//ユーザの手
		setLayout(null);
		start  = new Button("スタート");
		add(start);
		start.setBounds(535, 680, 45, 85);
		start.addActionListener(this);
		
		gu  = new Button("グー");
		add(gu);
		gu.setBounds(90, 780, 60, 30);
		gu.addActionListener(this);
		
		pa = new Button("パー");
		add(pa);
		pa.setBounds(250, 780, 60, 30);
		pa.addActionListener(this);
		
		tyoki = new Button("チョキ");
		add(tyoki);
		tyoki.setBounds(420, 780, 60, 30);
		tyoki.addActionListener(this);
	}
	
	public void paint(Graphics g){
		g.drawImage(frame[0], 0, 0, this);
	  }

	public void actionPerformed(ActionEvent e) {
		Graphics g = getGraphics();
		
		//スタートボタン押下でゲーム開始
		if (e.getSource() == start) {
			
			//ユーザーの手(ランダム)を表示
			g.drawImage(compG[3], 0, -103, this);
			
//			// ユーザーの手を読み込み
//			if(e.getSource() == gu)				result(0);
//			else if(e.getSource() == pa)		result(1);
//			else if(e.getSource() == tyoki)		result(2);
//			else g.drawImage(frame[0], 0, 0, this);	
//		}
//		else g.drawImage(frame[0], 0, 0, this);
	}
	
//	private void result(int user) {
//		Graphics g = getGraphics();
//		
//		// コンピュータの手を生成
//		Random rand = new Random();	
//		int comp = rand.nextInt(3);		
//		g.drawImage(compG[comp], 0, -103, this);
//		
//		// 判定
//		int judge = (comp - user + 3) % 3;
//		switch (judge) {
//		case 0: break;
//		case 1: g.drawImage(frame[1], 0, 0, this);
//				g.drawString("win", 280, 330);
//				break;
//		case 2: g.drawImage(frame[2], 0, 0, this);
//				g.drawString("lose", 280, 330);
//				break;			
//		}
	}
}

