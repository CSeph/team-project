package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import interface_adapter.profile_overview.ProfileOverviewController;
import interface_adapter.search_movie.SearchMovieController;
import interface_adapter.search_movie.SearchMovieState;
import interface_adapter.search_movie.SearchMovieViewModel;
import interface_adapter.search_movie.SearchMovieViewModelListener;
import use_case.search_movie.MovieResult;

public class SearchMovieView extends JPanel implements SearchMovieViewModelListener {

    static final String ANY = "Any";

    private static final int NEWEST_YEAR = 2026;
    private static final int OLDEST_YEAR = 1950;
    private static final int[] RATING_STEPS = {5, 6, 7, 8, 9};
    private static final int GRID_COLUMNS = 4;
    private static final int GAP = 10;
    private static final int SEARCH_COLUMNS = 24;
    private static final Color ERROR_COLOR = new Color(180, 30, 30);

    private final SearchMovieViewModel viewModel;

    private final JTextField searchField = new JTextField(SEARCH_COLUMNS);
    private final JButton searchButton = new JButton("Search");
    private final JButton profileButton = new JButton("My Profile");
    private final JButton uploadButton = new JButton("+ Upload Media");
    private final JComboBox<String> genreBox = new JComboBox<>();
    private final JComboBox<String> yearBox = new JComboBox<>();
    private final JComboBox<String> ratingBox = new JComboBox<>();
    private final JButton clearFiltersButton = new JButton("Clear filters");
    private final JLabel messageLabel = new JLabel(" ");
    private final JPanel resultsGrid = new JPanel(new GridLayout(0, GRID_COLUMNS, GAP, GAP));

    private SearchMovieController searchMovieController;
    private ProfileOverviewController profileOverviewController;
    private Consumer<String> movieSelectedAction = movieId -> { };
    private Runnable uploadAction = () -> { };
    private List<String> shownGenres = new ArrayList<>();
    private boolean updatingFilters;

    public SearchMovieView(SearchMovieViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addListener(this);

        setLayout(new BorderLayout(GAP, GAP));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

        final JPanel north = new JPanel(new GridLayout(0, 1, 0, 4));
        north.add(buildSearchBar());
        north.add(buildFilterBar());
        north.add(messageLabel);
        add(north, BorderLayout.NORTH);

        final JPanel gridHolder = new JPanel(new BorderLayout());
        gridHolder.add(resultsGrid, BorderLayout.NORTH);
        add(new JScrollPane(gridHolder), BorderLayout.CENTER);

        fillStaticFilterOptions();
        wireActions();
        showMessage("Type a movie title and press Search.", false);
    }

    private JPanel buildSearchBar() {
        final JPanel bar = new JPanel(new BorderLayout(GAP, 0));
        final JLabel title = new JLabel("Trigger Warning");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 18f));

        final JPanel middle = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        final JLabel searchLabel = new JLabel("Search movie:");
        searchLabel.setLabelFor(searchField);
        middle.add(searchLabel);
        middle.add(searchField);
        middle.add(searchButton);

        final JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 0));
        right.add(uploadButton);
        right.add(profileButton);

        bar.add(title, BorderLayout.WEST);
        bar.add(middle, BorderLayout.CENTER);
        bar.add(right, BorderLayout.EAST);
        return bar;
    }

    private JPanel buildFilterBar() {
        final JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        bar.add(labelFor("Genre:", genreBox));
        bar.add(genreBox);
        bar.add(labelFor("Year:", yearBox));
        bar.add(yearBox);
        bar.add(labelFor("Min rating:", ratingBox));
        bar.add(ratingBox);
        bar.add(clearFiltersButton);
        return bar;
    }

    private static JLabel labelFor(String text, JComboBox<String> box) {
        final JLabel label = new JLabel(text);
        label.setLabelFor(box);
        return label;
    }

    private void fillStaticFilterOptions() {
        genreBox.addItem(ANY);
        yearBox.addItem(ANY);
        for (int year = NEWEST_YEAR; year >= OLDEST_YEAR; year--) {
            yearBox.addItem(String.valueOf(year));
        }
        ratingBox.addItem(ANY);
        for (int step : RATING_STEPS) {
            ratingBox.addItem(step + "+");
        }
    }

    private void wireActions() {
        searchButton.addActionListener(event -> runSearch());
        searchField.addActionListener(event -> runSearch());
        genreBox.addActionListener(event -> rerunIfSearched());
        yearBox.addActionListener(event -> rerunIfSearched());
        ratingBox.addActionListener(event -> rerunIfSearched());
        clearFiltersButton.addActionListener(event -> {
            updatingFilters = true;
            genreBox.setSelectedItem(ANY);
            yearBox.setSelectedItem(ANY);
            ratingBox.setSelectedItem(ANY);
            updatingFilters = false;
            rerunIfSearched();
        });
        profileButton.addActionListener(event -> {
            if (profileOverviewController != null) {
                profileOverviewController.execute();
            }
        });
        uploadButton.addActionListener(event -> uploadAction.run());
    }

    private void rerunIfSearched() {
        if (!updatingFilters && !searchField.getText().isBlank()) {
            runSearch();
        }
    }

    private void runSearch() {
        if (searchMovieController == null) {
            return;
        }
        searchMovieController.execute(searchField.getText(), selectedGenre(),
                selectedYear(), selectedMinRating());
    }

    private String selectedGenre() {
        final Object choice = genreBox.getSelectedItem();
        if (choice == null || ANY.equals(choice)) {
            return null;
        }
        return choice.toString();
    }

    private Integer selectedYear() {
        final Object choice = yearBox.getSelectedItem();
        if (choice == null || ANY.equals(choice)) {
            return null;
        }
        return Integer.valueOf(choice.toString());
    }

    private Double selectedMinRating() {
        final Object choice = ratingBox.getSelectedItem();
        if (choice == null || ANY.equals(choice)) {
            return null;
        }
        return Double.valueOf(choice.toString().replace("+", ""));
    }

    @Override
    public void stateChanged() {
        final SearchMovieState state = viewModel.getState();
        refreshGenreOptions(state.getAvailableGenres());

        resultsGrid.removeAll();
        for (MovieResult movie : state.getResults()) {
            resultsGrid.add(new MovieCardPanel(movie, movieSelectedAction));
        }
        if (state.getErrorMessage() != null) {
            showMessage(state.getErrorMessage(), true);
        }
        else if (!state.getResults().isEmpty()) {
            showMessage(state.getResults().size() + " movie(s) found for \""
                    + state.getQuery() + "\".", false);
        }
        resultsGrid.revalidate();
        resultsGrid.repaint();
    }

    private void refreshGenreOptions(List<String> genres) {
        if (genres.equals(shownGenres)) {
            return;
        }
        updatingFilters = true;
        final Object selected = genreBox.getSelectedItem();
        genreBox.removeAllItems();
        genreBox.addItem(ANY);
        for (String genre : genres) {
            genreBox.addItem(genre);
        }
        genreBox.setSelectedItem(selected == null ? ANY : selected);
        shownGenres = new ArrayList<>(genres);
        updatingFilters = false;
    }

    private void showMessage(String message, boolean isError) {
        messageLabel.setText(message);
        messageLabel.setForeground(isError ? ERROR_COLOR : Color.DARK_GRAY);
    }

    public String getViewName() {
        return SearchMovieViewModel.VIEW_NAME;
    }

    public void setSearchMovieController(SearchMovieController controller) {
        this.searchMovieController = controller;
    }

    public void setProfileOverviewController(ProfileOverviewController controller) {
        this.profileOverviewController = controller;
    }

    public void setMovieSelectedAction(Consumer<String> action) {
        this.movieSelectedAction = action;
    }

    public void setUploadAction(Runnable action) {
        this.uploadAction = action;
    }
}
