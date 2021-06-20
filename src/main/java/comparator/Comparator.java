package comparator;

class Checker implements java.util.Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int result = o1.score - o2.score;
        if(result > 0) {
            return -1;
        } else if(result < 0){
            return 1;
        }
        return o1.name.compareTo(o2.name);
    }
}

class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
public class Comparator {

}
