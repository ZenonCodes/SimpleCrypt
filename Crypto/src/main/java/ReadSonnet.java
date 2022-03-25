import java.io.*;
import java.util.ArrayList;

public class ReadSonnet {
    public static void main(String[] args){
        ArrayList<String> sonneto = new ArrayList<>();
        ArrayList<String> sonnetoEncrypted = new ArrayList<>();
        ROT13 x = new ROT13('n', 'a');


        try {
                File sonnet = new File("sonnet18.txt");
                FileReader sonnetReader = new FileReader(sonnet);
                BufferedReader reader = new BufferedReader(sonnetReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sonneto.add(line);
                    System.out.println(line);
                }
                reader.close();
            } catch (Exception e) {

                e.printStackTrace();
            }

        try{
            FileWriter sonnetWriter = new FileWriter("sonnet18.enc");
            for (String lyric: sonneto){
                sonnetWriter.write(x.encrypt(lyric) + '\n');
            }
           sonnetWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

