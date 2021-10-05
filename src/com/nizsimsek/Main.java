package com.nizsimsek;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Taş Kağıt Makas oyununa hoş geldiniz.");
        int raunt = setRaunt(), userScore = 0, computerScore = 0;
        int rauntForFinish = raunt;
        while (raunt > 0) {
            System.out.println("\nLütfen tercihinizi seçiniz.. \nTaşı seçmek için 1'e basınız.." +
                    "\nKağıdı seçmek için 2'ye basınız..\nMakası seçmek için 3'e basınız.. ");
            String userChoose = setUserChoose(), computerChoose = setComputerChoose();
            if (userChoose != null) {
                String rauntWinner = setRauntWinner(userChoose, computerChoose);
                if (rauntWinner.equals("userWin")) {
                    userScore += 1;
                } else if (rauntWinner.equals("computerWin")) {
                    computerScore += 1;
                }
                raunt--;
            }
        }
        setGameWinner(userScore, computerScore, rauntForFinish);
    }

    public static int setRaunt() {
        System.out.println("Oyunu kaç tur olarak oynamak istersiniz ?");
        int raunt = sc.nextInt();
        System.out.printf("Oyun %d tur oynanacak şekilde ayarlandı.", raunt);
        return raunt;
    }

    public static String setUserChoose() {
        int selectedNumber = sc.nextInt();
        String selectedItem = null;

        switch (selectedNumber) {
            case 1:
                selectedItem = "Taş";
                break;
            case 2:
                selectedItem = "Kağıt";
                break;
            case 3:
                selectedItem = "Makas";
                break;
            default:
                System.out.println("Hatalı sayıyı seçtiniz lütfen sayıyı tekrar giriniz..");
                break;
        }
        return selectedItem;
    }

    public static String setComputerChoose() {
        Random random = new Random();
        int computerNumber = random.nextInt(3) + 1;
        String computerItem = null;
        switch (computerNumber) {
            case 1:
                computerItem = "Taş";
                break;
            case 2:
                computerItem = "Kağıt";
                break;
            case 3:
                computerItem = "Makas";
                break;
        }
        return computerItem;
    }

    public static String setRauntWinner(String userItem, String computerItem) {
        if (userItem.equals("Makas") && computerItem.equals("Kağıt")) {
            System.out.printf("Sen %s seçerek bilgisayarın tercihi olan %s 'i keserek hanene 1 puan yazdırdın.\n",
                    userItem, computerItem);
            return "userWin";
        } else if (userItem.equals("Taş") && computerItem.equals("Makas")) {
            System.out.printf("Sen %s seçerek bilgisayarın tercihi olan %s 'i kırarak hanene 1 puan yazdırdın.\n",
                    userItem, computerItem);
            return "userWin";
        } else if (userItem.equals("Kağıt") && computerItem.equals("Taş")) {
            System.out.printf("Sen %s seçerek bilgisayarın tercihi olan %s 'i sararak hanene 1 puan yazdırdın.\n",
                    userItem, computerItem);
            return "userWin";
        } else if (userItem.equals("Taş") && computerItem.equals("Kağıt")) {
            System.out.printf("Bilgisayar %s seçerek senin tercihin olan %s 'i sararak hanesine 1 puan yazdırdı.\n",
                    computerItem, userItem);
            return "computerWin";
        } else if (userItem.equals("Kağıt") && computerItem.equals("Makas")) {
            System.out.printf("Bilgisayar %s seçerek senin tercihin olan %s 'i keserek hanesine 1 puan yazdırdı.\n",
                    computerItem, userItem);
            return "computerWin";
        } else if (userItem.equals("Makas") && computerItem.equals("Taş")) {
            System.out.printf("Bilgisayar %s seçerek senin tercihin olan %s 'i kırarak hanesine 1 puan yazdırdı.\n",
                    computerItem, userItem);
            return "computerWin";
        } else {
            System.out.printf("Bilgisayar ve oyuncu %s seçerek berabere kaldı.\n", userItem);
            return "draw";
        }
    }

    public static void setGameWinner(int userScore, int computerScore, int raunt) {
        if (userScore > computerScore) {
            System.out.printf("\n%d rauntta sen %d puan toplayarak %d puana sahip bilgisayarı eledin TEBRİKLER!!", raunt, userScore, computerScore);
        } else if (computerScore > userScore) {
            System.out.printf("\n%d rauntta bilgisayar %d puan toplayarak %d puana sahip seni eledi..", raunt, computerScore, userScore);
        } else {
            System.out.printf("\n%d rauntta bilgisayar ve sen %d puan topladınız ve berabere kaldınız..", raunt, userScore);
        }
    }
}
