package com.example.currencylist;

public class DisplayedObject {
    protected static final Integer[] imageArray = new Integer[]{
            R.drawable.eur,
            R.drawable.usd,
            R.drawable.gbr,
            R.drawable.aud,
            R.drawable.cad,
            R.drawable.chf,
            R.drawable.dkk,
            R.drawable.huf
    };
    protected static final String[] nameArray = new String[]{
            "EUR", "USD", "GBR", "AUD", "CAD", "CHF", "DKK", "HUF"
    };
    protected static final String[] infoArray = new String[]{
            "Euro", "Dolar american", "Lira sterlina",
            "Dolar australian", "Dolar canadian", "Franc elvetian",
            "Coroana daneza", "Forint maghiar"
    };
    protected static final double[] buyInfoArray = new double[]{
            4.4100, 3.9750, 6.1250, 2.9600, 3.0950, 4.2300, 0.5850, 0.0136
    };
    protected static final double[] sellInfoArray = new double[]{
            4.5500, 4.1450, 6.3550, 3.0600, 3.2650, 4.3300, 0.6150, 0.0146
    };

    public static Integer[] getImageArray() {
        return imageArray;
    }

    public static String[] getNameArray() {
        return nameArray;
    }

    public static String[] getInfoArray() {
        return infoArray;
    }

    public static double[] getBuyInfoArray() {
        return buyInfoArray;
    }

    public static double[] getSellInfoArray() {
        return sellInfoArray;
    }
}
