package wyzwanie.tddkata.delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetDelimiterDefaultImpl implements GetDelimiter {

    private final String prefix = "//\\[";
    private final String valueOfInterest = ".*";
    private final String suffix = "\\]\n";
    @SuppressWarnings("FieldCanBeLocal")
    private final String regex = prefix + valueOfInterest + suffix;

    @Override
    public String getDelimiterFromInput(final String input) {
        String delimiter = ",";

        if (input != null && input.length() > 0) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                delimiter = matcher.group();
                delimiter = delimiter.replaceFirst(prefix, "");
                delimiter = delimiter.replaceFirst(suffix, "");
            }
        }

        return delimiter;
    }

}
