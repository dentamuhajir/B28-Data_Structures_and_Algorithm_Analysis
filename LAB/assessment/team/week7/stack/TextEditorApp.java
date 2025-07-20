import java.util.Scanner;

// Node class untuk menyimpan data dalam linked list
class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

// Stack class berbasis Linked List
class TextStack {
    private Node top;

    public TextStack() {
        top = null;
    }

    public void push(String data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) return null;
        String data = top.getData();
        top = top.getNext();
        return data;
    }

    public String peek() {
        return (top != null) ? top.getData() : null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
    }
}

// Editor teks dengan fitur Undo/Redo
class TextEditor {
    private String currentText = "";
    private TextStack undoStack = new TextStack();
    private TextStack redoStack = new TextStack();

    public void addText(String newText) {
        undoStack.push(currentText);
        currentText += newText;
        redoStack.clear(); // clear redo history
        System.out.println("Teks saat ini: \"" + currentText + "\"");
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText);
            currentText = undoStack.pop();
            System.out.println("Undo: \"" + currentText + "\"");
        } else {
            System.out.println("Tidak ada aksi untuk di-undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText);
            currentText = redoStack.pop();
            System.out.println("Redo: \"" + currentText + "\"");
        } else {
            System.out.println("Tidak ada aksi untuk di-redo.");
        }
    }
}

// Kelas utama untuk menjalankan program
public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Editor Teks ---");
            System.out.println("1. Tambah Teks");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka antara 1-4: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // buang newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan teks: ");
                    String input = scanner.nextLine();
                    editor.addText(input);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    System.out.println("Keluar dari editor.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
