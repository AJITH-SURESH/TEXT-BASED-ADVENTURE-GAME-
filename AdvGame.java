import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AdvGame {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, coinLabel, coinCountLabel,playerNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing, playerCoins, dragonHP,dragonDamage;
    String weapon, position , playerName;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    ImageIcon logo = new ImageIcon(".//res//jackfrost.jpg");

    public static void main(String[] args) {
        new AdvGame();
    }

    public AdvGame() {

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setIconImage(logo.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);

        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        con.add(mainTextPanel);
        mainTextArea = new JTextArea("This is the main text area. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.WHITE);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.WHITE);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.WHITE);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.WHITE);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.WHITE);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.WHITE);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.WHITE);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.WHITE);
        playerPanel.add(weaponLabelName);

        coinLabel = new JLabel("Coins:");
        coinLabel.setFont(normalFont);
        coinLabel.setForeground(Color.WHITE);
        playerPanel.add(coinLabel);
        coinCountLabel = new JLabel("0");
        coinCountLabel.setFont(normalFont);
        coinCountLabel.setForeground(Color.WHITE);
        playerPanel.add(coinCountLabel);
        playerNameLabel = new JLabel("");
        playerNameLabel.setFont(normalFont);
        playerNameLabel.setForeground(Color.WHITE);
        playerPanel.add(playerNameLabel);

        playerSetup();
    }

    public void playerSetup() {
        playerHP = 15;
        monsterHP = 20;
        dragonHP = 50;
        silverRing = 0;
        playerCoins = 20; // Starting with 20 coins
        weapon = "Knife";
        playerName = "";
        playerNameLabel.setText("" + playerName);
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);
        coinCountLabel.setText("" + playerCoins);

        nameSelect();
    }
    public void nameSelect(){
        position = "nameSelect";
        mainTextArea.setText("Select the Character You want to play......!");
        choice1.setText("ARES");
        choice2.setText("ARTEMIS");
        choice3.setText("ATHENA");
        choice4.setText("HERA");
    }

    public void townGate() {
        position = "townGate";
        mainTextArea.setText("You are at the gate of the town. A guard is standing in front of you.\n\nWhat do you do?");
        choice1.setText("Talk to the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkGuard() {
        position = "talkGuard";
        mainTextArea.setText("Guard: Hello stranger. I have never seen your face.\nI'm sorry but we cannot let a stranger enter our town.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void attackGuard() {
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
        playerHP -= 3;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad() {
        position = "crossRoad";
        mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
        choice1.setText("Go north");
        choice2.setText("Go east");
        choice3.setText("Go south");
        choice4.setText("Go west");
    }

    public void north() {
        position = "north";
        mainTextArea.setText("There is a river. You drink the water and rest at the riverside.\n\n(Your HP is recovered by 2)");
        playerHP += 2;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("Go Back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void east() {
        position = "east";
        mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);
        choice1.setText("Go Back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void west() {
        position = "west";
        mainTextArea.setText("You encounter a goblin!");
        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void fight() {
        position = "fight";
        mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void playerAttack() {
        position = "playerAttack";
        int playerDamage = 0;

        if (weapon.equals("Knife")) {
            playerDamage = new java.util.Random().nextInt(3);
        } else if (weapon.equals("Long Sword")) {
            playerDamage = new java.util.Random().nextInt(12);
        }

        mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");

        monsterHP = monsterHP - playerDamage;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void monsterAttack() {
        position = "monsterAttack";
        int monsterDamage = 0;
        monsterDamage = new java.util.Random().nextInt(6);

        mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");

        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void win() {
        position = "win";
        // int coinsEarned = new java.util.Random().nextInt(10) + 1;
        playerCoins += 5;
        coinCountLabel.setText(String.valueOf(playerCoins));
        mainTextArea.setText("You defeated the monster and earned " + "5" + " coins!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
        silverRing = 1;
        choice1.setText("Leave");
        //choice2.setText("Go to the market");
        choice3.setText("");
        //choice4.setText("Go to the town square");
    }

    public void lose() {
        position = "lose";
        mainTextArea.setText("You are dead!\n\nGAME OVER");
        // choice1.setText("");
        // choice2.setText("");
        // choice3.setText("");
        // choice4.setText("");
        // choice1.setVisible(false);
        // choice2.setVisible(false);
        // choice3.setVisible(false);
        // choice4.setVisible(false);
    }

    public void ending() {
        position = "win";
        mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are a true hero!\nWelcome to our town!");
        choice2.setText("Go to Market");
        choice3.setText("Go to TownSquare");
        choice1.setText(">");
        choice4.setText("");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(true);
    }

    public void market() {
        position = "market";
        mainTextArea.setText("You are at the market. The merchant eyes your Silver Ring.\n\nMerchant: I'll give you 60 coins for that Silver Ring.\n\nWhat do you want to do?");
        choice1.setText("Sell the Silver Ring");
        choice2.setText("Leave");
        choice3.setText("");
        choice4.setText("");
    }

    public void market2() {
        position = "market2";
        playerCoins -= 5;
        silverRing = 0;
        mainTextArea.setText("You are at the market again. The merchant has more items for sale.\n\nYou have " + playerCoins + " coins.\n\nWhat do you want to do?");
        // choice1.setText("Sell Silver Ring(50) coins)");
        choice2.setText("Buy Armor (70 coins)");
        choice3.setText("Buy Health Potion (20 coins)");
        choice4.setText("Leave");
    }

    public void townPeople() {
        position = "townPeople";
        mainTextArea.setText("You are in the town square. The townspeople are bustling about.\n\nOne of the townspeople approaches you.\n\nTownspeople: We need a hero to retrieve the Dragon Scale. We will reward you with 500 coins. Will you accept the quest?");
        choice1.setText("Accept the quest");
        choice2.setText("Decline the quest");
        choice3.setText("");
        choice4.setText("");
    }

    public void dragonQuest() {
        position = "dragonQuest";
        // dragonHP = 50;
        dragonHP = dragonHP - dragonDamage;
        mainTextArea.setText("You embark on the quest to find the Dragon Scale.\n\nYou enter the dragon's lair. \n\nDragon HP: " + dragonHP + 
        "\n\nWhat do you do?");
        choice1.setText("Attack the Dragon");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void dragonAttack() {
        position = "dragonAttack";
        // int dragonDamage = 0;
        dragonDamage = new java.util.Random().nextInt(6);

        mainTextArea.setText("The Dragon attacks you and deals " + dragonDamage + " damage!");
        
        playerHP = playerHP - dragonDamage;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        // position = "dragonAttack";
        // int dragonDamage = new java.util.Random().nextInt(9);
        // mainTextArea.setText("The Dragon attacks you and deals " + dragonDamage + " damage!");
        // playerHP -= dragonDamage;
        // hpLabelNumber.setText("" + playerHP);
        // choice1.setText("Continue the fight");
        // choice2.setText("Run");
        // choice3.setText("");
        // choice4.setText("");
    }

    public void dragonWin() {
        position = "dragonWin";
        playerCoins += 500;
        coinCountLabel.setText(String.valueOf(playerCoins));
        mainTextArea.setText("Congratulations! You defeated the Dragon and obtained the Dragon Scale!\n\nYou return to the town square.\n\nTownspeople: You are a true hero! Here are your 500 coins as promised.");
        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void AdvContinue() {
        position = "AdvContinue";
        // playerCoins += 500;
        // coinCountLabel.setText(String.valueOf(playerCoins));
        mainTextArea.setText("YOUR ADVENTURES DO NOT END HERE!\n Until we meet Again......\n Αντίο, τα λέμε ξανά");
        choice1.setText("End");
        // choice2.setText("");
        // choice3.setText("");
        // choice4.setText("");
    }

    public void ringSold(){
        position = "ringSold";
        playerCoins = playerCoins + 60;
        coinCountLabel.setText(String.valueOf(playerCoins));
        silverRing = 0;
        mainTextArea.setText("You sold the Silver Ring for 60 coins.\n\nYou have " + playerCoins + " coins.");
        choice1.setText("Leave");
        choice2.setText("Go to the market");
        choice3.setText("");
        // choice4.setText("Go to the town square");
    }

    public void Armor(){
        position = "armor";
        if (playerCoins >= 70) {
            playerCoins -= 70;
            coinCountLabel.setText(String.valueOf(playerCoins));
            mainTextArea.setText("You bought Armor for 70 coins.\n\nYou have " + playerCoins + " coins left.");
        } else {
            mainTextArea.setText("You don't have enough coins to buy Armor.");
        }
        choice1.setText("Leave");
        choice2.setText("Go to Market");
        choice3.setText("");
        choice4.setText("");
    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (position) {
                case "nameSelect":
                    switch (yourChoice){
                        case "c1":
                            playerName = "ARES";
                            townGate();
                            break;
                        case "c2":
                            playerName = "ARTEMIS";
                            townGate();
                            break;
                        case "c3":
                            playerName = "ATHENA";
                            townGate();
                            break;
                        case "c4":
                            playerName = "HERA";
                            townGate();
                            break;
                    }
                    break;
                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            if (silverRing == 1) {
                                ending();
                            } else {
                                talkGuard();
                            }
                            break;
                        case "c2":
                            attackGuard();
                            break;
                        case "c3":
                            crossRoad();
                            break;
                    }
                    break;
                case "talkGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "attackGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "crossRoad":
                    switch (yourChoice) {
                        case "c1":
                            north();
                            break;
                        case "c2":
                            east();
                            break;
                        case "c3":
                            townGate();
                            break;
                        case "c4":
                            west();
                            break;
                    }
                    break;
                case "north":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;
                case "east":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;
                case "west":
                    switch (yourChoice) {
                        case "c1":
                            fight();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "fight":
                    switch (yourChoice) {
                        case "c1":
                            playerAttack();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "playerAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (monsterHP < 1) {
                                win();
                            } else {
                                monsterAttack();
                            }
                            break;
                    }
                    break;
                case "monsterAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (playerHP < 1) {
                                lose();
                            } else {
                                fight();
                            }
                            break;
                    }
                    break;
                case "win":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                        case "c2":
                            if(silverRing == 1){
                                market();
                            }
                            else{
                                market2();
                            }
                            
                            break;
                        case "c3":
                            townPeople();
                            break;
                    }
                    break;
                case "market":
                    switch (yourChoice) {
                        case "c1":
                            ringSold();
                            break;
                        case "c2":
                            ending();
                            break;
                    }
                    break;
                case "market2":
                    switch (yourChoice) {
                        case "c1":
                            // if (playerCoins >= 70) {
                            //     weapon = "Night's Blade";
                            //     weaponLabelName.setText(weapon);
                            //     playerCoins -= 70;
                            //     coinCountLabel.setText(String.valueOf(playerCoins));
                            //     mainTextArea.setText("You bought Night's Blade for 70 coins.\n\nYou have " + playerCoins + " coins left.");
                            // } else {
                            //     mainTextArea.setText("You don't have enough coins to buy Night's Blade.");
                            // }
                            // choice1.setText("Go west");
                            // choice2.setText("");
                            // choice3.setText("");
                            // choice4.setText("");
                            break;
                        case "c2":
                            Armor();
                            break;
                        case "c3":
                            if (playerCoins >= 30) {
                                playerCoins -= 30;
                                coinCountLabel.setText(String.valueOf(playerCoins));
                                mainTextArea.setText("You bought a Health Potion for 30 coins.\n\nYou have " + playerCoins + " coins left.");
                            } else {
                                mainTextArea.setText("You don't have enough coins to buy a Health Potion.");
                            }
                            choice1.setText("Go west");
                            choice2.setText("");
                            choice3.setText("");
                            choice4.setText("");
                            break;
                        case "c4":
                            ending();
                            break;
                    }
                    break;
                case "townPeople":
                    switch (yourChoice) {
                        case "c1":
                            dragonQuest();
                            break;
                        case "c2":
                            townGate();
                            break;
                    }
                    break;
                case "dragonQuest":
                    switch (yourChoice) {
                        case "c1":
                            if (dragonHP > 0) {
                                dragonAttack();
                            }
                            else if (playerHP <= 0) {
                                    lose();
                                    break;
                                }
                            
                            if (dragonHP <= 0) {
                                dragonWin();
                            }
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "dragonAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (playerHP > 0) {
                                dragonQuest();
                            }
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "dragonWin":
                    switch (yourChoice) {
                        case "c1":
                            AdvContinue();
                            break;
                    }
                    break;
                case "AdvContinue":
                    switch (yourChoice){
                        case "c1":
                            window.dispose();
                    }
                case "lose":
                    switch (yourChoice) {
                        case "c1":
                            playerSetup();
                            break;
                    }
                    break;
                case "ending":
                    switch (yourChoice) {
                        case "c1":
                            playerSetup();
                            break;
                    }
                    break;
                case "ringSold":
                    switch (yourChoice){
                        case "c1":
                            ending();
                        case "c2":
                            market2();
                    }
                case "armor":
                    switch (yourChoice){
                        case "c1":
                            market2();
                        case "c2":
                            ending();
                    }
            }
        }
    }
}
