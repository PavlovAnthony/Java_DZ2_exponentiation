package DZ2;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class exponentiation {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        {
            Integer a = null;
            Integer b = null;
            Integer rezult;
            String filename = "input.txt";
            File file = FileRead(filename);

           
            try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8)) {

                while (sc.hasNextLine()) {

                    // удалить пробелы в начале и в конце
                    String str = sc.nextLine().trim();
                    // работать только с не пустыми строками
                    if (!str.equals("")) {

                        // определить позицию разделителя
                        int pos = str.indexOf(' ');
                        if (str.charAt(0) == 'a') {
                            a = getNumberInFile(str, pos);
                            
                        }
                        if (str.charAt(0) == 'b') {
                            b = getNumberInFile(str, pos);
                            
                        }
                    }

                }
                
                             

            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }



         //считаем результат
         if (a==0 && b==0){
            System.out.println(" результат не определен a=0 и b=0");  
            System.exit(1);
        }
        
        rezult = pow(a, b);
        //записываем в файл
        OutputData(rezult); 
        
        
        }

    }

    public static File FileRead(String filename) {
        File file = new File(filename);
        // если в файле пусто
        if (file.exists()) {
            if (file.length() == 0) {
                
                System.out.println(" Файл пустой");
                System.exit(1);
            }

        } else {
            System.out.println("файл не найден!!!");
            System.exit(1);
        }
        return file;
    }


// парсим a и b из строк



//вывод результата в файл
    public static void OutputData(int rezult){
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {
                
                writer.write(Integer.toString(rezult));
                
            } 
            catch (IOException ex) {
                
            }  
        }
    // определяем переменные, проверяем на целочисленность
    public static int getNumberInFile(String str, int pos) {

        int a = 0;
        try {
            a = Integer.parseInt(str.substring(pos + 1).trim());

        } catch (NumberFormatException e) {
            System.out.println("ошибка формата входных данных");
            System.exit(1);
        }

        return a;
    }

    public static int pow(int value, int powValue) {
        return (int) Math.pow(value, powValue);
    }
}
