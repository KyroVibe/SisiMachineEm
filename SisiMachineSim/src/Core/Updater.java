package Core;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;

public class Updater {
	
	public Socket s;

	public Updater() {
		try {
			s = new Socket("76.105.136.144", 3456);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			out.write("request|version");
			String a = in.readLine();
			
			if (Main.inst.version != a) {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
