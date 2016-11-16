import model.Node;

/**
 * A Star의 단점
 * 맵의 크기가 커지면 열린 목록이나 닫힌 목록에 수백에서 수천 개의 노드들이 들어갈 수 있기 때문에
 * 시스템의 메모리를 전부 잡아먹을 수도 있으며, 상당히 많은 CPU 시간을 잡아 먹을 수 있다.
 *
 * 1. 시작 점을 정한다.
 * 2. 끝점을 정한다
 *
 *
 *
 * */

public class Main {

    public static void main(String[] args) {
        Node a = new Node('a', 0, 0);
        Node b = new Node('b', 2, 5);
        System.out.println(a.getStraightDistance(b));
    }
}
