public class WordMatch {
    String secretStr;

    public WordMatch(String secretStr){
        this.secretStr = secretStr;
    }

    public int scoreGuess(String guess){
        if(guess.isEmpty()){
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if(guess.length() > secretStr.length()){
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }

        int score = 0;
        int occurrences = 0;

        if(secretStr.contains(guess)){
            int i = 0;
            while(i+guess.length() < secretStr.length()+1){
                if(secretStr.substring(i,i+guess.length()).contains(guess)){
                    occurrences++;
                }
                i++;
            }

            score = guess.length()*guess.length()*occurrences;
        }
        return score;
    }

    public String findBetterGuess(String guess1, String guess2){
        int guess1result = scoreGuess(guess1);
        int guess2result = scoreGuess(guess2);

        if(guess1result >= guess2result){
            return guess1;
        }

        return guess2;
    }
}
