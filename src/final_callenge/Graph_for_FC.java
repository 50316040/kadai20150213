package final_callenge;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph_for_FC extends Frame implements ActionListener, WindowListener{
	
	private Button cls = new Button("閉じる");
	
	public Graph_for_FC(){
		
		//背景色：ライトグレー
		setBackground(Color.lightGray);
				
		//windowを閉じれる
		addWindowListener(this);
					
		//タイトル設定
		setTitle("グラフ");
		
		//日本語が文字化けしない
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme()); 
		
		//FlowLayoutは並べた順にレイアウト追加
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//グラフ作成
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		
		int num; 
 		String name; 
 		ResultSet rs;
 		
 		MySQL mysql = new MySQL(); 
 		rs = mysql.selectAll();
 		
 		try { 
 			while(rs.next()){  
 				name = rs.getString("name"); 
 				num = rs.getInt("num"); 
 				
 				data.addValue(num,"2015年" ,name);
 			} 
 		} catch (SQLException e) { 
 			// TODO Auto-generated catch block 
			e.printStackTrace(); 
 		}
 		
		JFreeChart chart = ChartFactory.createBarChart("トヨタ乗用車別販売台数",
										"車名",
										"販売台数",
										data,
										PlotOrientation.VERTICAL,
										true,
										false,
										false);
		ChartPanel cpanel = new ChartPanel(chart);
		
		CategoryPlot cPlot = chart.getCategoryPlot();
		/* 横軸の設定 */
		CategoryAxis domainAxis = cPlot.getDomainAxis();
		domainAxis.setCategoryMargin(0.01);
		domainAxis.setLowerMargin(0.01);
		domainAxis.setUpperMargin(0.01);


		
		
		//バーの幅変更
		final CategoryPlot plot = chart.getCategoryPlot();
        final BarRenderer renderer = (BarRenderer)plot.getRenderer();
		renderer.setMaximumBarWidth(0.01);
		
		// グラフの背景色を設定 
		chart.setBackgroundPaint(ChartColor.lightGray); 
		
		//凡例を削除
		chart.removeLegend();
		
		//バーの色を変更
		renderer.setSeriesPaint(0, ChartColor.GREEN);
		
		add(cpanel, BorderLayout.CENTER);
		
		add(cls);
		
		//ボタンに閉じる機能を追加(actionPerformedを呼び出し）
		cls.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
		//グラフフレームのみ閉じる
		Component c = (Component)e.getSource();
		Window w = SwingUtilities.getWindowAncestor(c);
		w.dispose();
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
				
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
		//アプリケーション終了
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

}
