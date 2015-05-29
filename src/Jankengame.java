/* �u�W�����P���Q�[���v */

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
	
	//�A�v���b�g�̏�����
	public void init() {
		//�w�i
		setBackground(new Color(255, 255, 255));
		
		//�t���[��
		FRAME = getImage(getDocumentBase(), "../img/frame_normal.png");		//�����l
		frame = new Image[4];
		frame[0] = getImage(getDocumentBase(), "../img/frame_draw.png");	//������
		frame[1] = getImage(getDocumentBase(), "../img/frame_lose.png");	//����
		frame[2] = getImage(getDocumentBase(), "../img/frame_win.png");		//����
		frame[3] = getImage(getDocumentBase(), "../img/frame_normal.png");	//�ʏ�
		
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
		start.setBounds(525, 680, 55, 85);
		start.addActionListener(this);
		
		gu  = new Button("�O�[");
		add(gu);
		gu.setBounds(90, 780, 60, 30);
		gu.addActionListener(this);
		gu.setEnabled(false);
		
		pa = new Button("�p�[");
		add(pa);
		pa.setBounds(250, 780, 60, 30);
		pa.addActionListener(this);
		pa.setEnabled(false);
		
		tyoki = new Button("�`���L");
		add(tyoki);
		tyoki.setBounds(420, 780, 60, 30);
		tyoki.addActionListener(this);
		tyoki.setEnabled(false);
		
		//����
		jan = getAudioClip(getDocumentBase(), "../se/Janken.wav");	//�W�����P��
		pon = getAudioClip(getDocumentBase(), "../se/pon.wav");	//�|��
	}
	
	//�摜�̕`��
	public void paint(Graphics g){
		g.drawImage(FRAME, 0, 0, this);
		g.drawImage(COMPg, 0, -103, this);
	}
	
	//�摜�̍X�V
	public void update(Graphics g) {
		paint(g);
	}
	
	//����
	void result(int user) {
		pon.play();	//����(�|��)
		
		// �R���s���[�^�̎�𐶐�
		Random rand = new Random();	
		int comp = rand.nextInt(3);
		COMPg = compG[comp];
		repaint();
		
		// ����
		int judge = (comp - user + 3) % 3;
		switch (judge) {
		case 0: FRAME = frame[judge];	//������
				repaint();
				break;
		case 1: FRAME = frame[judge];	//����
				repaint();
				break;
		case 2: FRAME = frame[judge];	//����
				repaint();
				break;			
		}
		
		//���[�U�[�̎�𖳌���
		gu.setEnabled(false);
		pa.setEnabled(false);
		tyoki.setEnabled(false);
	}

	//���C��
	public void actionPerformed(ActionEvent e) {
		//�X�^�[�g�{�^�������ŃQ�[���J�n
		if (e.getSource() == start) {
			FRAME = frame[3];	//�ʏ�
			COMPg = compG[3];	//�����_��
			repaint();
			
			jan.play();	//����(�W�����P��)
			
			//���[�U�[�̎��L����
			gu.setEnabled(true);
			pa.setEnabled(true);
			tyoki.setEnabled(true);
		}
		
			// ���[�U�[�̎��ǂݍ���
		else if (e.getSource() == gu) {			//�O�[
				result(0);
		}
		else if (e.getSource() == pa) {			//�p�[
			result(1);
		}
		else if (e.getSource() == tyoki) {		//�`���L
			result(2);
		}
	}
}

