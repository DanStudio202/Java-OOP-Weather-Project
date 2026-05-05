import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the main graphical user interface for the Weather Application.
 * Manages multiple views for Login, Account Creation, Weather using CardLayout.
 */
public class GUI extends JFrame {
    // Create a simulated database to hold incoming Username & Passwords -Dan
    private Authenticate auth = new Authenticate();

    private CardLayout cardLayout;
    private JPanel mainContainer;
    private String currentUser = "";

    // The API setup -Dan
    private WeatherAPI api;
    private Clothes clothes = new Clothes();

    private JLabel profileLabel;
    
    /**
     * Constructs the GUI window and initializes components.
     * * @param api The WeatherAPI instance used to fetch data.
     */
    
    // The gui construction -Dan
    public GUI(WeatherAPI api) {
        this.api = api;

        setTitle("Weather App");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 248, 255)); // Alice Blue

        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);
        mainContainer.setOpaque(false);

        mainContainer.add(createLoginPanel(), "Login");
        mainContainer.add(createAccountPanel(), "CreateAccount");
        mainContainer.add(createWeatherPanel(), "Weather");

        add(mainContainer);
    }

    /**
     * Builds the login screen panel.
     * @return The login JPanel.
     */
    // Creates the login menu + creation -Dan
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Welcome!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(70, 130, 180));
        loginBtn.setForeground(Color.WHITE);

        JButton createNavBtn = new JButton("Create New Account");

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1; gbc.gridy = 1;
        panel.add(userLabel, gbc);
        gbc.gridx = 1;
        panel.add(userField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(passLabel, gbc);
        gbc.gridx = 1;
        panel.add(passField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(loginBtn, gbc);

        gbc.gridy = 4;
        panel.add(createNavBtn, gbc);

        // handles the login logic -Dan
        loginBtn.addActionListener(e -> {
            String u = userField.getText();
            String p = new String(passField.getPassword());
            if (auth.checkLogin(u, p)) {
                currentUser = u;
                profileLabel.setText("User: " + currentUser);
                userField.setText("");
                passField.setText("");
                cardLayout.show(mainContainer, "Weather");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // will open up the Account Creation menu -Dan
        createNavBtn.addActionListener(e -> {
            userField.setText("");
            passField.setText("");
            cardLayout.show(mainContainer, "CreateAccount");
        });

        return panel;
    }

    /**
     * Builds the account creation panel.
     * @return The registration JPanel.
     */
    // makes the account creation screen -Dan
    private JPanel createAccountPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Create Account", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));

        JLabel userLabel = new JLabel("New Username:");
        JTextField userField = new JTextField(15);

        JLabel passLabel = new JLabel("New Password:");
        JPasswordField passField = new JPasswordField(15);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBackground(new Color(34, 139, 34)); // Forest Green
        registerBtn.setForeground(Color.WHITE);

        JButton cancelBtn = new JButton("Cancel");

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1; gbc.gridy = 1;
        panel.add(userLabel, gbc);
        gbc.gridx = 1;
        panel.add(userField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(passLabel, gbc);
        gbc.gridx = 1;
        panel.add(passField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(registerBtn, gbc);
        gbc.gridx = 1;
        panel.add(cancelBtn, gbc);

        // this handles th registration logic to arrays -Dan
        registerBtn.addActionListener(e -> {
            String u = userField.getText();
            String p = new String(passField.getPassword());
            if (!u.trim().isEmpty() && !p.trim().isEmpty()) {
                auth.registerUser(u, p);
                JOptionPane.showMessageDialog(this, "Account Created Successfully! Please log in.");
                userField.setText("");
                passField.setText("");
                cardLayout.show(mainContainer, "Login");
            } else {
                JOptionPane.showMessageDialog(this, "Fields cannot be empty.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        // this will cancel creation and return to the login screen -Dan
        cancelBtn.addActionListener(e -> {
            userField.setText("");
            passField.setText("");
            cardLayout.show(mainContainer, "Login");
        });

        return panel;
    }

    /**
     * Builds the main weather dashboard panel.
     * @return The weather info JPanel.
     */
    // Once logged in, creates weather screen app -Dan
    private JPanel createWeatherPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(15, 20, 15, 20));
        panel.setBackground(new Color(240, 248, 255));

        // Username Text to show who your logged as -Dan
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        profileLabel = new JLabel("User: ");
        profileLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBackground(new Color(220, 20, 60)); // Crimson
        logoutBtn.setForeground(Color.WHITE);

        topPanel.add(profileLabel, BorderLayout.WEST);
        topPanel.add(logoutBtn, BorderLayout.EAST);

        // All the inputs in the weather screen -Dan
        JPanel centerPanel = new JPanel(new BorderLayout(10, 20));
        centerPanel.setOpaque(false);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setOpaque(false);
        inputPanel.setBorder(BorderFactory.createTitledBorder("Location Details"));

        JTextField cityField = new JTextField();
        JTextField stateField = new JTextField();
        JTextField zipField = new JTextField();
        JButton checkBtn = new JButton("Check Weather");
        checkBtn.setBackground(new Color(70, 130, 180));
        checkBtn.setForeground(Color.WHITE);

        inputPanel.add(new JLabel("City:"));
        inputPanel.add(cityField);
        inputPanel.add(new JLabel("State (Optional):"));
        inputPanel.add(stateField);
        inputPanel.add(new JLabel("Zipcode (Optional):"));
        inputPanel.add(zipField);
        inputPanel.add(new JLabel("")); // Empty spacer
        inputPanel.add(checkBtn);

        // The results section
        JPanel resultsPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        resultsPanel.setOpaque(false);
        JLabel tempLabel = new JLabel("--", SwingConstants.CENTER);
        tempLabel.setFont(new Font("Segoe UI", Font.BOLD, 54));
        tempLabel.setForeground(new Color(25, 25, 112)); // Midnight Blue

        JLabel clothesLabel = new JLabel("Recommendations will appear here.", SwingConstants.CENTER);
        clothesLabel.setFont(new Font("Segoe UI", Font.ITALIC, 16));

        resultsPanel.add(tempLabel);
        resultsPanel.add(clothesLabel);

        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(resultsPanel, BorderLayout.CENTER);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);

        // Will fetch the weather and update the results -Dan
        checkBtn.addActionListener(e -> {
            String city = cityField.getText().trim();
            String state = stateField.getText().trim();
            String zip = zipField.getText().trim();

            // The build of queries + error text -Dan
            String query = city;
            if (!state.isEmpty()) query += "," + state;
            if (!zip.isEmpty()) query += "," + zip;

            if (city.isEmpty() && zip.isEmpty()) {
                tempLabel.setText("Oops!");
                clothesLabel.setText("Please enter a valid City or Zipcode.");
                clothesLabel.setForeground(Color.RED);
                return;
            }

            Weather w = api.fetch(query);
            if (w != null) {
                tempLabel.setText(String.format("%.1f °F", w.getTemp()));
                List<String> recs = clothes.matchItems(w);
                clothesLabel.setText("Wear: " + String.join(", ", recs));
                clothesLabel.setForeground(new Color(34, 139, 34));
            } else {
                tempLabel.setText("Oops!");
                clothesLabel.setText("Invalid City");
                clothesLabel.setForeground(Color.RED);
            }
        });

        // logging out logic -Dan
        logoutBtn.addActionListener(e -> {
            currentUser = "";
            cityField.setText("");
            stateField.setText("");
            zipField.setText("");
            tempLabel.setText("--");
            clothesLabel.setText("Recommendations will appear here.");
            clothesLabel.setForeground(Color.BLACK);
            cardLayout.show(mainContainer, "Login");
        });

        return panel;
    }
}
