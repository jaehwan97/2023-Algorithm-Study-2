package pgm;

class 두개이하로다른비트 {//[PGM_77885]두개이하로다른비트 jaehwan solved
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            if(num % 2 == 0){//짝수면 +1인 값
                answer[i] = num + 1;
            }
            else{//홀수면
                String numTo2 = Long.toBinaryString(num);
                if(numTo2.contains("0")){
                    int idx = numTo2.lastIndexOf("0"); //제일 뒤에 있는 0을 찾아서
                    //기존 문자열 numTo2에서 idx 위치의 문자와 그 다음 문자를 "10"으로 대체
                    numTo2 = numTo2.substring(0, idx) + "10" + numTo2.substring(idx + 2);
                }
                else{
                    numTo2 = "10" + numTo2.substring(1);
                }
                answer[i] = Long.parseLong(numTo2, 2);//값 저장은 10진수로
            }
        }
        return answer;
    }
}
//https://velog.io/@hysung714/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-2%EA%B0%9C-%EC%9D%B4%ED%95%98%EB%A1%9C-%EB%8B%A4%EB%A5%B8-%EB%B9%84%ED%8A%B8-Java-%EC%9E%90%EB%B0%94
