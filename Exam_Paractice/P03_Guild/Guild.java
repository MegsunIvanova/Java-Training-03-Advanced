package Exam_Paractice.P03_Guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {

    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        roster.stream()
                .filter(player -> player.getName().equals(name) && !player.getRank().equals("Member"))
                .findFirst()
                .ifPresent(player -> player.setRank("Member"));
    }

    public void demotePlayer(String name) {
        roster.stream()
                .filter(player -> player.getName().equals(name) && !player.getRank().equals("Trial"))
                .findFirst()
                .ifPresent(player -> player.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> playersForRemoving = roster.stream()
                .filter(player -> player.getClazz().equals(clazz))
                .collect(Collectors.toCollection(ArrayList::new));
        roster.removeAll(playersForRemoving);
        return playersForRemoving.toArray(new Player[0]);
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ").append(name).append(":");
        sb.append(System.lineSeparator());
        sb.append(roster.stream().map(Player::toString).collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }


}
