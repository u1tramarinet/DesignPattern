package mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {

    private static final int LENGTH_MIN_USERNAME = 4;
    private static final int LENGTH_MIN_PASSWORD = 4;

    private ColleagueCheckBox checkBoxGuest;
    private ColleagueCheckBox checkBoxLogin;
    private ColleagueTextField textFieldUser;
    private ColleagueTextField textFieldPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);
        initializeLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

    @Override
    public void createColleagues() {
        initializeComponents();
        setMediator();
        setListeners();
    }

    @Override
    public void colleagueChanged() {
        if (isGuestMode()) {
            textFieldUser.setColleagueEnabled(false);
            textFieldPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            textFieldUser.setColleagueEnabled(true);
            boolean isValidUser = isValidText(textFieldUser, LENGTH_MIN_USERNAME);
            boolean isValidPass = isValidText(textFieldPass, LENGTH_MIN_PASSWORD);
            textFieldPass.setColleagueEnabled(isValidUser);
            buttonOk.setColleagueEnabled(isValidUser && isValidPass);
        }
    }

    private void initializeLayout() {
        setBackground(Color.darkGray);
        setLayout(new GridLayout(4, 2));

        createColleagues();

        add(checkBoxGuest, checkBoxLogin,
                new Label("Username: "), textFieldUser,
                new Label("Password: "), textFieldPass,
                buttonOk, buttonCancel);

        colleagueChanged();

        pack();
        setVisible(true);
    }

    private void initializeComponents() {
        CheckboxGroup group = new CheckboxGroup();
        checkBoxGuest = new ColleagueCheckBox("Guest", group, true);
        checkBoxLogin = new ColleagueCheckBox("Login", group, false);
        textFieldUser = new ColleagueTextField("", 10);
        textFieldPass = new ColleagueTextField("", 10);
        textFieldPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK!");
        buttonCancel = new ColleagueButton("Cancel");
    }

    private void setMediator() {
        checkBoxGuest.setMediator(this);
        checkBoxLogin.setMediator(this);
        textFieldUser.setMediator(this);
        textFieldPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);
    }

    private void setListeners() {
        checkBoxGuest.addItemListener(checkBoxGuest);
        checkBoxLogin.addItemListener(checkBoxLogin);
        textFieldUser.addTextListener(textFieldUser);
        textFieldPass.addTextListener(textFieldPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    private void add(Component... components) {
        for (Component component:components) {
            add(component);
        }
    }

    private boolean isGuestMode() {
        return checkBoxGuest.getState();
    }

    private boolean isValidText(TextField textField, int threshold) {
        return textField.getText().length() >= threshold;
    }
}
