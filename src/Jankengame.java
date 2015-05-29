/* 「ジャンケンゲーム」 */

import java.applet.Applet;
import java.awt.*;
import java.applet.AudioClip;
import java.awt.event.*;
import java.util.Random;


public class Jankengame extends Applet implements ActionListener {
	Image FRAME, COMPg;
	Image[] frame, compG;
	Button start, gu, tyoki, pa;
	AudioClip jan, pon;
	Graphics g = getGraphics();
	
	//アプレットの初期化
	public void init() {
		//背景
		setBackground(new Color(255, 255, 255));
		
		//フレーム
		FRAME = getImage(getDocumentBase(), "../img/frame_normal.png");		//初期値
		frame = new Image[4];
		frame[0] = getImage(getDocumentBase(), "../img/frame_draw.png");	//あいこ
		frame[1] = getImage(getDocumentBase(), "../img/frame_lose.png");	//負け
		frame[2] = getImage(getDocumentBase(), "../img/frame_win.png");		//勝ち
		frame[3] = getImage(getDocumentBase(), "../img/frame_normal.png");	//通常
		
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
		start.setBounds(525, 680, 55, 85);
		start.addActionListener(this);
		
		gu  = new Button("グー");
		add(gu);
		gu.setBounds(90, 780, 60, 30);
		gu.addActionListener(this);
		gu.setEnabled(false);
		
		pa = new Button("パー");
		add(pa);
		pa.setBounds(250, 780, 60, 30);
		pa.addActionListener(this);
		pa.setEnabled(false);
		
		tyoki = new Button("チョキ");
		add(tyoki);
		tyoki.setBounds(420, 780, 60, 30);
		tyoki.addActionListener(this);
		tyoki.setEnabled(false);
		
		//音声
		jan = getAudioClip(getDocumentBase(), "../se/Janken.wav");	//ジャンケン
		pon = getAudioClip(getDocumentBase(), "../se/pon.wav");	//ポン
	}
	
	//画像の描写
	public void paint(Graphics g){
		g.drawImage(FRAME, 0, 0, this);
		g.drawImage(COMPg, 0, -103, this);
	}
	
	//画像の更新
	public void update(Graphics g) {
		paint(g);
	}
	
	//結果
	void result(int user) {
		pon.play();	//音声(ポン)
		
		// コンピュータの手を生成
		Random rand = new Random();	
		int comp = rand.nextInt(3);
		COMPg = compG[comp];
		repaint();
		
		// 判定
		int judge = (comp - user + 3) % 3;
		switch (judge) {
		case 0: FRAME = frame[judge];	//あいこ
				repaint();
				break;
		case 1: FRAME = frame[judge];	//勝ち
				repaint();
				break;
		case 2: FRAME = frame[judge];	//負け
				repaint();
				break;			
		}
		
		//ユーザーの手を無効化
		gu.setEnabled(false);
		pa.setEnabled(false);
		tyoki.setEnabled(false);
	}

	//メイン
	public void actionPerformed(ActionEvent e) {
		//スタートボタン押下でゲーム開始
		if (e.getSource() == start) {
			FRAME = frame[3];	//通常
			COMPg = compG[3];	//ランダム
			repaint();
			
			jan.play();	//音声(ジャンケン)
			
			//ユーザーの手を有効化
			gu.setEnabled(true);
			pa.setEnabled(true);
			tyoki.setEnabled(true);
		}
		
			// ユーザーの手を読み込み
		else if (e.getSource() == gu) {			//グー
				result(0);
		}
		else if (e.getSource() == pa) {			//パー
			result(1);
		}
		else if (e.getSource() == tyoki) {		//チョキ
			result(2);
		}
	}
}

