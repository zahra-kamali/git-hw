
public class Queues {
    int SIZE = 1000;
    int numberOfQueue;
    int[] arr = new int[SIZE];
    int partSize;

    Queues(int n) {
        numberOfQueue = n;
        partSize = SIZE / numberOfQueue;
        allocate();
    }

    void leftShift(int[] arr, int i1, int len) {
        for (int i = i1; i < i1 + len; i++) {
            arr[i - 1] = arr[i];
        }
    }

    void allocate() {
        for (int i = 0; i < SIZE; i += partSize) {
            arr[i] = i;
        }
    }

    void add(int QNumber, int data) {
        int index = QNumber * partSize;
        if (arr[index] == ((QNumber + 1) * partSize) - 1) {
            System.out.println("queue is full");
        } else {
            arr[index]++;
            arr[arr[index]] = data;
        }
    }

    boolean isEmpty(int QNumber) {
        int index = QNumber * partSize;
        if (arr[index] == index)
            return true;
        return false;
    }

    int pop(int QNumber) {
        if (isEmpty(QNumber))
            return -1;
        else {
            int index = QNumber * partSize;
            int data = arr[index + 1];
            arr[index]--;
            leftShift(this.arr, index + 2, arr[index]-index);
            return data;
        }
    }

    int peek(int QNumber) {
        if (isEmpty(QNumber))
            return -1;
        else {
            int index = QNumber * partSize;
            return arr[index + 1];
        }
    }

    void print(int QNumber) {
        if (isEmpty(QNumber))
            System.out.println("empty");
        else {
            int index = QNumber * partSize;
            for (int i = index + 1; i <= arr[index]; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queues queues = new Queues(3);
        queues.add(0, 4);
        queues.add(0, 3);
        queues.add(0, 2);
        queues.print(0);
        queues.pop(0);
        queues.print(0);
        queues.add(1, 14);
        queues.add(2, 3);
        queues.add(1, -9);
        System.out.println(queues.peek(1));
        System.out.println(queues.isEmpty(2));
        System.out.println(queues.pop(2));
        System.out.println(queues.isEmpty(2));
    }
}
