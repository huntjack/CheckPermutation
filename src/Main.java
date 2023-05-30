import java.util.*;

public class Main {
    public static void main(String[] args) {
        String base = "Mississippi State";
        String permutation = "MeitsastiSs siipp";
        String notPermutation = "MeitsastiSs ssipp";
        System.out.println("Should be true: " + isPermutation(base, permutation));
        System.out.println("Should be false: " + isPermutation(base, notPermutation));
    }
    public static Boolean isPermutation(String base, String candidate) {
        if(base.length() != candidate.length()) {
            return false;
        }
        Map<Character, Integer> baseCharacters = new HashMap<>();
        Map<Character, Integer> candidateCharacters = new HashMap<>();
        addAllCharacters(
                base,
                candidate,
                baseCharacters,
                candidateCharacters);
        for(Map.Entry<Character, Integer> entry : candidateCharacters.entrySet()) {
            Character entryKey = entry.getKey();
            Integer entryValue = entry.getValue();
            if(!baseCharacters.containsKey(entryKey)) {
                return false;
            }
            Integer baseValue = baseCharacters.get(entryKey);
            if(!baseValue.equals(entryValue)) {
                return false;
            }
        }
        return true;
    }
    private static void addAllCharacters(String base,
                                         String candidate,
                                         Map<Character, Integer> baseCharacters,
                                         Map<Character, Integer> candidateCharacters) {
        for(int i = 0; i < base.length(); i++) {
            char baseCharacter = base.charAt(i);
            addCharacter(baseCharacter, baseCharacters);
            char candidateCharacter = candidate.charAt(i);
            addCharacter(candidateCharacter, candidateCharacters);
        }
    }
    private static void addCharacter(char character, Map<Character, Integer> characterMap) {
        int count = 0;
        if(characterMap.containsKey(character)) {
            count = characterMap.get(character);
        }
        characterMap.put(character, ++count);
    }
}