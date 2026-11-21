package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import use_case.search_movie.MovieResult;

public class MovieCardPanel extends JPanel {

    private static final int CARD_WIDTH = 180;
    private static final int CARD_HEIGHT = 230;
    private static final int POSTER_HEIGHT = 110;
    private static final int PADDING = 8;
    private static final int TITLE_FONT_SIZE = 14;
    private static final Color POSTER_COLOR = new Color(74, 85, 162);
    private static final Color BORDER_COLOR = new Color(200, 200, 210);

    public MovieCardPanel(MovieResult movie, Consumer<String> onSelect) {
        setLayout(new BorderLayout(0, PADDING));
        setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR),
                BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING)));

        final JLabel poster = new JLabel(initials(movie.getTitle()), SwingConstants.CENTER);
        poster.setOpaque(true);
        poster.setBackground(POSTER_COLOR);
        poster.setForeground(Color.WHITE);
        poster.setFont(poster.getFont().deriveFont(Font.BOLD, 28f));
        poster.setPreferredSize(new Dimension(CARD_WIDTH, POSTER_HEIGHT));
        add(poster, BorderLayout.NORTH);

        final JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);
        final JLabel title = new JLabel("<html>" + escape(movie.getTitle()) + "</html>");
        title.setFont(title.getFont().deriveFont(Font.BOLD, TITLE_FONT_SIZE));
        info.add(title);
        info.add(new JLabel(yearText(movie.getReleaseYear())
                + "   ★ " + String.format("%.1f", movie.getVoteAverage())));
        add(info, BorderLayout.CENTER);

        final JButton open = new JButton("View details");
        open.getAccessibleContext().setAccessibleName("View details for " + movie.getTitle());
        open.addActionListener(event -> onSelect.accept(movie.getId()));
        add(open, BorderLayout.SOUTH);
    }

    private static String yearText(int year) {
        if (year <= 0) {
            return "Year unknown";
        }
        return String.valueOf(year);
    }

    private static String initials(String title) {
        final StringBuilder letters = new StringBuilder();
        for (String word : title.split("\\s+")) {
            if (!word.isEmpty() && Character.isLetterOrDigit(word.charAt(0))
                    && letters.length() < 2) {
                letters.append(Character.toUpperCase(word.charAt(0)));
            }
        }
        return letters.toString();
    }

    private static String escape(String text) {
        return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
