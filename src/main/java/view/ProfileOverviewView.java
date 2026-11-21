package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interface_adapter.profile_overview.ProfileOverviewController;
import interface_adapter.profile_overview.ProfileOverviewState;
import interface_adapter.profile_overview.ProfileOverviewViewModel;
import interface_adapter.profile_overview.ProfileOverviewViewModelListener;
import use_case.search_movie.MovieResult;

public class ProfileOverviewView extends JPanel implements ProfileOverviewViewModelListener {

    static final String NO_PREFERENCES = "No trigger preferences yet. "
            + "Use \"Manage Preferences\" to add some.";
    static final String NO_REVIEWS = "You have not written any reviews yet.";
    static final String NO_SAVED_MOVIES = "You have not saved any movies yet.";

    private static final int GAP = 10;
    private static final Color ERROR_COLOR = new Color(180, 30, 30);

    private final ProfileOverviewViewModel viewModel;

    private final JLabel titleLabel = new JLabel("My Profile");
    private final JLabel messageLabel = new JLabel(" ");
    private final DefaultListModel<String> preferenceItems = new DefaultListModel<>();
    private final DefaultListModel<String> reviewItems = new DefaultListModel<>();
    private final JPanel savedMoviesRow = new JPanel(new FlowLayout(FlowLayout.LEFT, GAP, 0));
    private final JButton backButton = new JButton("← Back to search");
    private final JButton managePreferencesButton = new JButton("Manage Preferences");
    private final JButton signOutButton = new JButton("Sign Out");

    private ProfileOverviewController profileOverviewController;
    private Consumer<String> movieSelectedAction = movieId -> { };
    private Runnable managePreferencesAction = () -> { };
    private Runnable signOutAction = () -> { };

    public ProfileOverviewView(ProfileOverviewViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addListener(this);

        setLayout(new BorderLayout(GAP, GAP));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

        add(buildHeader(), BorderLayout.NORTH);

        final JPanel lists = new JPanel(new GridLayout(1, 2, GAP, 0));
        lists.add(section("Trigger Preferences", new JList<>(preferenceItems)));
        lists.add(section("My Reviews", new JList<>(reviewItems)));

        final JPanel saved = new JPanel(new BorderLayout());
        saved.setBorder(BorderFactory.createTitledBorder("Saved Movies"));
        saved.add(new JScrollPane(savedMoviesRow), BorderLayout.CENTER);

        final JPanel center = new JPanel(new GridLayout(2, 1, 0, GAP));
        center.add(lists);
        center.add(saved);
        add(center, BorderLayout.CENTER);

        backButton.addActionListener(event -> {
            if (profileOverviewController != null) {
                profileOverviewController.switchToSearchView();
            }
        });
        managePreferencesButton.addActionListener(event -> managePreferencesAction.run());
        signOutButton.addActionListener(event -> signOutAction.run());
    }

    private JPanel buildHeader() {
        final JPanel header = new JPanel(new BorderLayout(GAP, 4));
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18f));
        final JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 0));
        buttons.add(managePreferencesButton);
        buttons.add(signOutButton);
        header.add(backButton, BorderLayout.WEST);
        header.add(titleLabel, BorderLayout.CENTER);
        header.add(buttons, BorderLayout.EAST);
        header.add(messageLabel, BorderLayout.SOUTH);
        return header;
    }

    private static JPanel section(String title, JList<String> list) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        list.getAccessibleContext().setAccessibleName(title);
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        return panel;
    }

    @Override
    public void stateChanged() {
        final ProfileOverviewState state = viewModel.getState();
        titleLabel.setText("My Profile — " + state.getUsername());

        if (state.getErrorMessage() != null) {
            messageLabel.setText(state.getErrorMessage());
            messageLabel.setForeground(ERROR_COLOR);
        }
        else {
            messageLabel.setText(" ");
        }

        fill(preferenceItems, state.getTriggerPreferences(), NO_PREFERENCES);
        fill(reviewItems, state.getReviews(), NO_REVIEWS);

        savedMoviesRow.removeAll();
        if (state.getSavedMovies().isEmpty()) {
            savedMoviesRow.add(new JLabel(NO_SAVED_MOVIES));
        }
        for (MovieResult movie : state.getSavedMovies()) {
            savedMoviesRow.add(new MovieCardPanel(movie, movieSelectedAction));
        }
        savedMoviesRow.revalidate();
        savedMoviesRow.repaint();
    }

    private static void fill(DefaultListModel<String> model, List<String> items,
                             String emptyMessage) {
        model.clear();
        if (items.isEmpty()) {
            model.addElement(emptyMessage);
        }
        for (String item : items) {
            model.addElement(item);
        }
    }

    public String getViewName() {
        return ProfileOverviewViewModel.VIEW_NAME;
    }

    public void setProfileOverviewController(ProfileOverviewController controller) {
        this.profileOverviewController = controller;
    }

    public void setMovieSelectedAction(Consumer<String> action) {
        this.movieSelectedAction = action;
    }

    public void setManagePreferencesAction(Runnable action) {
        this.managePreferencesAction = action;
    }

    public void setSignOutAction(Runnable action) {
        this.signOutAction = action;
    }
}
