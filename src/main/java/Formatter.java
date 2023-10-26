package src.main.java;

class Formatter{
    public static String formatRuble(double value) {
        String formatted = String.format("%.2f", value);
        int rubles = (int)Math.floor(value);
        String ruble = getRuble(rubles);
        return formatted + " " + ruble;
    }
    public static String getRuble(int rubles){
        if (rubles % 10 == 1 && rubles % 100 != 11){
            return " рубль";
        }
        else if (rubles % 10 >= 2 && rubles % 10 <= 4 && (rubles % 100 < 10 || rubles % 100 >= 20)){
            return " рубля";
        }else {
            return " рублей";
        }
    }
}