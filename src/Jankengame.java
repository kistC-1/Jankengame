/* 「ジャンケンゲーム」 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Jankengame extends Applet implements ActionListener {
	Image FRAME, COMPg;
	Image[] frame, compG;
	Button start, gu, tyoki, pa;
	Graphics g = getGraphics();
	
	//アプレットの初期化
	public void init() {
		//背景
		setBackground(new Color(255, 255, 255));
		
		//フレーム
		FRAME = getImage(getDocumentBase(), "../img/frame_normal.png");		//初期値
		frame = new Image[3];
		frame[0]  = getImage(getDocumentBase(), "../img/frame_normal.png");	//通常
		frame[1]  = getImage(getDocumentBase(), "../img/frame_win.png");	//勝ち
		frame[2]  = getImage(getDocumentBase(), "../img/frame_lose.png");	//負け
		
		//コンピュータの手
		COMPg = getImage(getDocumentBase(), "../img/gu.png");			//初期値
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
	
	//画像の描写
	public void paint(Graphics g){
		g.drawImage(FRAME, 0, 0, this);
		g.drawImage(COMPg, 0, -102, this);
	  }
	
	//結果
		void result(int user) {
			// コンピュータの手を生成
			Random rand = new Random();	
			int comp = rand.nextInt(3);		
			COMPg = compG[comp];
			repaint();
			
			// 判定
			int judge = (comp - user + 3) % 3;
			switch (judge) {
			case 0: break;
			case 1: FRAME = frame[judge];	//勝ち
					repaint();
					break;
			case 2: FRAME = frame[judge];	//負け
					repaint();
					break;			
			}
		}

	//メイン
	public void actionPerformed(ActionEvent e) {
		//スタートボタン押下でゲーム開始
		if (e.getSource() == start) {
			
			//ユーザーの手(ランダム)を表示
			COMPg = compG[3];
			repaint();
			
			// ユーザーの手を読み込み
			if(e.getSource() == gu)				result(0);
			else if(e.getSource() == pa)		result(1);
			else if(e.getSource() == tyoki)		result(2);
//			else {
//				COMPg = compG[3];
//				repaint();
//			}
		}
		else g.drawImage(frame[0], 0, 0, this);
	}
}

