/* �u�W�����P���Q�[���v */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Jankengame extends Applet implements ActionListener {
	Image FRAME, COMPg;
	Image[] frame, compG;
	Button start, gu, tyoki, pa;
	Graphics g = getGraphics();
	
	//�A�v���b�g�̏�����
	public void init() {
		//�w�i
		setBackground(new Color(255, 255, 255));
		
		//�t���[��
		FRAME = getImage(getDocumentBase(), "../img/frame_normal.png");		//�����l
		frame = new Image[3];
		frame[0]  = getImage(getDocumentBase(), "../img/frame_normal.png");	//�ʏ�
		frame[1]  = getImage(getDocumentBase(), "../img/frame_win.png");	//����
		frame[2]  = getImage(getDocumentBase(), "../img/frame_lose.png");	//����
		
		//�R���s���[�^�̎�
		COMPg = getImage(getDocumentBase(), "../img/gu.png");			//�����l
		compG = new Image[4];
		compG[0] = getImage(getDocumentBase(), "../img/gu.png");		//�O�[
		compG[1] = getImage(getDocumentBase(), "../img/pa.png");		//�p�[
		compG[2] = getImage(getDocumentBase(), "../img/tyoki.png");		//�`���L
		compG[3] = getImage(getDocumentBase(), "../img/random.gif");	//�����_��
		
		
		//���[�U�̎�
		setLayout(null);
		start  = new Button("�X�^�[�g");
		add(start);
		start.setBounds(535, 680, 45, 85);
		start.addActionListener(this);
		
		gu  = new Button("�O�[");
		add(gu);
		gu.setBounds(90, 780, 60, 30);
		gu.addActionListener(this);
		
		pa = new Button("�p�[");
		add(pa);
		pa.setBounds(250, 780, 60, 30);
		pa.addActionListener(this);
		
		tyoki = new Button("�`���L");
		add(tyoki);
		tyoki.setBounds(420, 780, 60, 30);
		tyoki.addActionListener(this);
	}
	
	//�摜�̕`��
	public void paint(Graphics g){
		g.drawImage(FRAME, 0, 0, this);
		g.drawImage(COMPg, 0, -102, this);
	  }
	
	//����
		void result(int user) {
			// �R���s���[�^�̎�𐶐�
			Random rand = new Random();	
			int comp = rand.nextInt(3);		
			COMPg = compG[comp];
			repaint();
			
			// ����
			int judge = (comp - user + 3) % 3;
			switch (judge) {
			case 0: break;
			case 1: FRAME = frame[judge];	//����
					repaint();
					break;
			case 2: FRAME = frame[judge];	//����
					repaint();
					break;			
			}
		}

	//���C��
	public void actionPerformed(ActionEvent e) {
		//�X�^�[�g�{�^�������ŃQ�[���J�n
		if (e.getSource() == start) {
			
			//���[�U�[�̎�(�����_��)��\��
			COMPg = compG[3];
			repaint();
			
			// ���[�U�[�̎��ǂݍ���
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

