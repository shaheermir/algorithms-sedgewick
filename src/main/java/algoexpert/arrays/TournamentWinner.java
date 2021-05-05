package algoexpert.arrays;

// import java.util.ArrayList;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class TournamentWinner {
  public static String tournamentWinner(List<List<String>> competitions, List<Integer> results) {

    final int HOME_TEAM_WON = 1;
    String currentBestTeam = "";
    Map<String, Integer> scores = new HashMap<>();
    scores.put(currentBestTeam, 0);

    for (int i = 0; i < competitions.size(); i++) {
      List<String> competition = competitions.get(i);
      int result = results.get(i);
      String homeTeam = competition.get(0);
      String awayTeam = competition.get(1);
      String winningTeam = result == HOME_TEAM_WON ? homeTeam : awayTeam;
      updateScores(scores, winningTeam, 3);

      if (scores.get(winningTeam) > scores.get(currentBestTeam)) currentBestTeam = winningTeam;
    }
    return currentBestTeam;
  }

  private static void updateScores(Map<String, Integer> scores, String team, int points) {
    if (!scores.containsKey(team)) {
      scores.put(team, 0);
    }
    scores.put(team, scores.get(team) + points);
  }

  public static void main(String[] args) {
    List<List<String>> competitions = new ArrayList<>();
    List<String> match1 = Arrays.asList("HTML", "C#");
    List<String> match2 = Arrays.asList("HTML", "C#");
    List<String> match3 = Arrays.asList("HTML", "C#");
    competitions.add(match1);
    competitions.add(match2);
    competitions.add(match3);

    List<Integer> results = Arrays.asList(0, 0, 1);

    StdOut.println(tournamentWinner(competitions, results));
  }
}
