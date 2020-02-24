package wyzwanie.tddkata;

public class InputChecker {

  public boolean hasNumbersOnly(String input) {

    if (input.length() == 1) {
      return input.matches("[0-9]");
    }

    String[] inputArr = replaceSeparatorsWithComma(input);

    for (String item : inputArr) {
      if (!item.matches("[0-9]")) {
        return false;
      }
    }
    return true;
  }

  public String[] replaceSeparatorsWithComma(String input) throws NumberFormatException {

    input = input.replaceAll(" ", "");

    if (input.contains("\n,")) {
      input = input.replace("\n,", ",");
    }
    if (input.contains("\n")) {
      input = input.replace("\n", ",");
    }
    if (input.contains(";")) {
      input = input.replace(";", ",");
    }
    if (input.contains(":")) {
      input = input.replace(":", ",");
    }

    return input.split(",");
  }

}
