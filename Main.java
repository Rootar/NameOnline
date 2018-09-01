import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        String name = args[0];

        name = name.substring(0, 1).toUpperCase() + name.substring(1);

        URL url = new URL("http://odmiana.net/odmiana-przez-przypadki-imienia-" + name);

        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String content = bufferedReader.readLine();

        Pattern pattern = Pattern.compile("Wołacz.{20,40}([A-Z][a-z]{1,30})!");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find())
        {
            System.out.println(matcher.group(1));
        }
    }
}
