package pgm;

public class 프렌즈4블록 {//[PGM_17679]프렌즈4블록 jaehwan solved
    public int solution(int m, int n, String[] board) {//행,열,보드판 블록
        String[][] boards = new String[m][n]; //map
        for(int i=0; i<m; i++) {
            boards[i] = board[i].split("");
        }
        int cnt = 0;//출력할 정답
        while(true) {
            boolean flag = false;
            boolean[][] flagBoards = new boolean[m][n];
            for(int i=0; i<m; i++) { //높이만큼
                for(int j=0; j<n; j++) {//열만큼
                    if(i !=0 && j != 0) {
                        String str = boards[i][j];
                        //주위 4칸이 동일한지 검사
                        if(str.length() > 0 && str.equals(boards[i-1][j-1]) && str.equals(boards[i-1][j]) && str.equals(boards[i][j-1])) {
                            flag = true;
                            flagBoards[i][j] = true; flagBoards[i-1][j-1] = true;
                            flagBoards[i-1][j] = true; flagBoards[i][j-1] = true;
                        }
                    }
                }
            }

            if(!flag) break;//하나도 없을때 탈출

            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(flagBoards[i][j]) {
                        cnt++;//true인거 찾아서 카운트
                        for(int k=i; k>0; k--) {
                            boards[k][j] = boards[k-1][j];//위에꺼로 대체후 삭제
                            boards[k-1][j] = "";
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
/*
1.전체를 돌면서 4칸이 동일한지 검사
2.하나도 없을때 탈출
3.트루체크 및 한칸씩 내림
 */
