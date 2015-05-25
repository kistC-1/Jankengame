/* 「ジャンケンゲーム」
 * 3回勝負
 * 0…グー / 1…チョキ / 2…パー
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.Random;

public class Jankengame extends Applet {
	
	Image[] compG, frame;
	
	//アプレットの初期化
	public void init() {
		//アプレットの背景色の指定
		setBackground(new Color(255, 255, 255));

		//コンピュータの手
		compG = new Image[4];
		compG[0] = getImage(getDocumentBase(), "../img/gu.png");		//グー
		compG[1] = getImage(getDocumentBase(), "../img/tyoki.png");		//チョキ
		compG[2] = getImage(getDocumentBase(), "../img/pa.png");		//パー
		compG[3] = getImage(getDocumentBase(), "../img/random.gif");	//ランダム
		
		//フレーム(ユーザーの手)
		frame = new Image[4];
		frame[0] = getImage(getDocumentBase(), "../img/");			//グー
		frame[1] = getImage(getDocumentBase(), "../img/");			//チョキ
		frame[2] = getImage(getDocumentBase(), "../img/");			//パー
		frame[3] = getImage(getDocumentBase(), "../img/pa.png");	//ノーマル
	}
	
	
	//画像の描画
	public void paint(Graphics g) {
		Scanner stdIn = new Scanner(System.in);
		Random rand = new Random();
		
		g.drawImage(frame, 0, 0, this);
		g.drawImage(random, 0, -103, this);
		
		int win = 0, rose = 0;
		
		// 3回勝負
		for (int count = 0; count < 3; count++) {
			// コンピュータの手を生成
			int comp = rand.nextInt(3);
			
			// プレイヤーの手を読み込む
			int user;
//			do {
//				user = stdIn.nextInt();
//			} while (user < 0 || user > 2);
//			
			//手を表示
			g.drawImage(compG[comp], 0, -103, this);
//			//g.drawImage(userG[user], 0, 0, this);
//			
			// 判定
//			int judge = (comp - user + 3) % 3;
//			switch (judge) {
//			case 0: break;				//あいこ
//			case 1: win++;		break;	//勝ち
//			case 2: rose++;		break;	//負け
//			}
		}
//		
		// 結果
//		if (win > rose)
//			g.drawString("win",150,140); 
//		else if (win < rose)
//			g.drawString("rose",150,140); 
//		else
//			g.drawString("draw",150,140); 
//		
//		
//		stdIn.close();
	}
}
