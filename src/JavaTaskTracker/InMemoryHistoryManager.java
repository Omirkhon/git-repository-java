package JavaTaskTracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryHistoryManager implements HistoryManager {

    private final Map<Integer, Node> nodeMap = new HashMap<>();
    private Node head;
    private Node tail;
    private int currentHistorySize = 0;
    private static final int limit = 10;

    @Override
    public void remove(int id) {
        removeNode(nodeMap.get(id));
        nodeMap.remove(id);
    }

    @Override
    public void add(Task task) {
        if (getHistory()!=null && getHistory().contains(task)) {
            remove(task.getId());
        }
        if (nodeMap.size()>=limit) {
            removeNode(head);
        }
        linkLast(task);
    }

    @Override
    public List<Task> getHistory() {
        System.out.println("Недавно просмотренные задачи: ");
        return getTasks();
    }

    @Override
    public void linkLast(Task task) {
        final Node oldTail = tail;
        final Node newNode = new Node(oldTail, task, null);
        tail = newNode;
        if (oldTail != null) {
            oldTail.next = newNode;
        } else {
            head = newNode;
        }
        nodeMap.put(task.getId(), tail);
        currentHistorySize++;
    }

    @Override
    public List<Task> getTasks() {
        Node current = head;
        List<Task> list = new ArrayList<>();
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    @Override
    public void removeNode(Node node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = node.next;
            head.prev = null;
        } else if (node == tail) {
            tail = node.prev;
            tail.next = null;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        currentHistorySize--;
    }
}

class Node {
    public Task data;
    public Node next;
    public Node prev;

    public Node(Node prev, Task data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
