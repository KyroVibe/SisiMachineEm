package Core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

public class Updater implements Runnable {
	
	public Socket s;
	
	public Thread thread;
	
	public String newVersion;

	public Updater() {
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		try {
			s = new Socket("76.105.136.144", 3456);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			out.write("request|version");
			String a = in.readLine();
			
			newVersion = a;
			
			if (Main.inst.version != a) {
				new UpdateWindow();
			}
			
		} catch (Exception e) {
			Main.inst.print("Couldn't connect to server");
		}
	}
	
	public void UpdateApplication() {
		try {
			downloadUsingStream("https://github.com/KyroVibe/SisiMachineEm/tree/master/SisiMachineSim/builds/n30s Machine Emulator v" + newVersion + ".jar", "C:\\Users\\Public\\n30s Machine Emulator v" + newVersion + ".jar");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
	
}
