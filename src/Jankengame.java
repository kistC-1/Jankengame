/* 「ジャンケンゲーム」
 * 3回勝負
 * 0…グー / 1…チョキ / 2…パー
 */

import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class Jankengame extends Applet {
	
	//アプレットの初期化
	public void init() {
		//アプレットの背景色の指定
		setBackground(new Color(255, 255, 255));
	}
	
	public void paint(Graphics g) {
		//コンピュータの手
		Image Crandom = getImage(getDocumentBase(), "img/random.gif");
		Image Cpaper = getImage(getDocumentBase(), "img/paper.jpg");
		Image Cscissors = getImage(getDocumentBase(), "img/scissors.jpg");
		Image Cstone = getImage(getDocumentBase(), "img/stone.jpg");
		
		//画像の描画
		g.drawImage(Crandom, 20, 10, this);
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Random rand = new Random();
		
		int win = 0, rose = 0;

		// 3回勝負
		for (int count = 0; count < 3; count++) {
			// コンピュータの手を生成
			int comp = rand.nextInt(3);		//scriptに伝える
			
			// プレイヤーの手を読み込む
			int user;
			do {
				user = stdIn.nextInt();			//scriptから読み込むには？
			} while (user < 0 || user > 2);		
			
			// 判定
			int judge = (comp - user + 3) % 3;
			switch (judge) {
			case 0: break;				//あいこ
			case 1: win++;		break;	//勝ち
			case 2: rose++;		break;	//負け
			}
		}
		
		// 結果
		if (win > rose)
			System.out.println("win");
		else if (win < rose)
			System.out.println("rose");
		else
			System.out.println("draw");
		
		stdIn.close();
	}
}
