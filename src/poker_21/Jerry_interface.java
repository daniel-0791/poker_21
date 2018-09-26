package poker_21;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.spi.AudioFileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.jar.JarEntry;  
import java.net.*;
public class Jerry_interface {

	private JFrame Jerry;
	static int play_sum=0,boss_sum=0;
	public String winer="  ";
	static ArrayList<String> arr = new ArrayList<String>() ;
	static String str;
	static JPanel panel;
	static JLabel player_poker;
	static JLabel boss_poker;


	public static void main(String[] args) {

			try {

				Jerry_interface window = new Jerry_interface();
				window.Jerry.setVisible(true);
				PlayMusic p=new PlayMusic();

			} catch (Exception e) {
				e.printStackTrace();
			}



	}

	public Jerry_interface() {
		initialize();
	
	}
	
	public void poker()//动态数组图片名
	{	
		
		 for(int i=0;i<52;i++)
		 {	int m=1;
			 if(i<13)
			 { str="黑桃";
			 m+=i;
				 arr.add(str+m);
			 }
			 else if(i>=13&&i<26)
		 	{	m+=i-13;
		 		str="红桃";
				 arr.add(str+m);
		 	}
			 else if(i>=26&&i<39)
		 	{	m+=i-26;
		 		str="梅花";
				 arr.add(str+m);
		 	}
		 
			 else 	if(i>=39&&i<52)
		 	{	m+=i-39;
		 		str="方块";
		 		
				 arr.add(str+m);
		 	}
		 
		 }
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Poker_give init=new Poker_give();
		Winer a=new Winer();
		Jerry = new JFrame();
		Jerry.getContentPane().setForeground(Color.RED);
		Jerry.setTitle("jerry的21点游戏");
		poker();
		
	
		Jerry.setBounds(150, 20, 1500, 999);
		Jerry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Jerry.getContentPane().setLayout(null);
		
		 panel = new JPanel();
		 panel.setBounds(0, 115, 1482, 726);
		panel.setBackground(Color.LIGHT_GRAY);
		Jerry.getContentPane().add(panel,-1);
	
		panel.setLayout(null);
		
		//ImageIcon a=new ImageIcon()
		//
			JLabel  beijing=new JLabel();//背景
			beijing.setBackground(Color.WHITE);
	    beijing.setBounds(0, 0, 1482, 726);
	    beijing.setIcon(new ImageIcon(Jerry_interface.class.getResource("/resources/"+1111+".png")));

		   panel.add(beijing,new Integer(Integer.MIN_VALUE));
	    
	   
	    
	    JButton button = new JButton("重新洗牌");
	    button.setFont(new Font("宋体", Font.PLAIN, 16));
	    button.setBounds(525, 35, 126, 67);
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {

				//System.exit(0);//分数显示归0
				play_sum=0;boss_sum=0;
				Poker_give.Play_shift=0;
				Poker_give.boss_shift=0;




				int paishu=Poker_give.list.size();

				for (int i = 0; i < paishu; i++) {

					Poker_give.list.get(i).setVisible(false);
				}
				player_poker.setText("玩家的点数为：   "+play_sum);
				boss_poker.setText("庄家的点数为：   "+boss_sum);






			}
	    });
	    Jerry.getContentPane().add(button);
	    
	 
	    
	    
	    
		
				 boss_poker = new JLabel("\u5E84\u5BB6\u5F53\u524D\u70B9\u6570\u4E3A\uFF1A");//庄家的
				boss_poker.setBounds(708, 80, 230, 18);
				boss_poker.setFont(new Font("宋体", Font.PLAIN, 20));
				boss_poker.setForeground(Color.LIGHT_GRAY);
				panel.add(boss_poker,0);
		
				 player_poker = new JLabel("\u73A9\u5BB6\u5F53\u524D\u70B9\u6570\u4E3A\uFF1A");
				player_poker.setBounds(708, 600, 230, 18);
				player_poker.setFont(new Font("宋体", Font.PLAIN, 20));
				player_poker.setForeground(Color.LIGHT_GRAY);
				panel.add(player_poker,0);//牌数
				
		
		JButton start = new JButton("叫牌");
		start.setBounds(497, 590, 126, 67);
		start.setVisible(false);
		start.addActionListener(new ActionListener() 
		{
			  
			public void actionPerformed(ActionEvent e) {
				
				
				
				play_sum=init.play_give(play_sum);
			
				player_poker.setText("玩家的点数为：   "+play_sum);
				
				
			}
		});
		panel.add(start,0);
		/*
		 * 玩家名字
		 */
		JLabel player_name = new JLabel("八夭三");
		player_name.setForeground(Color.LIGHT_GRAY);
		player_name.setBounds(736, 657, 136, 27);
		player_name.setFont(new Font("宋体", Font.PLAIN, 35));
		panel.add(player_name,0);
		/*
		 * 庄家名字
		 */
		JLabel boss_name = new JLabel("独立鱼");
		boss_name.setForeground(Color.LIGHT_GRAY);
		boss_name.setBounds(736, 13, 126, 67);
		boss_name.setFont(new Font("宋体", Font.PLAIN, 35));
		panel.add(boss_name,0);
		
		
		
		/* JPanel win = new JPanel();//赢家面板
		    win.setBounds(538, 243, 406, 282);
		    //panel.add(win);
		    Jerry.getContentPane().add(win,0);  
			    win.setVisible(false);*/
		//听牌停止
		JButton stop = new JButton("听牌");//计算赢家并且给庄家牌
		stop.setVisible(false);
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boss_sum=init.boss_give(boss_sum);
				boss_poker.setText("庄家的点数为：   "+boss_sum);
			winer=a.winer(play_sum,boss_sum);
						JLabel winer_name = new JLabel("赢家名字");
						winer_name.setForeground(Color.BLACK);
						winer_name.setHorizontalAlignment(SwingConstants.CENTER);
						winer_name.setFont(new Font("华文楷体", Font.PLAIN, 36));
						winer_name.setBounds(20, 20, 100, 300);
						
						winer_name.setText(winer);
						
						//win.add(winer_name);
						//win.setVisible(true);
						JOptionPane one=new JOptionPane();
						one.setPreferredSize(null);
					
						one.showMessageDialog(winer_name,winer );
						
		
			
			}
		});
		stop.setBounds(962, 590, 126, 67);
		panel.add(stop,0);
		//发牌
		JButton Fapai = new JButton("开始");
		Fapai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				boss_sum=init.boss_give(boss_sum);
				play_sum+=init.play_give(play_sum);
				player_poker.setText("玩家的点数为：   "+play_sum);
				boss_poker.setText("庄家的点数为：   "+boss_sum);
				stop.setVisible(true);
				start.setVisible(true);
			}
		});
		Fapai.setBounds(782, 35, 126, 67);
		Jerry.getContentPane().add(Fapai,0);
		


	}
}
