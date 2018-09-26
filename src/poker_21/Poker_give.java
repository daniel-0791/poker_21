package poker_21;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Poker_give {
	static int    Play_shift, boss_shift;
	static JLabel boss_card1,boss_card2,play_card1;
	public static int poker[]={11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,
			10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10};
	public static ArrayList<Integer> save=new ArrayList<Integer>();
	public static List<JLabel> list=new ArrayList<JLabel>();

	public int play_give(int sum)
	{	
			play_card1 = new JLabel();
			list.add(play_card1);
			play_card1.setBounds(213+ Play_shift , 331, 112, 174);
			Jerry_interface.panel.add(play_card1,0);
		
		int m=(int)(Math.random()*(poker.length));//减掉已生成数
		
		while(save.contains(m))
		{
			m=(int )(Math.random()*poker.length);
		}
		
		 save.add(m);
		   
		   sum+=poker[m];
				
					
					String str=Jerry_interface.arr.get(m);
					
			play_card1.setIcon(new ImageIcon(Jerry_interface.class.getResource("/resources/"+str+".png")));
					
					
			
					
			
			
			
				if((m+1)%13==1&&sum>21)//爆牌减10
				{
					sum-=10;
				}
				Play_shift +=150;
			
		
		
	
		return sum;
	}
	  
	  
	  
	public int boss_give(int sum)
	{	int m=(int)(Math.random()*(poker.length));
			while (save.contains(m))//重复的牌换新的
			{
				m=(int)(Math.random()*(poker.length));
			}
			save.add(m);
			String str=Jerry_interface.arr.get(m);
		
		if(sum==0)
		{	
			
			sum+=poker[m];
		
		boss_card1 = new JLabel();

			list.add(boss_card1);
		
		boss_card1.setBounds(213, 87, 112, 174);
		Jerry_interface.panel.add(boss_card1,0);
		
		boss_card1.setIcon(new ImageIcon(Jerry_interface.class.getResource("/resources/"+str+".png")));
		
		boss_card2 = new JLabel();
		
		 
		
		boss_card2.setBounds(213+ 150, 87, 112, 174);
		Jerry_interface.panel.add(boss_card2,0);
		boss_card2.setIcon(new ImageIcon(Jerry_interface.class.getResource("/resources/"+"隐藏牌1"+".png")));
		
		 
		}
			else
			{
				while(sum<17)//阈值
				{	
			
						boss_card2.setVisible(false);
						sum+=poker[m];
						boss_shift+=150;
						
						boss_card1 = new JLabel();
						list.add(boss_card1);
						
					
						boss_card1.setBounds(213+boss_shift, 87, 112, 174);
						Jerry_interface.panel.add(boss_card1,0);
						boss_card2.setVisible(false);
						boss_card1.setIcon(new ImageIcon(Jerry_interface.class.getResource("/resources/"+str+".png")));
						 
						
						
						if((sum+1)%13==0&&sum>21)//爆牌减10
						{
							sum-=10;
						}
					
						
							m=(int)(Math.random()*(poker.length));
							while (save.contains(m))//重复的牌换新的
							{
								m=(int)(Math.random()*(poker.length));
							}
							save.add(m);
							str=Jerry_interface.arr.get(m);
					
					
				}
		     }
		
	    
      
	
		return sum;
		
	}

}
