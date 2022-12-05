import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public String[] splitBySentence(String ans) {
        return ans.split("\\s");
    }
    //this might not work rn
    public String removePunctuation(String ans){
        String[] punctuation={"!",",",".","?",";"};
        for(int i=0;i<punctuation.length;i++){
            if(ans.substring(ans.length()-1,ans.length()).equals(punctuation[i])){
                ans=ans.substring(0,ans.length()-1);
            }
        }
        return ans;
    }
    public String findWords(String ans){
        Main tester=new Main();
        String[] newAns=tester.splitBySentence(ans);
        for(int g=0;g<newAns.length;g++){
            newAns[g]=tester.removePunctuation(newAns[g]);
        }
        wordScraper res=new wordScraper();
        for(int i=0;i<newAns.length;i++){
            res.addWord(newAns[i]);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println("Enter your sentence:");
        Scanner scan =new Scanner(System.in);
        String ans=scan.nextLine();
        Main tester=new Main();
        System.out.println(tester.findWords(ans));
    }
}