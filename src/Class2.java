import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Class2 implements Serializable{
    public static void main(String[] args) {
        File file = new File("C:\\Users\\USER\\OneDrive\\שולחן העבודה\\lior\\hi.txt");
        int score =readScore(file);
        Random random =new Random();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("your score is "+score);
            try {
                int n1 = random.nextInt(20);
                int n2 = random.nextInt(20);
                System.out.println(n1+"+"+n2+"= ?");
                int userInput = scanner.nextInt();
                boolean success=userInput==n1+n2;
                if (success){
                    score++;
                }else {
                    score-=3;
                }
                saveScore(file,score);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static int readScore (File file){
        int n =0;
        if (file.exists()&& file!=null){
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String text = bufferedReader.readLine();
                if (text!=null&&text.length()>0){
                    n = Integer.parseInt(text);
                }
                bufferedReader.close();
                fileReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return n;
    }
    public static void  saveScore (File file ,int score){
        if (file!=null&&file.exists()){
            try {
                FileWriter fileWriter= new FileWriter(file);
                fileWriter.write(String.valueOf(score));
                fileWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static boolean solve (){
        boolean result =false;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int n = random.nextInt();
        int sn = random.nextInt();
        int qestion = n+sn;
        System.out.println(n+"+"+sn+"=");
        int answer =scanner.nextInt();
        if (answer == qestion ){
            result = true;
            score++;
        }
        else {
            score =-3;
        }
        createFile("C:\\Users\\USER\\OneDrive\\שולחן העבודה\\lior");
        return result;
    }

    public static  void writeStudentObjectToFile (Class2 class2 , File file){
        try {
            if (file.exists()&& file!=null){
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(class2);
                objectOutputStream.close();
                fileOutputStream.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static  void  writeToFile (File file, String data){
        try {
            if (file != null && file.exists()){
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(data);
                bufferedWriter.close();
                fileWriter.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static  void newFile (File file, String data){
        try {
            if (file != null && file.exists()){
                FileWriter fileWriter  = new FileWriter(file);
                fileWriter.write(data);
                fileWriter.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static File createFile (String path){
        File file = new File(path);
        try {
            boolean success = file.createNewFile();
            if (success){
                System.out.println("success");
            }
            else {
                System.out.println("f");
            }
        } catch (IOException e) {
            System.out.println("couldnt");
            e.printStackTrace();
        }
        return file;
    }
}
