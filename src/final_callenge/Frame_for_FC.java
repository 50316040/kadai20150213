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

import javax.swing.JFrame;

public class Frame_for_FC extends Frame implements ActionListener,WindowListener,KeyListener{

	private Button list = new Button("リスト表示");
	private Button graph = new Button("グラフ表示");
	private Button cls = new Button("閉じる");
	private TextArea numlist = new TextArea("",20, 30);
	private Label com = new Label("２０１５年トヨタ乗用車販売台数");
	
	public Frame_for_FC(Controller_for_FC controller) {
		// TODO 自動生成されたコンストラクター・スタブ
		
		//背景色：ライトグレー
		setBackground(Color.lightGray);
		
		//windowを閉じれる
		addWindowListener(this);
		
		//タイトルを決める(スペースは読み込まない）
		setTitle("DB");
		
		//FlowLayoutは並べた順にレイアウト追加（これなしだと大きいボタンになった）
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//フレームに空欄やボタン等を配置
		add(list);		//（リスト表示ボタン）
		add(com);		//(コメント)
		add(numlist);	//(リスト枠）
		add(graph);	//(グラフ表示ボタン）
		add(cls);		//(閉じるボタン）
		
		//ボタンに計算機能を追加(actionPerformedを呼び出し）
		list.addActionListener(this);
		graph.addActionListener(this);
		cls.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
		if(e.getSource() == list){   //リストのボタンが押されたとき
			dbconsole();
			
		}else if (e.getSource() == graph){     //グラフのボタンが押されたとき
			bargraph();
			
		}else{		//閉じるのボタンが押されたとき
			//アプリケーション終了
			System.exit(0);
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
 				numlist.append("車名: " + name);
 				numlist.append("\n");
 				numlist.append("販売台数: " + num);
 				numlist.append("\n");
 				numlist.append("-------------");
 				numlist.append("\n");
 				
 			} 
 		} catch (SQLException e) { 
			e.printStackTrace(); 
 		}
	}
	
	 public void bargraph(){   //折れ線グラフ作成
		 
		Graph_for_FC graph = new Graph_for_FC();
			graph.setBounds(5,5,750,500);
			graph.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	
		//windowを閉じれる
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}


