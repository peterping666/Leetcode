package OOD.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private final Directory root;

    public FileSystem() {
        root = new Directory("/", null);
    }

    // resolve a path like foo/bar
    private List<Entry> resolve(String path) {
        assert path.startsWith("/");
        String[] components = path.substring(1).split("/");
        List<Entry> entries = new ArrayList<>();
        entries.add(root);
        Entry entry = root;
        for(String component : components) {
            if(entry == null || !(entry instanceof Directory)) {
                throw new IllegalArgumentException("invalid input" + path);
            }
            if(!component.isEmpty()) {
                entry = ((Directory) entry).getChild(component);
                entries.add(entry);
            }
        }
        return entries;
    }

    public void mkdir(String path) {
        List<Entry> entries = resolve(path);
        if(entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("Directory already exsists" + path);
        }
        String[] components = path.split("/");
        final String dirName = components[components.length - 1];
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        Directory newDir = new Directory(dirName, parent);
        parent.addEntry(newDir);
    }

    public void creatFile(String path) {
        assert !path.endsWith("/");
        List<Entry> entries = resolve(path);
        if(entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("File already exsists" + path);
        }
        final String fileName = path.substring(path.lastIndexOf("/") + 1);
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        File file = new File(fileName, parent, 0);
        parent.addEntry(file);
    }

    public void delete(String path) {
        // TODO: delete the file/directory with the given path
    }

    public Entry[] list (String path) {
        // TODO: list all the immediate children of the directory specified by the path
        return null;
    }

    public int count() {
        // TODO: return the total number of files/directory in the FileSystem
    }
}

abstract class Entry {
    protected String name;
    protected Directory parent;
    protected long created;

//    public Entry() {
//        name = "";
//        parent = null;
//    }
    Entry(String n, Directory p) {
        name = n;
        parent = p;
        created  = System.currentTimeMillis();
    }

//    public Boolean delete() {
//        if(parent == null) {
//            return false;
//        }
//        return parent.deleteEntry(this);
//    }

    public abstract int size();

    public String getFullPath() {
        if(parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }

    public void changeName(String newName) {
        name = newName;
    }
}

class File extends Entry{
    private String content; // or byte[]
    private int size;

    public File(String n, Directory p, int s) {
        super(n, p);
        size = s;
    }

    public int size() {
        return size;
    }
}

class Directory extends Entry{
    List<Entry> contents;

    public Directory(String n, Directory p) {
        super(n, p);
        contents = new ArrayList<>();
    }
    public int size() {
        int size = 0;
        for(Entry e : contents) {
            size += e.size();
        }
        return size;
    }

    public int numOfFiles() {
        int count = 0;
        for(Entry e : contents) {
            count++;
            if(e instanceof Directory) {
                Directory d = (Directory) e;
                count += d.numOfFiles();
            }
        }
        return count;
    }

    public boolean deleteEntry(Entry e) {
        return contents.remove(e);
    }

    public void addEntry(Entry e) {
        contents.add(e);
    }
}

