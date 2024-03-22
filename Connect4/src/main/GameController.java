package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    private Settings settings;
    private Game game;
    private EnglishMenu englishMenu;
    private ArabicMenu arabicMenu;
    private GUI gui;

    public GameController(Settings settings, Game game, EnglishMenu englishMenu, ArabicMenu arabicMenu, GUI gui) {
        this.settings = settings;
        this.game = game;
        this.englishMenu = englishMenu;
        this.arabicMenu = arabicMenu;
        this.gui = gui;

        // Add action listeners to components
        addActionListeners();
    }

    private void addActionListeners() {
        // Add this controller as the ActionListener for components
        //Settings Buttons
        settings.addPlayerNameSubmitActionListener(this);
        settings.addChangeEnglishLanguageActionListener(this);
        settings.addChangeArabicLanguageActionListener(this);

        //English Menu Buttons
        englishMenu.addSettingsButtonActionListener(this);
        englishMenu.addOfflinePlayButtonActionListener(this);
        englishMenu.addOnlinePlayButtonActionListener(this);
        englishMenu.addQuitButtonActionListener(this);

        //Arabic Menu Buttons
        arabicMenu.addSettingsButtonActionListener(this);
        arabicMenu.addOfflinePlayButtonActionListener(this);
        arabicMenu.addOnlinePlayButtonActionListener(this);
        arabicMenu.addQuitButtonActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Switch-case structure to handle different actions
        switch (e.getActionCommand()) {
            case "SubmitPlayerNames":
                String player1Name = settings.getPlayer1();
                String player2Name = settings.getPlayer2();
                // game.setPlayerNames(player1Name, player2Name);
                break;
            case "SettingsButton":
            System.out.println("In settings");
                boolean whichOne = settings.getWhichOne();
                if(!(whichOne)){
                    englishMenu.toggleSettings();
                }else{
                    arabicMenu.toggleSettings();
                }
                break;
            case "OfflinePlayButton":
                System.out.print("its me");
                startOfflineGame();
                break;
            case "OnlinePlayButton":
                startOnlineGame();
                break;
            case "QuitButton":
                quitGame();
                break;
            case "ChangeLanguage":
            settings.setWhichOne(!(settings.getWhichOne()));
            gui.ChangeLanguage();
            break;
            default:
                // Handle other action commands if needed
                break;
        }
    }

    private void startOfflineGame() {
        game = new Game();
        gui.add(game);
        englishMenu.setVisible(false);
        arabicMenu.setVisible(false);
    }

    private void startOnlineGame() {
        // online game stuffs
    }

    private void quitGame() {
        System.exit(0);
    }
}
