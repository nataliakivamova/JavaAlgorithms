package Lesson2;

public class ArrayList {
    private int[] arr;
    private int size;

    public ArrayList(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(" " + arr[i] + " ");
        }
    }

    public void find(int value) {
        int low = 0;
        int high = this.size - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == this.arr[mid]) {
                System.out.println("Искомое значение " + value + " найдено");
            } else {
                if (value < this.arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        System.out.println("Искомое значение " + value + " не найдено");
    }

    public void delete(int value) {
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                break;
            }
        }

        if (this.arr[i] != value) {
            System.out.println("Значения " + value + " в массиве нет");
        } else {

            for (int j = i; j < this.size - 1; j++) {
                this.arr[j] = this.arr[j + 1];
            }
            this.size--;
            display();
        }
    }

    public void insert(int value) {
        if (size == arr.length) {
            int[] list = new int[size + 1];
            System.arraycopy(arr, 0, list, 0, size);
            arr = list;
            arr[arr.length - 1] = value;
        } else {
            this.arr[size++] = value;
        }
    }
}
