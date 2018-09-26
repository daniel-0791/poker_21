package poker_21;

public class Winer{

	public String winer(int play,int boss)
	{	String str = null;
	
		
		if(play>boss&&play<22)
		{
		 str="赢家为玩家,\n";
		 str+="点数为："+play;
		}
		else if(play>21||play<boss)
		{	
			if(boss<22)
			{ str="赢家为庄家,\n";
			str+="点数为"+boss;}
			else if(play<22)
			{	 str="赢家为玩家,\n";
			str+="点数为"+play;
			}
		}
		else if((play>21&&boss>21)||play==boss)
		{
			 str="平局";
		}
		
		return  str;
		
		
		
		
	}
	
	
	

}
