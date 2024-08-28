import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class decrypt {
    public static void main(String[] args) {
        // try-with-resources를 사용하여 자원 자동 해제
        try (BufferedReader br = new BufferedReader(new FileReader("C:/CODE/JAVA/secureFile(2).txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                // 저장된 암호화된 문자열과 shiftValue를 분리
                String[] parts = line.split(" ");
                String content = parts[0];
                int shiftValue = Integer.parseInt(parts[1]);
                String decrypted = "";

                // 암호화된 문자열을 복호화
                for (int i = 0; i < content.length(); i++) {
                    int ch = (int) content.charAt(i);
                    ch -= shiftValue; // 문자 값을 shiftValue만큼 감소
                    decrypted += (char) ch; // 복호화된 문자를 추가
                }

                // 복호화된 내용을 출력
                System.out.println(decrypted);
            }

        } catch (IOException e) {
            System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
        }
    }
}
