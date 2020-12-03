package kg.geektech.les8.game;

import kg.geektech.les8.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(700, 50);
        Warrior warrior = new Warrior(270, 20);
        Magic magic = new Magic(230, 15);
        Medic doctor = new Medic(220, 5, 15);
        Berserk berserk = new Berserk(260, 10);
        Medic assistant = new Medic(280, 10, 5);
        Thor thor = new Thor(240,18);
        Tank tank = new Tank(300,5);
        Hero[] heroes = {warrior, magic, doctor, berserk, assistant,thor, tank};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        heroesHit(boss, heroes);
        bossHits(boss, heroes);
        applySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void applySuperAbilities(Boss boss, Hero[] heroes){
        for (int i = 0; i <heroes.length ; i++) {
            if(heroes[i].getHealth() > 0){
            heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {

            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("______________");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() +
                    " health: " + heroes[i].getHealth() + " [" +
                    heroes[i].getDamage() + "]");
        }
        System.out.println("______________");
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }

        return allHeroesDead;
    }
}
