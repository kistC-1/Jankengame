/* �u�W�����P���Q�[���v
 * 3�񏟕�
 * 0�c�O�[ / 1�c�`���L / 2�c�p�[
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.Random;

public class Jankengame extends Applet {
	
	Image random, frame;
	Image[] compG, userG;
	
	//�A�v���b�g�̏�����
	public void init() {
		//�A�v���b�g�̔w�i�F�̎w��
		setBackground(new Color(255, 255, 255));
		
		frame  = getImage(getDocumentBase(), "img/frame.png");		//�t���[��
		random = getImage(getDocumentBase(), "img/random.gif");		//�����_��
		
		//�R���s���[�^�̎�
		compG = new Image[3];
		compG[0] = getImage(getDocumentBase(), "img/gu.png");		//�O�[
		compG[1] = getImage(getDocumentBase(), "img/tyoki.png");	//�`���L
		compG[2] = getImage(getDocumentBase(), "img/pa.png");		//�p�[
		
//		//�t���[��(���[�U�[�̎�)
//		userG = new Image[3];
//		userG[0] = getImage(getDocumentBase(), "img/");		//�O�[
//		userG[1] = getImage(getDocumentBase(), "img/");		//�`���L
//		userG[2] = getImage(getDocumentBase(), "img/");		//�p�[
	}
	
	
	//�摜�̕`��
	public void paint(Graphics g) {
		Scanner stdIn = new Scanner(System.in);
		Random rand = new Random();
		
		g.drawImage(frame, 0, 0, this);
		g.drawImage(random, 0, -103, this);
		
		int win = 0, rose = 0;
		
		// 3�񏟕�
		for (int count = 0; count < 3; count++) {
			// �R���s���[�^�̎�𐶐�
			int comp = rand.nextInt(3);
			
			// �v���C���[�̎��ǂݍ���
			int user;
//			do {
//				user = stdIn.nextInt();
//			} while (user < 0 || user > 2);
//			
			//���\��
			g.drawImage(compG[comp], 0, -103, this);
//			//g.drawImage(userG[user], 0, 0, this);
//			
			// ����
//			int judge = (comp - user + 3) % 3;
//			switch (judge) {
//			case 0: break;				//������
//			case 1: win++;		break;	//����
//			case 2: rose++;		break;	//����
//			}
			
			try{
				  Thread.sleep(500);
				}catch (InterruptedException e){
			}
		}
//		
		// ����
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
