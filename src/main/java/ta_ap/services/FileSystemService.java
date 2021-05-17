package ta_ap.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    public static String APPLICATION_FOLDER = ".registration-example";
    private static final String USER_FOLDER = System.getProperty("user.home");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        return getApplicationHomePath().resolve(Paths.get(".", path));
    }

    public static Path getApplicationHomePath() {
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }

    public static File initApplicationHomeDirIfNeeded() {
        if (!Files.exists(getApplicationHomePath()))
            getApplicationHomePath().toFile().mkdirs();
        return null;
    }
}
