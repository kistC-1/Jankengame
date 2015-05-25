/* 「ジャンケンゲーム」
 * 3回勝負
 * 0…グー / 1…チョキ / 2…パー
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Jankengame extends Applet implements ActionListener {
	Image[] frame, compG;
	Button gu, tyoki, pa;
	int user, comp;
	int win = 0, lose = 0;
	
	//アプレットの初期化
	public void init() {
		//アプレットの背景色の指定
		setBackground(new Color(255, 255, 255));
		
		//フレーム
		frame = new Image[3];
		frame[0]  = getImage(getDocumentBase(), "../img/frame_normal.png");	//通常
		frame[1]  = getImage(getDocumentBase(), "../img/frame_win.png");	//勝ち
		frame[2]  = getImage(getDocumentBase(), "../img/frame_lose.png");	//負け
		
		//コンピュータの手
		compG = new Image[4];
		compG[0] = getImage(getDocumentBase(), "../img/gu.png");		//グー
		compG[1] = getImage(getDocumentBase(), "../img/tyoki.png");		//チョキ
		compG[2] = getImage(getDocumentBase(), "../img/pa.png");		//パー
		compG[3] = getImage(getDocumentBase(), "../img/random.gif");	//ランダム
		
		//ユーザの手(ボタン)
		gu  = new Button("グー");
		tyoki = new Button("チョキ");
		pa = new Button("パー");
		
		//ボタンのレイアウト
		setLayout(null);
		add(gu);
		add(tyoki);
		add(pa);
		
		//ボタンの位置
		gu.setBounds(20,800,60,20);
		tyoki.setBounds(90,800,60,20);
		pa.setBounds(160,800,60,20);
		
		//ActionListenerを登録
		gu.addActionListener(this);
		tyoki.addActionListener(this);
		pa.addActionListener(this);
	}
	
	
	//画像の描画
	public void paint(Graphics g) {
		Random rand = new Random();
		
		// 3回勝負
		for (int count = 0; count < 3; count++) {
			g.drawImage(frame[0], 0, 0, this);
			g.drawImage(compG[3], 0, -103, this);
			
			// プレイヤーの手を読み込む
			
			
			// コンピュータの手を生成
			comp = rand.nextInt(3);		
			g.drawImage(compG[comp], 0, -103, this);
			
			// 判定
//			int judge = (comp - user + 3) % 3;
//			switch (judge) {
//			case 0: break;
//			case 1: win++;		break;
//			case 2: lose++;		break;
//			}
		}
		
		// 結果
//		if (win > lose) {
//			g.drawImage(frame[1], 0, 0, this);
//			g.drawString("win",150,140); 
//		}
//		else if (win < lose) {
//			g.drawImage(frame[2], 0, 0, this);
//			g.drawString("lose",150,140); 
//		}
//		else
//			g.drawString("draw",150,140); 
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == gu)
			user = 0;
		else if(e.getSource() == tyoki)
			user = 1;
		else if(e.getSource() == pa)
			user = 2;			
	}
}


