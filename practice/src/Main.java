
import java.util.ArrayList;
import java.util.List;

//자릿수 영어로 digit
public class Main {
    public static void main(String[] args){

        Problem1 a = new Problem1();

        List<Integer> pobi = new ArrayList<Integer>();
        pobi.add(129);
        pobi.add(130);

        System.out.println(Problem1.solution(pobi, pobi));

    }
}

class Problem1{
    public  static  int solution(List<Integer> pobi, List<Integer> crong){
        int answer = Integer.MAX_VALUE;


        if(!checkNum(pobi)){
            return -1;
        }
        if(!checkNum(crong)){
            return -1;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        int dst = pobiScore - crongScore;

        if (dst > 0){
            return 1;
        }
        if (dst < 0){
            return 2;
        }
        answer = dst;
        return answer;
    }


    private static boolean checkNum(List<Integer> src){
        int left = src.get(0);
        int right = src.get(1);

        if ((left % 2) != 1){
            return false;
        }
        if ((right - left) != 1){
            return false;
        }

        return true;
    }
    private static int getScore(List<Integer> pageList){

        int[] Scores = new int[4];

        Scores[0] = sumPartOfDigit(pageList.get(0));
        Scores[1] = sumPartOfDigit(pageList.get(1));
        Scores[2] = mulPartOfDigit(pageList.get(0));
        Scores[3] = mulPartOfDigit(pageList.get(1));

        int biggestScore = 0;
        for (int score : Scores){ //이렇게하면 들여쓰기 두번인데?
            if (biggestScore < score){
                biggestScore = score;
            }
        }
        return biggestScore;
    }

    private static int[] getNumberOfDigit(int number){
        int n = number;
        int digit = (int)Math.log10(n) + 1;
        int[] arrayPartOfDigit = new int[digit];

        for (int i = 0; i < digit; i++){
            arrayPartOfDigit[i] = (n % 10);
            n /= 10;
        }
        return arrayPartOfDigit;
    }

    private static int sumPartOfDigit(int number){
        int dst = 0;
        for (int a : getNumberOfDigit(number)){
            dst += a;
        }
        return dst;
    }

    private static int mulPartOfDigit(int number){
        int dst = 1;
        for (int a : getNumberOfDigit(number)){
            dst *= a;
        }
        return dst;
    }

}

class Page{
    private int pageNumber;

    public Page(int pageNumber){
        this.pageNumber = pageNumber;
    }
}

class Pages{
    private List<Page> pages;

    public Pages(List<Page> pages){
        this.pages = pages;
    }
}

class Game{

    public int calculateScore(){
        return 1;
    }

    private int[] divideDigit(int num){

        return null;
    }

}

class User{
    String userName;
    Pages pages;

}