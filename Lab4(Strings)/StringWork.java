package org.example;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class StringWork {

    private String baseString;
    private final String separatorsString;
    private String[] lexemes;
    private final List<String> floatNumbers;
    private final List<String> dates;

    StringWork(String str, String delim)
    {
        baseString=str;
        separatorsString =delim;
        dates =new ArrayList<>();
        floatNumbers = new ArrayList<>();
        findDate();
        findLexemes();
        findNumbers();
        addNumberBeforeFloat();
        deleteSubstr();
    }

    public String getBaseString()
    {
        return baseString;
    }

    public String getLexemes()
    {
        StringBuilder rez= new StringBuilder();
        for (String lexemes : lexemes) {
            rez.append(' ').append(lexemes);
        }
        return rez.toString().trim();
    }

    public String getDates()
    {
        StringBuilder rez= new StringBuilder();
        for (String time : dates) {
            rez.append(' ').append(time);
        }
        return rez.toString().trim();
    }

    public String getNumbers()
    {
        StringBuilder rez= new StringBuilder();
        for (String s : floatNumbers) {
            rez.append(" ").append(s);
        }
        return rez.toString().trim();
    }

    private void deleteSubstr()
    {
        int k=-1;
        int min=Integer.MAX_VALUE;
        for(int i = 0; i< lexemes.length; i++)
        {
            if(lexemes[i].length()<min && lexemes[i].charAt(0) == '-' && !ifFloat(lexemes[i]))
            {
                min= lexemes[i].length();
                k=i;
            }
        }
        if(k != -1)
            baseString=baseString.replace(lexemes[k], "");
    }

    private void findDate()
    {
        String dateRegex = "(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{2}";
        Matcher timeM=Pattern.compile(dateRegex).matcher(baseString);
        while(timeM.find())
        {
            String timeString=timeM.group();
            if(isDate(timeString))
            {
                dates.add(timeString);
            }
        }
    }

    private boolean isDate(String timeString)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        dateFormat.setLenient(false);
        try
        {
            dateFormat.parse(timeString);
        }
        catch(ParseException pe)
        {
            return false;
        }
        return true;
    }

    private void addNumberBeforeFloat()
    {
        int randNUM= (int) (Math.random() * 100);
        if(!floatNumbers.isEmpty())
        {
            baseString=baseString.replace(floatNumbers.get(0), randNUM+" " +floatNumbers.get(0));
        }
        else
        {
            baseString += " " + randNUM;
        }
    }
    private static boolean ifFloat(String f)
    {
        String floatReg = "[-+]?[0-9]+\\.[0-9]+";
        Matcher numM=Pattern.compile(floatReg).matcher(f);
        return numM.matches();

    }

    private void findLexemes()
    {
        StringTokenizer tokenizer = new StringTokenizer(baseString, separatorsString);
        lexemes = new String[tokenizer.countTokens()];
        for(int i = 0; i< lexemes.length; i++)
        {
            lexemes[i]=tokenizer.nextToken();
        }
    }

    private void findNumbers()
    {
        String floatReg = "[-+]?[0-9]+\\.[0-9]+";
        Matcher numM=Pattern.compile(floatReg).matcher(baseString);
        while(numM.find())
        {
            floatNumbers.add(numM.group());
        }
    }
}
