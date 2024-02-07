package algorithm.implemention;

import java.util.*;
import java.io.*;

//랭킹전 대기열
public class QueueBeforeRanking {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Player> playerList = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(reader.readLine());

            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            playerList.add(new Player(l, n));
        }

        List<List<Player>> roomList = new ArrayList<>();

        for (Player player : playerList) {
            boolean matched = false;

            for (List<Player> room : roomList) {
                if (Math.abs(player.level - room.get(0).level) <= 10 && room.size() < m) {
                    room.add(player);
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                List<Player> newRoom = new ArrayList<>();
                newRoom.add(player);
                roomList.add(newRoom);
            }
        }

        for (int i = 0; i < roomList.size(); i++) {
            Collections.sort(roomList.get(i));
            if (roomList.get(i).size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            for (int j = 0; j < roomList.get(i).size(); j++) {
                System.out.println(roomList.get(i).get(j).getLevel() + " " + roomList.get(i).get(j).getNickname());
            }
        }


        reader.close();
    }

    private static class Player implements Comparable<Player> {
        private int level;
        private String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        public int getLevel() {
            return this.level;
        }

        public String getNickname() {
            return this.nickname;
        }

        @Override
        public int compareTo(Player other) {
            return this.nickname.compareTo(other.getNickname());
        }
    }
}
