/* �u�W�����P���Q�[���v
 * 3�񏟕�
 * 0�c�O�[ / 1�c�`���L / 2�c�p�[
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
	
	//�A�v���b�g�̏�����
	public void init() {
		//�A�v���b�g�̔w�i�F�̎w��
		setBackground(new Color(255, 255, 255));
		
		//�t���[��
		frame = new Image[3];
		frame[0]  = getImage(getDocumentBase(), "../img/frame_normal.png");	//�ʏ�
		frame[1]  = getImage(getDocumentBase(), "../img/frame_win.png");	//����
		frame[2]  = getImage(getDocumentBase(), "../img/frame_lose.png");	//����
		
		//�R���s���[�^�̎�
		compG = new Image[4];
		compG[0] = getImage(getDocumentBase(), "../img/gu.png");		//�O�[
		compG[1] = getImage(getDocumentBase(), "../img/tyoki.png");		//�`���L
		compG[2] = getImage(getDocumentBase(), "../img/pa.png");		//�p�[
		compG[3] = getImage(getDocumentBase(), "../img/random.gif");	//�����_��
		
		//���[�U�̎�(�{�^��)
		gu  = new Button("�O�[");
		tyoki = new Button("�`���L");
		pa = new Button("�p�[");
		
		//�{�^���̃��C�A�E�g
		setLayout(null);
		add(gu);
		add(tyoki);
		add(pa);
		
		//�{�^���̈ʒu
		gu.setBounds(20,800,60,20);
		tyoki.setBounds(90,800,60,20);
		pa.setBounds(160,800,60,20);
		
		//ActionListener��o�^
		gu.addActionListener(this);
		tyoki.addActionListener(this);
		pa.addActionListener(this);
	}
	
	
	//�摜�̕`��
	public void paint(Graphics g) {
		Random rand = new Random();
		
		// 3�񏟕�
		for (int count = 0; count < 3; count++) {
			g.drawImage(frame[0], 0, 0, this);
			g.drawImage(compG[3], 0, -103, this);
			
			// �v���C���[�̎��ǂݍ���
			
			
			// �R���s���[�^�̎�𐶐�
			comp = rand.nextInt(3);		
			g.drawImage(compG[comp], 0, -103, this);
			
			// ����
//			int judge = (comp - user + 3) % 3;
//			switch (judge) {
//			case 0: break;
//			case 1: win++;		break;
//			case 2: lose++;		break;
//			}
		}
		
		// ����
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


