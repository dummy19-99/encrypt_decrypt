import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class encryption {
    public static void main(String[] args) {
        // try-with-resources를 사용하여 자원 자동 해제
        try (FileWriter fw = new FileWriter("C:/CODE/JAVA/secureFile.txt")) {
            Scanner sc = new Scanner(System.in);
            String content, secure;

            while (true) {
                System.out.print("input: ");
                content = sc.nextLine(); // 수정: sc. 제거
                if (content.equals("")) {
                    break;
                }

                // secure 초기화
                secure = ""; 
                
                // 문자열 변환
                for (int i = 0; i < content.length(); i++) {
                    int ch = (int) content.charAt(i);
                    ch += 100; // 문자 값을 100 증가
                    secure += (char) ch; // secure에 변환된 문자 추가
                }
                
                fw.write(secure + "\n"); // 파일에 작성
            }

            sc.close(); // Scanner 자원 해제
            System.out.println("Secure Code Saved");
        } catch (IOException e) { // 예외 처리 추가
            System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
        }
    }
}
