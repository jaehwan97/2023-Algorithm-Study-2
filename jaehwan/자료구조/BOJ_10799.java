import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 { //[BOJ_10799]쇠막대기 jaehwan solved - stack 사용
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int ans=0; //정답 출력
        String input = bf.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') { // 열린 괄호면 스택에 추가.
                stack.push('(');
                continue;
            }
            if (input.charAt(i) == ')') { // 닫힌 괄호일 경우 stack에서 pop을 실행.
                stack.pop(); //()는 레이저도 동일하기 때문에 +1이 많은 상태여서 pop부터해도 된다.
                if (input.charAt(i - 1) == '(') { // 그 전 괄호가 열린 괄호면 레이저를 의미.
                    ans += stack.size(); // 현재 stack의 사이즈만큼 더해 줌.
                } else { // 그 전 괄호가 닫힌 괄호면 레이저가 아님.
                    ans++; // 끝이 난 막대기가 있으니 +1
                }
            }
        }
        System.out.println(ans);
    }
}
