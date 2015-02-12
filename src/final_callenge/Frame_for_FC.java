package final_callenge;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Frame_for_FC extends Frame implements ActionListener,WindowListener,KeyListener{

	private Button list = new Button("���X�g�\��");
	private TextArea numlist = new TextArea("",20, 30);
	private Button graph = new Button("�O���t�\��");
	private Label com = new Label("�Q�O�P�T�N�g���^��p�Ԕ̔��䐔");
	
	public Frame_for_FC(Controller_for_FC controller) {
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
		
		//�w�i�F�F���C�g�O���[
		setBackground(Color.lightGray);
		
		//window������
		addWindowListener(this);
		
		//�^�C�g�������߂�(�X�y�[�X�͓ǂݍ��܂Ȃ��j
		setTitle("DB");
		
		//FlowLayout�͕��ׂ����Ƀ��C�A�E�g�ǉ��i����Ȃ����Ƒ傫���{�^���ɂȂ����j
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//�t���[���ɋ󗓂�{�^������z�u
		add(list);		//�i���X�g�\���{�^���j
		add(com);			//(�R�����g)
		add(numlist);	//(���X�g�g�j
		add(graph);	//(�O���t�\���{�^���j
		
		//�{�^���Ɍv�Z�@�\��ǉ�(actionPerformed���Ăяo���j
		list.addActionListener(this);
		graph.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
		if(e.getSource() == list){   //���X�g�{�^���������ꂽ�Ƃ�
			dbconsole();
			
		}else{     //�O���t�̃{�^���������ꂽ�Ƃ�
			bargraph();
			
		}
	}
	
	public void dbconsole(){
		
		int id, num; 
 		String name; 
 		ResultSet rs;
 		
 		MySQL mysql = new MySQL(); 
 		rs = mysql.selectAll();
 		
 		try { 
 			while(rs.next()){ 
 				id = rs.getInt("id"); 
 				name = rs.getString("name"); 
 				num = rs.getInt("num"); 
 				
 				numlist.append("ID: " + id);
 				numlist.append("\n");
 				numlist.append("�Ԗ�: " + name);
 				numlist.append("\n");
 				numlist.append("�̔��䐔: " + num);
 				numlist.append("\n");
 				numlist.append("-------------");
 				numlist.append("\n");
 				
 			} 
 		} catch (SQLException e) { 
			e.printStackTrace(); 
 		}
	}
	
	 public void bargraph(){   //�܂���O���t�쐬
		 
		Graph_for_FC graph = new Graph_for_FC();
			graph.setBounds(5,5,750,500);
			graph.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
	
		//window������
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}
	
}


