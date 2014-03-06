package gocardless;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestUtils {

    public static String readFromRawResourceFile(String filename)
    {
        try {
            InputStream is = TestUtils.class.getResourceAsStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e); // Given we're in TestUtils, it doesn't seem completely unreasonable to do this...
        }
    }
}
