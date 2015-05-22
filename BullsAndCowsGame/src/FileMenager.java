import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileMenager {
    @SuppressWarnings("resource")
    public static <E> void serialize(List<E> list, String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(list);
        }
    }

    @SuppressWarnings({ "resource", "unchecked" })
    public static <E> List<E> deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(fileName)) {
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            List<E> players = (List<E>) objIn.readObject();
            return players;
        }
    }
}
