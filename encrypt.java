import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class encrypt {
    public static void main(String[] args) {
        // try-with-resources를 사용하여 자원 자동 해제
        try (FileWriter fw = new FileWriter("C:/CODE/JAVA/secureFile(2).txt")) {
            Scanner sc = new Scanner(System.in);
            String content, secure;
            int shiftValue = 100;  // 문자에 더할 값

            while (true) {
                System.out.print("input: ");
                content = sc.nextLine(); 
                if (content.equals("")) {
                    break;
                }

                secure = ""; 

                // 문자열 변환
                for (int i = 0; i < content.length(); i++) {
                    int ch = (int) content.charAt(i);
                    ch += shiftValue; // 문자 값을 shiftValue만큼 증가
                    secure += (char) ch; // secure에 변환된 문자 추가
                }

                // 암호화된 문자열과 shiftValue를 파일에 작성
                fw.write(secure + " " + shiftValue + "\n");
            }

            sc.close();
            System.out.println("Secure Code Saved");
        } catch (IOException e) {
            System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
        }
    }
}
