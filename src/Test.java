

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


public class Test {

	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	
	public static void main(String[] args) {
		System.out.println("main is't main now");
	}
	
	
	public static void main97(String[] args) throws Exception {
		
		BufferedReader fileIn = new BufferedReader(new FileReader("d:\\tmp\\infile.txt"));
        PrintWriter pw = new PrintWriter("d:\\tmp\\outfile.txt");

		int c;
		while ((c = fileIn.read()) != -1) {
		    if(c!=59) {
		       pw.print((char)c);
		    } else {
		       pw.println();
		    }
		}
		
		pw.flush();
		pw.close();

		
	}
	
	
	public static void main96(String[] args) throws Exception {
		URL url = new URL("http://www.google.com");
        URLConnection conn = url.openConnection();
        
        //conn.setDoOutput(true);
        //OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        //wr.flush();

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("station.txt")));

        String line;
        while((line=rd.readLine())!=null)
        {
            out.write(line);
        }
        out.close();

        System.out.println("success");
	}
	
	
	public static void main95(String[] args) throws Exception {
		URL url = new URL("http://www.google.com");
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		InputStream inputStream = conn.getInputStream();
		
		String response = IOUtils.toString(inputStream);
		
		System.out.println("response = " + response);
	}
	
	
	public static void main94(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		String k = map.get("k");
		System.out.println("k = " + k);
		
		map.put("k", null);
		
		k = map.get("k");
		System.out.println("k = " + k);
	}
	
	
	public static void main93(String[] args) {
		Calendar cal = Calendar.getInstance();   
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");   
			cal.add(Calendar.DATE, -1);
		   	String strDate=dateFormat.format(cal.getTime());
	 	System.out.println( "strDate " + strDate );
	}
	
	
	public static Robot robot;// = new Robot();
	
	public static void main92(String[] args) throws Exception {
		
		robot = new Robot();
		
		Thread.sleep(5000);
		
		//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		//robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		int timeToPickNextBall = 730; // Fully Optimized
		
		
		int time = 285; // Round 1 // Fully Optimized
		goal(time); //1
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time); //5
		
		
		time = 500; // Round 2
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		
		
		/*
		time = 680; // Round 3
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		*/
		
		/*
		time = 850; // Round 4
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		*/
		
		/*
		time = 1000; // Round 5
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		Thread.sleep(timeToPickNextBall);
		goal(time);
		*/
		
		
		
	}
	
	private static void goal(int t) throws Exception{
		robot.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(t);
		robot.keyRelease(KeyEvent.VK_SPACE);
	}
	
	
	
	public static void main91(String[] args) throws Exception {
		Robot robot = new Robot();
		
		Thread.sleep(5000);
		
		//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		//robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		robot.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(500);
		
		for (int i=0; i<700; i++) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyPress(KeyEvent.VK_LEFT);
		}
		
		
		
	}

	
	public static void main90(String[] args) {
		 java.net.InetAddress[] is;
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			// this code assumes IPv4 is used
			byte[] ip = {10,10,1,0};
	 
			
			
			for (int i = 30; i <= 34; i++) {
				ip[3] = (byte)i;
				InetAddress address = InetAddress.getByAddress(ip);
				System.out.println(address.getHostName());
				/*
				if (address.isReachable(200)) {
					System.out.println(address + " machine is turned on and can be pinged");
				} else if (!address.getHostAddress().equals(address.getHostName())) {
					System.out.println(address + " machine is known in a DNS lookup");
				} else {
					System.out.println(address + " the host address and host name are equal, meaning the host name could not be resolved");
				}*/
			}
	 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
        }
 

	
	
	public static void main89(String[] args) {
		StringBuffer sb = new StringBuffer("AA");
		
		String a = null;
		sb.append(a);
		
		sb.append("ZZ");
		
		System.out.println(sb.toString());
	}
	
	
	public static void main2(String[] args) {
		int isaCounter = 1;
		String ISA13 = StringUtils.leftPad(""+isaCounter, 9, "0");
		System.out.println(ISA13);
	}
	
	
	public static void main1(String[] args) {
		
		System.out.println(new Test().toString());
		
		Long l = NumberUtils.createLong(null);
		
		//Long l = Long.valueOf(null);
		System.out.println(l);
	}
	
}
