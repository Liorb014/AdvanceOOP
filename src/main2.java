import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\USER\\Downloads\\books.txt");
        List<String> listOfBooks;
        List<Book>books = new ArrayList<>() ;
        listOfBooks= readFromFile(file);
        for (int i = 0; i < listOfBooks.size(); i++) {
            String[] list = listOfBooks.get(i).split(",");
            if (list.length == 5) {
                boolean add ;
            }
        }
    }

    public static List<String> readFromFile(File file)throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader= null;
        FileReader fileReader =null;
        try {
            fileReader = new FileReader(file);
            bufferedReader =new BufferedReader(fileReader);
            String line = null;
            do {
                line = bufferedReader.readLine();
                lines.add(line);
            }while (line != null);
        }finally {
            if (bufferedReader != null)
                bufferedReader.close();
            if (fileReader != null)
                fileReader.close();
        }
        return lines;
    }
}
