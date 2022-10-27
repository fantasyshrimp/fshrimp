
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

        User one = new User("pobi",new Pages(pobi));

        if(!checkNum(pobi) && !checkNum(crong)){
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
    private int page;

    Page(int page){
        this.page = page;
    }

    public int[] getEachDigitOfPage(){
        int n = this.page;
        int digit = (int)Math.log10(n) + 1;
        int[] arrayEachDigits = new int[digit];

        for (int i = 0; i < digit; i++){
            arrayEachDigits[i] = (n % 10);
            n /= 10;
        }
        return arrayEachDigits;
    }


}
class Pages{ //이름을 펼쳐진책?
    Page leftPage;
    Page rightPage;

    public Pages(List<Integer> pages){
        this.leftPage = new Page(pages.get(0));
        this.rightPage = new Page(pages.get(1));
    }
}


class PageGame{
    User userOne;
    User userTwo;

    PageGame(User one, User two){
        this.userOne = one;
        this.userTwo = two;
    }

    public int calculateScore(Pages pages){
        Page leftPage = pages.leftPage;
        Page rightPage = pages.rightPage;

        return 1;
    }
}

class User{
    String userName;
    Pages pages;

    User(String userName, Pages pages){
        this.userName = userName;
        this.pages = pages;
    }

}

class ScoreCalculator{

    public int getScore(Pages pages){
        int Score = 0;

        addEachDigit(pages.leftPage);
        addEachDigit(pages.rightPage);
        multiplyEachDigit(pages.leftPage);
        multiplyEachDigit(pages.rightPage);



        return Score;
    }
    private int addEachDigit(Page page){

        int n = 0;
        for (int a : page.getEachDigitOfPage()){
            n += a;
        }
        return n;
    }

    private int multiplyEachDigit(Page page){

        int n = 1;
        for (int a : page.getEachDigitOfPage()){
            n *= a;
        }
        return n;
    }

}