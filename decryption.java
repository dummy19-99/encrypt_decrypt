import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class decryption {
    public static void main(String[] args) {
        // try-with-resources를 사용하여 자원 자동 해제
        try (BufferedReader br = new BufferedReader(new FileReader("C:/CODE/JAVA/secureFile.txt"))) {
            String content, decrypted;

            while ((content = br.readLine()) != null) {
                decrypted = "";

                // 암호화된 문자열을 복호화
                for (int i = 0; i < content.length(); i++) {
                    int ch = (int) content.charAt(i);
                    ch -= 100; // 문자 값을 100 감소
                    decrypted += (char) ch; // 복호화된 문자를 추가
                }

                // 복호화된 내용을 출력
                System.out.println(decrypted);
            }

        } catch (IOException e) { // 예외 처리 추가
            System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
        }
    }
}
