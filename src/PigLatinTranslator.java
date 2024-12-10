import java.lang.*;

public class PigLatinTranslator {
  
  // Translate a book object (you can add your translation logic for the book here)
  public static Book translate(Book input) {
    Book translatedBook = new Book();
    for(int i =0; i < input.getLineCount();i++){
      String line = translate(input.getLine(i));
      translatedBook.appendLine(line);
    }
    return translatedBook;
  }

  // Translate a full string (sentence or paragraph)
  public static String translate(String input) {
    StringBuilder finalString = new StringBuilder();
    int start = 0;

    // Iterate over each character of the input string
    for (int i = 0; i < input.length(); i++) {
      char currentChar = input.charAt(i);

      // If we reach a delimiter (space, hyphen, or period), translate the word
      if (isDelimiter(currentChar)) {
        String wordToTranslate = input.substring(start, i);
        finalString.append(translateWord(wordToTranslate)).append(currentChar);
        start = i + 1;
      }
    }
    // Translate the last word after the final delimiter
    finalString.append(translateWord(input.substring(start)));
    return finalString.toString();
  }

  // Helper method to check if the character is a delimiter (space, hyphen, or period)
  private static boolean isDelimiter(char ch) {
    return ch == ' ' || ch == '-' || ch == '.';
  }

  // Translate a single word to Pig Latin
  private static String translateWord(String word) {
    if (word.isEmpty()) return word;

    String lowerWord = word.toLowerCase();  // Converting word to lowercase for easier handling
    int vowelIndex = -1;

    // Find the index of the first vowel
    for (int i = 0; i < lowerWord.length(); i++) {
      if ("aeiou".indexOf(lowerWord.charAt(i)) != -1) {
        vowelIndex = i;
        break;
      }
    }

    if (vowelIndex != -1) {
      String translated = word.substring(vowelIndex) + word.substring(0, vowelIndex).toLowerCase() + "ay";
      return capitalizeFirstLetter(translated, word);  // Capitalize if original word started with uppercase
    }
    // If no vowel is found, return the word unchanged
    return word;
  }
  // Capitalizing the first letter if the original word was capitalized
  private static String capitalizeFirstLetter(String translatedWord, String originalWord) {
    if (Character.isUpperCase(originalWord.charAt(0))) {
      return translatedWord.substring(0, 1).toUpperCase() + translatedWord.substring(1);
    }
    return translatedWord;
  }
  public static void main(String[] args) {
    String input = "Hello world! How are you doing?";
    String translated = PigLatinTranslator.translate(input);
    System.out.println("Original: " + input);
    System.out.println("Translated: " + translated);
  }
}
