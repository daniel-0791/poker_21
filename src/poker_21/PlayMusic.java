package poker_21;


import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet;
import java.awt.Frame; 
import java.net.MalformedURLException; 
import java.net.URI;
import java.net.URL;
import javax.swing.JFrame;
public class PlayMusic { 

// Music(){
//     bgMusic();
PlayMusic(){  
  try {   
	  File f;
	  URI uri;
	     URL url; 
      f = new File(System.getProperty("user.dir")+"\\music\\music.wav");
      System.out.println(System.getProperty("user.dir")+"\\music\\music.wav");
      uri = f.toURI();
      url = uri.toURL();  //解析地址
      AudioClip music; 
      music = Applet.newAudioClip(url);
      music.play();
     // music.loop();
     // aau.loop();  //循环播放
     
  } catch (Exception e) 
  { e.printStackTrace();
  } 
}

}