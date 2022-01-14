package OOD.LinuxFind;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    List<Filter> filters;
    public FileSystem() {
        filters = new ArrayList<>();
    }

    public void addFilter(Filter f) {
        filters.add(f);
    }

    public List<File> applyOrFilter(File root) {
        List<File> res = new ArrayList<>();
        if(root.isDirectory) {
            for (File child : root.children) {
                res.addAll(applyOrFilter(child));
            }
        } else {
            for(Filter f : filters) {
                if (f.apply(root)) {
                    res.add(root);
                    break;
                }
            }
        }
        return res;
    }

    public List<File> applyAndFilter(File root) {
        List<File> res = new ArrayList<>();
        if(root.isDirectory) {
            for (File child : root.children) {
                res.addAll(applyAndFilter(child));
            }
        } else {
            for(Filter f : filters) {
                if (!f.apply(root)) {
                    return new ArrayList<>();
                }
            }
            res.add(root);
        }
        return res;
    }
}

abstract class Filter {
    abstract boolean apply(File file);
}

class MinSizeFilter extends Filter {
    int size;

    MinSizeFilter(int s) {
        size = s;
    }
    //@override
    public boolean apply(File file) {
        return file.size > size;
    }
}

class ExtensionFilter {
    String extension;

    ExtensionFilter(String e) {
        extension = e;
    }

    public boolean apply(File file) {
        return extension.equals(file.extension);
    }
}

class File {
    String name;
    int size;
    List<File> children;
    boolean isDirectory;
    String extension;

    File(String n, int s) {
        name = n;
        size = s;
        children = new ArrayList<>();
        isDirectory = name.contains(".");
        extension = name.substring(name.lastIndexOf('.') + 1);
    }
}
