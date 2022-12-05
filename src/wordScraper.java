import java.util.ArrayList;
public class wordScraper {
    private ArrayList<String> words=new ArrayList<String>();
    private ArrayList<Integer> wordCount=new ArrayList<Integer>();
    private int count=0;
    public void addWord(String word){
        if(count>0){
            if(!(containsWord(word))){
                wordCount.add(1);
                words.add(word);
            }
        }
        else{
            words.add(word);
            wordCount.add(1);
            count++;
        }
    }
    //returns a boolean if the word provided is already in the arrayList, if it is, it returns true and adds 1 to its index in wordCount
    private boolean containsWord(String s){
        boolean isInArr=false;
        for(int i=0;i<words.size();i++){
            if(words.get(i).equals(s)){
                isInArr=true;
                wordCount.set(i,wordCount.get(i)+1);
            }
        }
        return isInArr;
    }
    //returns a String array in ordered so that the most commonly used word is returned first
    public String[] wordRanking(){
        String[] ans=new String[words.size()];
        int temp=0;
        String temp2="";
        for(int i=0;i<words.size();i++){
            for(int j=i+1;j<words.size();j++){
                temp=0;
                temp2="";
                if(wordCount.get(i)>wordCount.get(j)){
                    temp=wordCount.get(i);
                    wordCount.set(i,wordCount.get(i));
                    wordCount.set(j,temp);
                    temp2=words.get(i);
                    words.set(i,words.get(i));
                    words.set(j,temp2);
                }
            }
        }
        return ans;
    }
    public ArrayList<String> getWords(){
        return words;
    }
    public ArrayList<Integer> getWordCount(){
        return wordCount;
    }
    public String toString(){
        String ans="";
        for(int i=0;i<words.size();i++){
            ans+=words.get(i)+": "+wordCount.get(i)+",   ";
        }
        return ans;
    }
}
