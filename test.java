import java.io.*;
import java.net.URL;
public class test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the username of the user.");
		String out = br.readLine();
		String url = "https://www.ecs.soton.ac.uk/people/" + out;
        URL myUrl = new URL(url);
        myUrl.openConnection();
        String longStr = "";
        InputStream is = myUrl.openStream();
        byte[] b = new byte[8];
        while(is.read(b) != -1){
        	longStr = longStr + new String(b);
        }
        System.out.println(longStr.substring((longStr.indexOf("property=\"name\"")+ 16), (longStr.indexOf("property=\"honorificSuffix\"") - 4)));
	}
}