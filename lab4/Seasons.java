package ru.mirea.lab4;

public class Seasons {
    enum Season {
        WINTER(-10.5),
        SPRING(10.3),
        SUMMER(20.2),
        AUTUMN(8.8);
        private final double temperature;

        Season(double temperature) {
            this.temperature = temperature;
        }

        public double getTemperature() {
            return temperature;
        }

        public String getDescription() {
            if (this.equals(SUMMER)) {
                return "Тёплое время года";
            } else {
                return "Холодное время года";
            }
        }
    }

    public static String getILoveThatSeason(Season season) {
        switch (season) {
            case WINTER -> {
                return "Я люблю зиму";
            }
            case SPRING -> {
                return "Я люблю весну";
            }
            case SUMMER -> {
                return "Я люблю лето";
            }
            case AUTUMN -> {
                return "Я люблю осень";
            }
            default -> {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Season mySeason = Season.AUTUMN;
        System.out.println(mySeason);
        System.out.println(getILoveThatSeason(mySeason));
        System.out.println(mySeason.getDescription());
        for (Season season : Season.values()) {
            System.out.printf("%s; Temperature: %.1f; %s\n", season, season.getTemperature(), season.getDescription());
        }
    }
}
