public class Resource {
    private String fileName;
    private String extension;

    public Resource(String fileName, String extension) {
        this.extension = extension;
        this.fileName = fileName;
    }

    public boolean isPDF() {
        return extension == "PDF" || extension == "pdf";
    }

    public boolean equals(Object obj) {
        if (! (obj instanceof Resource))
            return false;

        Resource res = (Resource) obj;

        return fileName == res.fileName && extension == res.extension;
    }
}
