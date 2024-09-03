package macro.Utils;

import macro.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUtils {
    public static  String ReadAllFileAsString(String filePath){
        StringBuilder readResult = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String readedLine;

            while ((readedLine=br.readLine())!=null)
                readResult.append(readedLine+"\n");
        } catch (IOException e) {
            Main.simulation.println(e.getMessage());
        }
        return readResult.toString();
    }
}
